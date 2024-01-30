package com.demater.builder;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.account.EStatus;
import com.demater.core.domain.customer.Customer;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountMB {
    private Account account;

    public AccountMB() {
        account = mock(Account.class);
    }

    public AccountMB withId(UUID id) {
        when(account.getId()).thenReturn(id);
        return this;
    }

    public AccountMB withBusinessKey(String businessKey) {
        when(account.getBusinessKey()).thenReturn(businessKey);
        return this;
    }
    public AccountMB withDesignation(String designation) {
        when(account.getDesignation()).thenReturn(designation);
        return this;
    }
    public AccountMB withCode(String code) {
        when(account.getCode()).thenReturn(code);
        return this;
    }
    public AccountMB withCustomer(Customer customer) {
        when(account.getCustomer()).thenReturn(customer);
        return this;
    }
    public AccountMB withType(AccountType type) {
        when(account.getType()).thenReturn(type);
        return this;
    }

    public AccountMB withStatus(EStatus status) {
        when(account.getStatus()).thenReturn(status);
        return this;
    }

    public Account build() {
        return account;
    }
}
