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
import com.demater.core.usecase.account.exception.AccountTypeNotFoundException;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import com.demater.core.usecase.customer.exception.CustomerTypeNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final CustomerTypeRepository customerTypeRepository;

    public Account execute(Account account) {
        if (accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())) {
            throw new AccountAlreadyExistsException("Account [" + account.getBusinessKey() + "] already exists");
        }
        AccountType accountType = accountTypeRepository.findById(account.typeId())
                .orElseThrow(() -> new AccountTypeNotFoundException("Account type ID=[" + account.typeId() + "] don't exists"));

        CustomerType customerType = customerTypeRepository.findById(account.customerTypeId())
                .orElseThrow(() -> new CustomerTypeNotFoundException("Customer type ID=[" + account.customerTypeId() + "] don't exists"));

        Customer customer = Customer.builder()
                .type(customerType)
                .professions(account.profession())
                .legalCapacity(account.legalCapacity())
                .build();

        account.createAccount(accountType, customer, account.getMotif());
        Account accountToSave = accountRepository.save(account);
        return accountToSave;
    }
}
