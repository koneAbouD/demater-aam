package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.folder.Folder;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.FolderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllAccountsUseCase {
    private final AccountRepository accountRepository;
    //private final AccountsEventPublisher accountsEventPublisher;

    public List<Account> execute() {
        List<Account> accounts = accountRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(r -> r.getBusinessKey()))
            .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return accounts;
    }
}
