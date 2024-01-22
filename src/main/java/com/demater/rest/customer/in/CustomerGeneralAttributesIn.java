package com.demater.rest.customer.in;

import com.demater.core.domain.customer.ELevelStudent;
import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.domain.customer.MaritalStatus;
import com.demater.core.domain.profession.Profession;

public record CustomerGeneralAttributesIn(
        Profession profession,
        ELevelStudent levelStudent,
        MaritalStatus maritalStatus,
        FamilyStatus familyStatus,
        int numbChildrens

) {
}
