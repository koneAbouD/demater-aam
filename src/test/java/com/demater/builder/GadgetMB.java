package com.demater.builder;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetMB {
    private Gadget gadget;

    public GadgetMB() {
        gadget = mock(Gadget.class);
    }

    public GadgetMB withId(UUID id) {
        when(gadget.getId()).thenReturn(id);
        return this;
    }

    public GadgetMB withDesignation(String designation) {
        when(gadget.getDesignation()).thenReturn(designation);
        return this;
    }

    public GadgetMB withGadgetType(GadgetType type) {
        when(gadget.getType()).thenReturn(type);
        return this;
    }

    public GadgetMB withAvailable(boolean isAvailable) {
        when(gadget.isAvailable()).thenReturn(isAvailable);
        return this;
    }

    public GadgetMB withTotalNumber(long totalNumber) {
        when(gadget.getTotalNumber()).thenReturn(totalNumber);
        return this;
    }

    public GadgetMB withRemainingNumber(long remainingNumber) {
        when(gadget.getRemainingNumber()).thenReturn(remainingNumber);
        return this;
    }

    public Gadget build() {
        return gadget;
    }
}
