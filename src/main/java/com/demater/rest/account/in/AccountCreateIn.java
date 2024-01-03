package com.demater.rest.account.in;

import com.demater.core.domain.account.AccountType;

public record AccountCreateIn(
        String businessKey,
        String designation,
        AccountTypeIn type,
        CustomerIn customer
) {
}
