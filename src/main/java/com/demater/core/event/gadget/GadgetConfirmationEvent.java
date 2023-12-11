package com.demater.core.event.gadget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GadgetConfirmationEvent {
    private String login;
    private UUID uuid;
    private LocalDateTime date;

    public GadgetConfirmationEvent(String login, UUID uuid) {
        this.login = login;
        this.uuid = uuid;
        this.date = now();
    }
}
