package com.demater.core.event.user;

import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordMailSentEvent {
    private String email;
    private LocalDateTime date;

    public ResetPasswordMailSentEvent(String email) {
        this.email = email;
        this.date = now();
    }
}
