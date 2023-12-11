package com.demater.builder;

import com.demater.core.domain.gadget.GadgetType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetTypeMB {
    private GadgetType gadgetType;

    public GadgetTypeMB() {
        gadgetType = mock(GadgetType.class);
    }

    public GadgetTypeMB withId(Long id) {
        when(gadgetType.getId()).thenReturn(id);
        return this;
    }

    public GadgetTypeMB withDesignation(String designation) {
        when(gadgetType.getDesignation()).thenReturn(designation);
        return this;
    }

    public GadgetType build() {
        return gadgetType;
    }
}
