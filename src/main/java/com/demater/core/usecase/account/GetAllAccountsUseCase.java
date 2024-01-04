package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.event.account.AccountsGettingEvent;
import com.demater.core.port.AccountRepository;
import com.demater.core.publisher.AccountEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllAccountsUseCase {
    private final AccountRepository accountRepository;
    private final AccountEventPublisher accountEventPublisher;

    public List<Account> execute() {
        List<Account> accounts = accountRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(a -> a.getBusinessKey()))
            .toList();
        accountEventPublisher.publishAccountsGetting(new AccountsGettingEvent());
        return accounts;
    }
}
