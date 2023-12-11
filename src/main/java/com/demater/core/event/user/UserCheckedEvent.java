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
public class UserCheckedEvent {
    private User user;
    private LocalDateTime date;

    public UserCheckedEvent(User user){
        this.user = user;
        date = now();
    }
}
