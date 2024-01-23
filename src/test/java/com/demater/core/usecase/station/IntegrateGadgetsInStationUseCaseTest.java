package com.demater.core.usecase.station;

import com.demater.builder.GadgetMB;
import com.demater.builder.StationGadgetMB;
import com.demater.builder.StationMB;
import com.demater.core.exception.InsufficientGadgetException;
import com.demater.core.exception.UnavailableGadgetException;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetAndNumber;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.event.station.StationGadgetIntegratingEvent;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Set;
import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class IntegrateGadgetsInStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private StationGadgetRepository stationGadgetRepository;
    @Mock
    private GadgetRepository gadgetRepository;
    @Mock
    private GadgetConfirmationRepository gadgetConfirmationRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private IntegrateGadgetsInStationUseCase integrateGadgetsInStation;

    @BeforeEach
    void setUp() {
        integrateGadgetsInStation = new IntegrateGadgetsInStationUseCase(
                stationRepository,
                stationGadgetRepository,
                gadgetRepository,
                gadgetConfirmationRepository,
                stationEventPublisher
        );
    }

    @Test
    void should_throw_when_integrate_gadget_with_station_dont_exists() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Gadget gadget = new GadgetMB().withId(gadgetId).withDesignation("bbb").build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, 4L));
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of());
        when(stationRepository.findById(stationId)).thenReturn(empty());

        // When
        Exception exception = assertThrows(StationNotFoundException.class, () -> integrateGadgetsInStation.execute(stationId, gadgetAndNumbers));

        // Then
        assertEquals("Station avec ID[" + stationId + "] non trouvée", exception.getMessage());
        verify(stationRepository).findById(stationId);
        verify(gadgetConfirmationRepository, never()).saveAll(anyList());
        verify(stationEventPublisher, never()).publishStationGadgetIntegrating(
                new StationGadgetIntegratingEvent(stationId, gadgetAndNumbers.stream().map(GadgetAndNumber::gadgetName).toList())
        );
    }

    @Test
    void should_throw_when_integrate_gadget_with_gadget_dont_exists() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Station station = new StationMB().withId(stationId).withDesignation("AAA").build();
        Gadget gadget = new GadgetMB().withId(gadgetId).withDesignation("bbb").build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, 4L));
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of());
        when(stationRepository.findById(stationId)).thenReturn(of(station));
        when(gadgetRepository.findById(gadgetId)).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetNotFoundException.class, () -> integrateGadgetsInStation.execute(stationId, gadgetAndNumbers));

        // Then
        assertEquals("Gadget avec ID[" + gadgetId + "] non trouvé", exception.getMessage());
        verify(stationGadgetRepository).findAllByStationAndGadgetIn(stationId, gadgetsIds);
        verify(stationRepository).findById(stationId);
        verify(gadgetRepository).findById(gadgetId);
        verify(gadgetConfirmationRepository, never()).saveAll(anyList());
        verify(stationEventPublisher, never()).publishStationGadgetIntegrating(
                new StationGadgetIntegratingEvent(stationId, gadgetAndNumbers.stream().map(GadgetAndNumber::gadgetName).toList())
        );
    }

    @Test
    void should_throw_when_integrate_gadget_with_gadget_unavailable() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Long gadgetNumber = 4L;
        String gadgetDesignation = "bbb";
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Station station = new StationMB().withId(stationId).withDesignation("AAA").build();
        Gadget gadget = new GadgetMB().withId(gadgetId)
                .withDesignation(gadgetDesignation).withAvailable(false)
                .withTotalNumber(10L).withRemainingNumber(10L).build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, gadgetNumber));
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of());
        when(stationRepository.findById(stationId)).thenReturn(of(station));
        when(gadgetRepository.findById(gadgetId)).thenReturn(of(gadget));
        doCallRealMethod().when(gadget).gadgetToStation(gadgetNumber);

        // When
        Exception exception = assertThrows(UnavailableGadgetException.class, () -> integrateGadgetsInStation.execute(stationId, gadgetAndNumbers));

        // Then
        assertEquals("Unavailable Gadget [" + gadgetDesignation + "]", exception.getMessage());
        verify(stationGadgetRepository).findAllByStationAndGadgetIn(stationId, gadgetsIds);
        verify(stationRepository).findById(stationId);
        verify(gadgetRepository).findById(gadgetId);
        verify(gadget).gadgetToStation(gadgetNumber);
        verify(gadgetConfirmationRepository, never()).saveAll(anyList());
        verify(stationEventPublisher, never()).publishStationGadgetIntegrating(
                new StationGadgetIntegratingEvent(stationId, gadgetAndNumbers.stream().map(GadgetAndNumber::gadgetName).toList())
        );
    }

    @Test
    void should_throw_when_integrate_gadget_with_gadget_insufficient() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Long gadgetNumber = 4L;
        String gadgetDesignation = "bbb";
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Station station = new StationMB().withId(stationId).withDesignation("AAA").build();
        Gadget gadget = new GadgetMB().withId(gadgetId)
                .withDesignation(gadgetDesignation).withAvailable(true)
                .withTotalNumber(10L).withRemainingNumber(1L).build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, gadgetNumber));
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of());
        when(stationRepository.findById(stationId)).thenReturn(of(station));
        when(gadgetRepository.findById(gadgetId)).thenReturn(of(gadget));
        doCallRealMethod().when(gadget).gadgetToStation(gadgetNumber);

        // When
        Exception exception = assertThrows(InsufficientGadgetException.class, () -> integrateGadgetsInStation.execute(stationId, gadgetAndNumbers));

        // Then
        assertEquals("Insufficient Gadget [" + gadgetDesignation + "] ;  Remaining Number = " +
                gadget.getRemainingNumber(), exception.getMessage());
        verify(stationGadgetRepository).findAllByStationAndGadgetIn(stationId, gadgetsIds);
        verify(stationRepository).findById(stationId);
        verify(gadgetRepository).findById(gadgetId);
        verify(gadget).gadgetToStation(gadgetNumber);
        verify(gadgetConfirmationRepository, never()).saveAll(anyList());
        verify(stationEventPublisher, never()).publishStationGadgetIntegrating(
                new StationGadgetIntegratingEvent(stationId, gadgetAndNumbers.stream().map(GadgetAndNumber::gadgetName).toList())
        );
    }

    @Test
    void should_integrate_gadget() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Long gadgetNumber = 4L;
        String gadgetDesignation = "bbb";
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Station station = new StationMB().withId(stationId).withDesignation("AAA").build();
        Gadget gadget = new GadgetMB().withId(gadgetId)
                .withDesignation(gadgetDesignation).withAvailable(true)
                .withTotalNumber(10L).withRemainingNumber(10L).build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, gadgetNumber));
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of());
        when(stationRepository.findById(stationId)).thenReturn(of(station));
        when(gadgetRepository.findById(gadgetId)).thenReturn(of(gadget));
        doNothing().when(gadget).gadgetToStation(gadgetNumber);

        // When
        integrateGadgetsInStation.execute(stationId, gadgetAndNumbers);

        // Then
        verify(stationGadgetRepository).findAllByStationAndGadgetIn(stationId, gadgetsIds);
        verify(stationRepository).findById(stationId);
        verify(gadgetRepository).findById(gadgetId);
        verify(gadget).gadgetToStation(gadgetNumber);
        verify(gadgetConfirmationRepository).saveAll(anyList());
        verify(stationEventPublisher).publishStationGadgetIntegrating(any());
    }

    @Test
    void should_integrate_gadget_with_gadget_already_exists() {
        // Given
        UUID stationId = UUID.randomUUID();
        UUID gadgetId = UUID.randomUUID();
        Long gadgetNumber = 4L;
        String gadgetDesignation = "bbb";
        Set<UUID> gadgetsIds = Set.of(gadgetId);
        Station station = new StationMB().withId(stationId).withDesignation("AAA").build();
        Gadget gadget = new GadgetMB().withId(gadgetId)
                .withDesignation(gadgetDesignation).withAvailable(true)
                .withTotalNumber(10L).withRemainingNumber(10L).build();
        Set<GadgetAndNumber> gadgetAndNumbers = Set.of(new GadgetAndNumber(gadget, gadgetNumber));
        StationGadget stationGadget = new StationGadgetMB().withGadget(gadget)
                .withGadgetNumber(4L).build();
        when(stationGadget.stationId()).thenReturn(stationId);
        when(stationGadget.gadgetId()).thenReturn(gadgetId);
        when(stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds)).thenReturn(Set.of(stationGadget));
        when(stationRepository.findById(stationId)).thenReturn(of(station));
        when(gadgetRepository.findById(gadgetId)).thenReturn(of(gadget));
        doNothing().when(gadget).gadgetToStation(gadgetNumber);
        doNothing().when(stationGadget).updateGadgetNumber(gadgetNumber);

        // When
        integrateGadgetsInStation.execute(stationId, gadgetAndNumbers);

        // Then
        verify(stationGadgetRepository).findAllByStationAndGadgetIn(stationId, gadgetsIds);
        verify(stationRepository).findById(stationId);
        verify(gadgetRepository).findById(gadgetId);
        verify(gadget).gadgetToStation(gadgetNumber);
        verify(stationGadget).updateGadgetNumber(gadgetNumber);
        verify(gadgetConfirmationRepository).saveAll(anyList());
        verify(stationEventPublisher).publishStationGadgetIntegrating(any());
    }
}
