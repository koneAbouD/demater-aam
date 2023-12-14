package com.demater.rest.account.in;

public record AccountCreateIn(
        String businessKey,
        String designation,
        String accountCode
) {
}
