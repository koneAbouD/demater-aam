package com.demater.rest.customer.in;

import com.demater.core.domain.customer.Language;
import com.demater.core.domain.customer.Nationality;

public record CustomerCreateIn(
        String firstName,
        String lastNames,
        String matherFullNames,
        Nationality nationality,
        Language language

) {
}
