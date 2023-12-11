package com.demater.core.event.user;

import com.demater.core.domain.auth.UserCredentials;
import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAuthenticatedEvent {
    private UserCredentials user;
    private LocalDateTime date;
    public UserAuthenticatedEvent(UserCredentials user) {
        this.user = user;
        this.date = now();
    }
}
