package com.demater.core.event.gadget;

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
public class GadgetCreatingEvent {
    private String designation;
    private LocalDateTime date;

    public GadgetCreatingEvent(String designation) {
        this.designation = designation;
        this.date = now();
    }
}
