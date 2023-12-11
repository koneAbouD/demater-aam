package com.demater.core.event.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRemovingFromStationEvent {
    private UUID stationId;
    private Set<String> usersLogin;
    private LocalDateTime date;

    public UserRemovingFromStationEvent(UUID stationId, Set<String> usersLogin) {
        this.stationId = stationId;
        this.usersLogin = usersLogin;
        this.date = now();
    }
}
