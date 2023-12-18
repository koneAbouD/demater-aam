package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllAccountTypeUseCase {
    private final AccountTypeRepository accountTypeRepository;

    public List<AccountType> execute() {
        List<AccountType> accountTypes = accountTypeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getDesignation()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return accountTypes;
    }
}
