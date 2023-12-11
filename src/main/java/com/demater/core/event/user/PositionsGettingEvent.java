package com.demater.core.event.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class PositionsGettingEvent {
    private LocalDateTime date;

    public PositionsGettingEvent() {
        this.date = now();
    }
}
