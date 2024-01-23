package com.demater.core.usecase.station;

import com.demater.builder.RoleMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.station.UserAddingToStationEvent;
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

import static com.demater.core.domain.user.ERole.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class AddUsersToStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private AddUsersToStationUseCase addUsersToStation;

    @BeforeEach
    void setUp() {
        addUsersToStation = new AddUsersToStationUseCase(stationRepository, userRepository, stationEventPublisher);
    }

    @Test
    void should_throw_when_add_users_to_station_with_station_dont_exists() {
        // Given
        UUID id = UUID.randomUUID();
        when(stationRepository.findById(id)).thenReturn(empty());

        // When
        Exception exception = assertThrows(StationNotFoundException.class, () -> addUsersToStation.execute(id, Set.of()));

        // Then
        assertEquals("Station [" + id + "] not found", exception.getMessage());
        verify(stationRepository).findById(id);
        verify(userRepository, never()).updateUsersStation(any(), any());
        verify(stationEventPublisher, never()).publishUsersAddingToStation(new UserAddingToStationEvent(id, Set.of()));
    }

    @Test
    void should_throw_when_add_users_to_station_with_users_dont_exist() {
        // Given
        UUID id = UUID.randomUUID();
        Station station = new Station();
        Set<String> usersLogin = Set.of("a", "b", "c");
        when(stationRepository.findById(id)).thenReturn(of(station));
        when(userRepository.findByLoginIn(usersLogin)).thenReturn(Collections.emptySet());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> addUsersToStation.execute(id, usersLogin));

        // Then
        assertEquals("Users " + usersLogin + " not found.", exception.getMessage());
        verify(stationRepository).findById(id);
        verify(userRepository).findByLoginIn(usersLogin);
        verify(userRepository, never()).updateUsersStation(usersLogin, id);
        verify(stationEventPublisher, never()).publishUsersAddingToStation(new UserAddingToStationEvent(id, Set.of()));
    }

    @Test
    void should_add_users_to_station() {
        // Given
        UUID id = UUID.randomUUID();
        Role role1 = new RoleMB().withName(ROLE_USER).build();
        Role role2 = new RoleMB().withName(ROLE_ADMIN).build();
        Role role3 = new RoleMB().withName(ROLE_MANAGER).build();
        User user1 = new UserMB().withLogin("a").withRoles(Set.of(role1)).build();
        User user2 = new UserMB().withLogin("b").withRoles(Set.of(role2)).build();
        User user3 = new UserMB().withLogin("c").withRoles(Set.of(role3)).build();
        Station station = new Station();
        Set<String> usersLogin = Set.of("a", "b", "c");

        when(user1.hasRoleSuperAdminOrAdmin()).thenReturn(false);
        when(user2.hasRoleSuperAdminOrAdmin()).thenReturn(true);
        when(user3.hasRoleSuperAdminOrAdmin()).thenReturn(false);
        when(stationRepository.findById(id)).thenReturn(of(station));
        when(userRepository.findByLoginIn(usersLogin)).thenReturn(Set.of(user1, user2, user3));

        // When
        addUsersToStation.execute(id, usersLogin);

        // Then
        verify(stationRepository).findById(id);
        verify(userRepository).findByLoginIn(usersLogin);
        assertThat(station.getUsers()).hasSize(2).contains(user1, user3);
        verify(userRepository).updateUsersStation(Set.of("a", "c"), id);
        verify(stationEventPublisher, never()).publishUsersAddingToStation(new UserAddingToStationEvent(id, usersLogin));
    }
}
