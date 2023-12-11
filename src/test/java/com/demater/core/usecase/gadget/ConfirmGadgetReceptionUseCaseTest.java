package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetConfirmationMB;
import com.demater.builder.GadgetMB;
import com.demater.builder.StationGadgetMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.domain.user.User;
import com.demater.core.event.gadget.GadgetConfirmationEvent;
import com.demater.core.port.GadgetConfirmationRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetConfirmationException;
import com.demater.core.usecase.gadget.exception.GadgetConfirmationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class ConfirmGadgetReceptionUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private GadgetConfirmationRepository gadgetConfirmationRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private ConfirmGadgetReceptionUseCase confirmReception;

    @BeforeEach
    void setUp() {
        confirmReception = new ConfirmGadgetReceptionUseCase(userRepository,
                gadgetConfirmationRepository,
                gadgetEventPublisher);
    }

    @Test
    void should_throw_when_confirm_reception_with_user_not_found() {
        // Given
        UUID uuid = UUID.randomUUID();
        String login = "dsoumaila";
        when(userRepository.findByEmailOrLogin(login)).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> confirmReception.execute(login, uuid));

        // Then
        assertEquals("User [" + login + "] ot found", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(login);
        verify(gadgetConfirmationRepository, never()).save(any());
        verify(gadgetEventPublisher, never()).publishGadgetReception(new GadgetConfirmationEvent(login, uuid));
    }

    @Test
    void should_throw_when_confirm_reception_with_gadget_sent_not_found() {
        // Given
        UUID uuid = UUID.randomUUID();
        String login = "dsoumaila";
        User user = new UserMB().withLogin(login).build();
        when(userRepository.findByEmailOrLogin(login)).thenReturn(of(user));
        when(gadgetConfirmationRepository.findById(uuid)).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetConfirmationNotFoundException.class, () -> confirmReception.execute(login, uuid));

        // Then
        assertEquals("Gadget confirmation [" + uuid + "] not found", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(login);
        verify(gadgetConfirmationRepository).findById(uuid);
        verify(gadgetConfirmationRepository, never()).save(any());
        verify(gadgetEventPublisher, never()).publishGadgetReception(new GadgetConfirmationEvent(login, uuid));
    }

    @Test
    void should_throw_when_confirm_reception_with_user_not_in_station() {
        // Given
        UUID uuid = UUID.randomUUID();
        String login = "dsoumaila";
        String stationName = "station 1";
        User user = new UserMB().withLogin(login).build();
        Gadget gadget = new GadgetMB().withId(UUID.randomUUID())
                .withDesignation("gadget 1").withAvailable(true).build();
        StationGadget stationGadget = new StationGadgetMB().withGadget(gadget).build();
        GadgetConfirmation gadgetConfirmation = new GadgetConfirmationMB().withId(uuid)
                .withStationGadget(stationGadget).build();
        when(stationGadget.hasUserInStation(user)).thenReturn(false);
        when(stationGadget.stationName()).thenReturn(stationName);
        when(userRepository.findByEmailOrLogin(login)).thenReturn(of(user));
        when(gadgetConfirmationRepository.findById(uuid)).thenReturn(of(gadgetConfirmation));

        // When
        Exception exception = assertThrows(GadgetConfirmationException.class, () -> confirmReception.execute(login, uuid));

        // Then
        assertEquals("User [" + login + "] can't confirm gadget reception for station [" + stationName + "]", exception.getMessage());
        verify(stationGadget).hasUserInStation(user);
        verify(userRepository).findByEmailOrLogin(login);
        verify(gadgetConfirmationRepository).findById(uuid);
        verify(gadgetConfirmationRepository, never()).save(any());
        verify(gadgetEventPublisher, never()).publishGadgetReception(new GadgetConfirmationEvent(login, uuid));
    }

    @Test
    void should_confirm_reception() {
        // Given
        UUID uuid = UUID.randomUUID();
        String login = "dsoumaila";
        String stationName = "station 1";
        User user = new UserMB().withLogin(login).build();
        Gadget gadget = new GadgetMB().withId(UUID.randomUUID()).withDesignation("gadget 1").withAvailable(true).build();
        StationGadget stationGadget = new StationGadgetMB().withGadget(gadget).build();
        GadgetConfirmation gadgetConfirmation = new GadgetConfirmationMB().withId(uuid).withStationGadget(stationGadget).build();
        when(stationGadget.hasUserInStation(user)).thenReturn(true);
        when(stationGadget.stationName()).thenReturn(stationName);
        when(userRepository.findByEmailOrLogin(login)).thenReturn(of(user));
        when(gadgetConfirmationRepository.findById(uuid)).thenReturn(of(gadgetConfirmation));
        doNothing().when(gadgetConfirmation).receive(user);

        // When
        confirmReception.execute(login, uuid);

        // Then
        verify(stationGadget).hasUserInStation(user);
        verify(userRepository).findByEmailOrLogin(login);
        verify(gadgetConfirmationRepository).findById(uuid);
        verify(gadgetConfirmation).receive(user);
        verify(gadgetConfirmationRepository).save(gadgetConfirmation);
        verify(gadgetEventPublisher, never()).publishGadgetReception(new GadgetConfirmationEvent(login, uuid));
    }
}
