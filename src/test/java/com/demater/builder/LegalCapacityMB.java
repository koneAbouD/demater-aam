package com.demater.builder;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.LegalCapacity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LegalCapacityMB {
    private LegalCapacity legalCapacity;

    public LegalCapacityMB() {
        legalCapacity = mock(LegalCapacity.class);
    }

    public LegalCapacityMB withId(Long id) {
        when(legalCapacity.getId()).thenReturn(id);
        return this;
    }

    public LegalCapacityMB withCode(String code) {
        when(legalCapacity.getCode()).thenReturn(code);
        return this;
    }

    public LegalCapacityMB withName(String name) {
        when(legalCapacity.getName()).thenReturn(name);
        return this;
    }

    public LegalCapacity build() {
        return legalCapacity;
    }
}
