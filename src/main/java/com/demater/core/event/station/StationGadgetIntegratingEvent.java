package com.demater.core.event.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StationGadgetIntegratingEvent {
    private UUID id;
    private List<String> gadgetsName;
    private LocalDateTime date;

    public StationGadgetIntegratingEvent(UUID id, List<String> gadgetsName) {
        this.id = id;
        this.gadgetsName = gadgetsName;
        this.date = now();
    }
}
