package com.demater.core.event.gadget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class GadgetsGettingEvent {
    private LocalDateTime date;

    public GadgetsGettingEvent() {
        this.date = now();
    }
}
