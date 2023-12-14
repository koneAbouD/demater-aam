package com.demater.core.usecase.account;

import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountTypeUseCase {
    private final AccountTypeRepository accountTypeRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public AccountType execute(String name) {
        if (accountTypeRepository.existsByDesignationIgnoreCase(name)) {
            throw new GadgetTypeAlreadyExistsException("Account type [" + name + "] already exists");
        }

        AccountType accountType = accountTypeRepository.save(new AccountType(name));
        //gadgetEventPublisher.publishGadgetTypeCreatingEvent(new GadgetTypeCreatingEvent(name));
        return accountType;
    }
}
