package com.demater.core.usecase.station;

import com.demater.builder.UserMB;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.user.User;
import com.demater.core.event.station.UserRemovingFromStationEvent;
import com.demater.core.port.StationRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Collections;
import java.util.Set;
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
class RemoveUsersFromStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private RemoveUsersFromStationUseCase removeUsersFromStation;

    @BeforeEach
    void setUp() {
        removeUsersFromStation = new RemoveUsersFromStationUseCase(stationRepository, userRepository, stationEventPublisher);
    }

    @Test
    void should_throw_when_remove_users_from_station_with_station_dont_exists() {
        // Given
        UUID id = UUID.randomUUID();
        when(stationRepository.findById(id)).thenReturn(empty());

        // When
        Exception exception = assertThrows(StationNotFoundException.class, () -> removeUsersFromStation.execute(id, Set.of()));

        // Then
        assertEquals("Station [" + id + "] not found", exception.getMessage());
        verify(stationRepository).findById(id);
        verify(userRepository, never()).updateUsersStation(any(), any());
        verify(stationEventPublisher, never()).publishUsersRemovingFromStation(new UserRemovingFromStationEvent(id, Set.of()));
    }

    @Test
    void should_throw_when_remove_users_from_station_with_users_dont_exist() {
        // Given
        UUID id = UUID.randomUUID();
        Station station = new Station();
        Set<String> usersLogin = Set.of("a", "b", "c");
        when(stationRepository.findById(id)).thenReturn(of(station));
        when(userRepository.findByLoginIn(usersLogin)).thenReturn(Collections.emptySet());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> removeUsersFromStation.execute(id, usersLogin));

        // Then
        assertEquals("Users " + usersLogin + " not found.", exception.getMessage());
        verify(userRepository, never()).updateUsersStation(any(), any());
        verify(stationEventPublisher, never()).publishUsersRemovingFromStation(new UserRemovingFromStationEvent(id, Set.of()));
    }

    @Test
    void should_remove_users_from_station() {
        // Given
        UUID id = UUID.randomUUID();
        User user1 = new UserMB().withLogin("a").build();
        User user2 = new UserMB().withLogin("b").build();
        User user3 = new UserMB().withLogin("c").build();
        Station station = new Station();
        station.setUsers(Set.of(user1, user2, user3));
        Set<String> usersLogin = Set.of(user1.getLogin(), user2.getLogin());

        when(stationRepository.findById(id)).thenReturn(of(station));
        when(userRepository.findByLoginIn(usersLogin)).thenReturn(Set.of(user1, user2));

        // When
        removeUsersFromStation.execute(id, usersLogin);

        // Then
        verify(stationRepository).findById(id);
        verify(userRepository).findByLoginIn(usersLogin);
        verify(userRepository).updateUsersStation(usersLogin, null);
        verify(stationEventPublisher).publishUsersRemovingFromStation(any());
    }
}
