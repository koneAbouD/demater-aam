package com.demater.rest.customer.in;

import com.demater.core.domain.reference.Address;

public record CustomerCoordinatedIn(
        String numTelephone,
        String email,
        Address address

) {
}
