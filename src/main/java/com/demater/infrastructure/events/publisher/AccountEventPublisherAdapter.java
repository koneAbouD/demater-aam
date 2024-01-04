package com.demater.infrastructure.events.publisher;

import com.demater.core.event.account.AccountsGettingEvent;
import com.demater.core.publisher.AccountEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class AccountEventPublisherAdapter implements AccountEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishAccountsGetting(AccountsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }
}
