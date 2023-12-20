package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetUpdatingEvent;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.CustomerRepository;
import com.demater.core.port.GadgetRepository;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateWithIinfosOfCustomerUserCase {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Account execute(UUID id, Account account) {
        Account accountToUpdate = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account ID=[" + id + "] don't exists"));

        /*GadgetType gadgetType = gadgetTypeRepository.findById(gadget.getType().getId())
                .orElseThrow(() -> new GadgetTypeNotFoundException("Gadget type ID=[" + gadget.getType().getId() + "] don't exists"));*/

        if (!accountToUpdate.getBusinessKey().equalsIgnoreCase(account.getBusinessKey()) &&
                accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())) {
            throw new GadgetAlreadyExistsException("Account [" + account.getBusinessKey() + "] already exists");
        }

        accountToUpdate.UpdateWithIinfosOfCustomer(
                account.getBusinessKey(),
                account.getCustomer(),
                account.getCoOwners()
        );
        Account accountSaved = accountRepository.save(accountToUpdate);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return accountToUpdate;
    }
}
