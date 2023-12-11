package com.demater.core.event.referential;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class CitiesGettingEvent {
    private LocalDateTime date;

    public CitiesGettingEvent() {
        this.date = now();
    }
}
