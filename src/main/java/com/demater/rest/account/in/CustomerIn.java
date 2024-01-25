package com.demater.rest.account.in;

import com.demater.core.domain.customer.LegalCapacity;
import com.demater.rest.common.in.CodeNameIn;

import java.util.Set;

public record CustomerIn(CodeNameIn type,
                         LegalCapacity legalCapacity,
                         Set<ProfessionIn>profession) {
}
