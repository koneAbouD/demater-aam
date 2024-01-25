package com.demater.rest.account.out;

import com.demater.rest.common.out.CustomerOut;

import java.util.UUID;

public record AccountOut(
        UUID id,
        String businessKey,
        String designation,
        String accountCode,
        String status,
        CustomerOut customer) {
}
