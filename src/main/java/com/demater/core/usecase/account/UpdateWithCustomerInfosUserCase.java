package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.customer.Customer;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.CustomerRepository;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateWithCustomerInfosUserCase {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Account execute(UUID id, Account account) {
        Account accountToUpdate = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account ID=[" + id + "] don't exists"));

        Customer customerToUpdate = customerRepository.findById(accountToUpdate.getCustomer().getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + accountToUpdate.getCustomer().getId() + "] don't exists"));

        if (!accountToUpdate.getBusinessKey().equalsIgnoreCase(account.getBusinessKey()) &&
                accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())) {
            throw new GadgetAlreadyExistsException("Account [" + account.getBusinessKey() + "] already exists");
        }
        customerToUpdate = Customer.builder()
                .id(account.getCustomer().getId())
                .firstName(account.getCustomer().getFirstName())
                .lastNames(account.getCustomer().getLastNames())
                .matherFullNames(account.getCustomer().getMatherFullNames())
                .build();

        accountToUpdate.updateWithCustomerInfos(
                customerToUpdate,
                account.getCoOwners()
        );
        Account accountSaved = accountRepository.save(accountToUpdate);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return accountToUpdate;
    }
}
