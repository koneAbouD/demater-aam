package com.demater.core.event.folder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class FoldersGettingEvent {
    private LocalDateTime date;

    public FoldersGettingEvent() {
        this.date = now();
    }
}
