package com.demater.core.event.user;

import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordEvent {
    private String email;
    private LocalDateTime date;

    public ResetPasswordEvent(String email) {
        this.email = email;
        this.date = now();
    }
}
