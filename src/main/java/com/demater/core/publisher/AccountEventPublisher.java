package com.demater.core.publisher;

import com.demater.core.event.account.AccountsGettingEvent;

public interface AccountEventPublisher {
    void publishAccountsGetting(AccountsGettingEvent event);
}
