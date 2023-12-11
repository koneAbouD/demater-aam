package com.demater.core.event.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class StationsImportingEvent {
    private LocalDateTime date;

    public StationsImportingEvent() {
        this.date = now();
    }
}
