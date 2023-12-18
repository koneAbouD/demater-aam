package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Account execute(Account account) {
        if (accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())) {
            throw new GadgetTypeAlreadyExistsException("Account [" + account.getBusinessKey() + "] already exists");
        }
        AccountType accountType = accountTypeRepository.findById(account.getType().getId())
                .orElseThrow(() -> new AccountNotFoundException("Account type ID=[" + account.getType().getId() + "] don't exists"));
        account.setType(accountType);
        Account accountSaved = accountRepository.save(account);
        //gadgetEventPublisher.publishGadgetTypeCreatingEvent(new GadgetTypeCreatingEvent(name));
        return account;
    }
}
