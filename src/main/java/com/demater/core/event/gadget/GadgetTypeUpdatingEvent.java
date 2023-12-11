package com.demater.core.event.gadget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GadgetTypeUpdatingEvent {
    private String designation;
    private LocalDateTime date;

    public GadgetTypeUpdatingEvent(String designation) {
        this.designation = designation;
        this.date = now();
    }
}
