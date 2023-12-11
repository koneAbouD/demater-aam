package com.demater.core.event.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StationCreatingEvent {
    private String designation;
    private LocalDateTime date;

    public StationCreatingEvent(String designation) {
        this.designation = designation;
        this.date = now();
    }
}
