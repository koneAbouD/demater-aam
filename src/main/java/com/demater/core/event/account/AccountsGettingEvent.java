package com.demater.core.event.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@Getter
public class AccountsGettingEvent {
    private LocalDateTime date;

    public AccountsGettingEvent() {
        this.date = now();
    }
}
