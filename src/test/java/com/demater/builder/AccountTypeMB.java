package com.demater.builder;

import com.demater.core.domain.account.AccountType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountTypeMB {
    private AccountType accountType;

    public AccountTypeMB() {
        accountType = mock(AccountType.class);
    }

    public AccountTypeMB withId(Long id) {
        when(accountType.getId()).thenReturn(id);
        return this;
    }

    public AccountTypeMB withCode(String code) {
        when(accountType.getCode()).thenReturn(code);
        return this;
    }

    public AccountTypeMB withName(String name) {
        when(accountType.getName()).thenReturn(name);
        return this;
    }

    public AccountType build() {
        return accountType;
    }
}
