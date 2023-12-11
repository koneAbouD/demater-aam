package com.demater.core.event.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class RolesGettingEvent {
    private LocalDateTime date;

    public RolesGettingEvent() {
        this.date = now();
    }
}
