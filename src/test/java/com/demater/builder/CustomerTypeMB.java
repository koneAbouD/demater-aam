package com.demater.builder;

import com.demater.core.domain.customer.CustomerType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTypeMB {
    private CustomerType customerType;

    public CustomerTypeMB() {
        customerType = mock(CustomerType.class);
    }

    public CustomerTypeMB withId(Long id) {
        when(customerType.getId()).thenReturn(id);
        return this;
    }

    public CustomerTypeMB withCode(String code) {
        when(customerType.getCode()).thenReturn(code);
        return this;
    }

    public CustomerTypeMB withName(String name) {
        when(customerType.getName()).thenReturn(name);
        return this;
    }

    public CustomerType build() {
        return customerType;
    }
}
