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
public class UserProfileUpdatingEvent {
    private LocalDateTime date;
    private String email;
    public UserProfileUpdatingEvent(String email) {
        this.email = email;
        this.date = now();
    }
}
