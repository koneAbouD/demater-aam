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
public class GadgetTypeDeletingEvent {
    private Long id;
    private LocalDateTime date;

    public GadgetTypeDeletingEvent(Long id) {
        this.id = id;
        this.date = now();
    }
}
