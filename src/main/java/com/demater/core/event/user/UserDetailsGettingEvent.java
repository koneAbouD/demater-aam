package com.demater.core.event.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDetailsGettingEvent {
    private String email;
    private LocalDateTime date;

    public UserDetailsGettingEvent(String email) {
        this.email = email;
        this.date = now();
    }
}
