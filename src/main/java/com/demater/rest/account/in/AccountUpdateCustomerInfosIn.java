package com.demater.rest.account.in;

import com.demater.core.domain.customer.CustomerType;

import java.util.UUID;

public record AccountUpdateCustomerInfosIn(
        UUID id,
        String firstName,
        String lastNames,
        String matherFullNames
) {
}
