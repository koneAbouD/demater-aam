package com.demater.builder;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.account.EStatus;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.profession.Profession;

import java.util.Set;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerMB {
    private Customer customer;

    public CustomerMB() {
        customer = mock(Customer.class);
    }

    public CustomerMB withId(UUID id) {
        when(customer.getId()).thenReturn(id);
        return this;
    }

    public CustomerMB withType(CustomerType type) {
        when(customer.getType()).thenReturn(type);
        return this;
    }
    public CustomerMB withFirstName(String firstName) {
        when(customer.getFirstName()).thenReturn(firstName);
        return this;
    }
    public CustomerMB withLastNames(String lastNames) {
        when(customer.getLastNames()).thenReturn(lastNames);
        return this;
    }
    public CustomerMB withCode(String code) {
        when(customer.getCode()).thenReturn(code);
        return this;
    }
    public CustomerMB withProfessions(Set<Profession> professions) {
        when(customer.getProfessions()).thenReturn(professions);
        return this;
    }

    public CustomerMB withLegalCapacity(LegalCapacity legalCapacity){
        when(customer.getLegalCapacity()).thenReturn(legalCapacity);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
