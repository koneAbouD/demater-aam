package com.demater.core.event.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdatingByAdminEvent {
    private LocalDateTime date;
    private String login;

    public UserUpdatingByAdminEvent(String login) {
        this.login = login;
        this.date = now();
    }
}
