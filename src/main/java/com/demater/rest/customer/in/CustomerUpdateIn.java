package com.demater.rest.customer.in;

import com.demater.rest.account.in.AccountTypeIn;
import com.demater.rest.account.in.CustomerIn;

public record CustomerUpdateIn(
        String firstName,
        String lastNames,
        String numTelephone,
        String email,
        String matherFullNames
) {
}
