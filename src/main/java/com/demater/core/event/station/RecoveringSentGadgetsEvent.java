package com.demater.core.event.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class RecoveringSentGadgetsEvent {
    private Map<String, String> query;
    private LocalDateTime date;

    public RecoveringSentGadgetsEvent(Map<String, String> query) {
        this.query = query;
        this.date = now();
    }
}
