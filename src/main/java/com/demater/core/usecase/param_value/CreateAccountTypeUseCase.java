package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountTypeUseCase {
    private final AccountTypeRepository accountTypeRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public AccountType execute(AccountType accountType) {
        if (accountTypeRepository.existsByNameIgnoreCase(accountType.getName())) {
            throw new AccountTypeAlreadyExistsException("Account type [" + accountType.getName() + "] already exists");
        }

        AccountType accountTypeToSave = accountTypeRepository.save(accountType);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return accountTypeToSave;
    }
}
