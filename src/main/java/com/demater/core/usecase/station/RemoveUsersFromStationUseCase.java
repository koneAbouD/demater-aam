package com.demater.core.usecase.station;

import com.demater.core.domain.station.Station;
import com.demater.core.domain.user.User;
import com.demater.core.event.station.UserRemovingFromStationEvent;
import com.demater.core.port.StationRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class RemoveUsersFromStationUseCase {
    private final StationRepository stationRepository;
    private final UserRepository userRepository;
    private final StationEventPublisher stationEventPublisher;

    public Station execute(UUID stationId, Set<String> usersLogin) {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new StationNotFoundException("Station [" + stationId + "] not found"));
        Set<User> users = userRepository.findByLoginIn(usersLogin);
        if (users.isEmpty()) {
            throw new UserNotFoundException("Users " + usersLogin + " not found.");
        }
        users.forEach(station::removeUser);
        userRepository.updateUsersStation(users.stream().map(User::getLogin).collect(toSet()), null);
        stationEventPublisher.publishUsersRemovingFromStation(new UserRemovingFromStationEvent(stationId, usersLogin));
        return station;
    }
}
