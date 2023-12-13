package com.demater.rest.account.in;

import java.util.UUID;

public record AccountIn(
        String businessKey,
        String designation,
        String accountCode
) {
}
