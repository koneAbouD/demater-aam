package com.demater.rest.customer.out;

import com.demater.core.domain.customer.*;
import com.demater.core.domain.profession.Profession;

import java.util.Set;
import java.util.UUID;

public record CustomerOut(
        UUID id,
        CustomerType type,
        String firstName,
        String lastNames,
        String numTelephone,
        String email,
        String matherFullNames,
        ELevelStudent levelStudent,
        LegalCapacity legalCapacity,
        Set<Profession>profession,
        MaritalStatus maritalStatus,
        FamilyStatus familyStatus,
        int numbChildrens,
        String customerCode
) {
}
