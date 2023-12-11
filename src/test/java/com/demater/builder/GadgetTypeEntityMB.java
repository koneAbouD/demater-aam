package com.demater.builder;

import com.demater.infrastructure.database.entity.gadget.GadgetTypeEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetTypeEntityMB {
    private GadgetTypeEntity gadgetType;

    public GadgetTypeEntityMB() {
        gadgetType = mock(GadgetTypeEntity.class);
    }

    public GadgetTypeEntityMB withId(Long id) {
        when(gadgetType.getId()).thenReturn(id);
        return this;
    }

    public GadgetTypeEntityMB withDesignation(String designation) {
        when(gadgetType.getDesignation()).thenReturn(designation);
        return this;
    }

    public GadgetTypeEntity build() {
        return gadgetType;
    }
}
