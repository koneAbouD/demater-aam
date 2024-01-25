package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllAccountTypeUseCase {
    private final AccountTypeRepository accountTypeRepository;

    public List<AccountType> execute() {
        List<AccountType> accountTypes = accountTypeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return accountTypes;
    }
}
