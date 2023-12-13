package com.demater.rest.account.out;

import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.document.Document;
import com.demater.core.domain.user.Branch;

import java.util.Set;
import java.util.UUID;

public record AccountOut(
        String businessKey,
        String designation,
        String accountCode,
        String status) {
}
