package com.demater.core.usecase.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CustomerTypeRepository;
import com.demater.core.usecase.account.exception.AccountAlreadyExistsException;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final CustomerTypeRepository customerTypeRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Account execute(Account account) {
        if (accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())) {
            throw new AccountAlreadyExistsException("Account [" + account.getBusinessKey() + "] already exists");
        }
        AccountType accountType = accountTypeRepository.findById(account.getType().getId())
                .orElseThrow(() -> new AccountNotFoundException("Account type ID=[" + account.getType().getId() + "] don't exists"));

        CustomerType customerType = customerTypeRepository.findById(account.getCustomer().getType().getId())
                .orElseThrow(() -> new AccountNotFoundException("Customer type ID=[" + account.getCustomer().getType().getId() + "] don't exists"));
        Customer customer = Customer.builder()
                .id(account.getCustomer().getId())
                .type(customerType)
                .profession(account.getCustomer().getProfession())
                .legalCapacity(account.getCustomer().getLegalCapacity())
                .build();

        account.createWithAccountInfos(accountType, customer, account.getMotif());
        Account accountToSave = accountRepository.save(account);
        //gadgetEventPublisher.publishGadgetTypeCreatingEvent(new GadgetTypeCreatingEvent(name));
        return accountToSave;
    }
}
