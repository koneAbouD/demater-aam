package com.demater.rest.account.in;

import com.demater.core.domain.customer.LegalCapacity;
import com.demater.rest.customer.in.CustomerTypeIn;

import java.util.Set;

public record CustomerIn(CustomerTypeIn type, LegalCapacity legalCapacity, Set<ProfessionIn>profession) {
}
