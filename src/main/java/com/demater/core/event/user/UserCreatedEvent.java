package com.demater.core.event.user;

import com.demater.core.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreatedEvent {
    private User user;
    private LocalDateTime date;

    public UserCreatedEvent(User user){
        this.user = user;
        date = now();
    }
}
