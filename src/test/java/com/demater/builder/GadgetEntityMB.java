package com.demater.builder;

import com.demater.infrastructure.database.entity.gadget.GadgetEntity;
import com.demater.infrastructure.database.entity.gadget.GadgetTypeEntity;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetEntityMB {
    private GadgetEntity gadget;

    public GadgetEntityMB() {
        gadget = mock(GadgetEntity.class);
    }

    public GadgetEntityMB withId(UUID id) {
        when(gadget.getId()).thenReturn(id);
        return this;
    }

    public GadgetEntityMB withDesignation(String designation) {
        when(gadget.getDesignation()).thenReturn(designation);
        return this;
    }

    public GadgetEntityMB withGadgetType(GadgetTypeEntity type) {
        when(gadget.getType()).thenReturn(type);
        return this;
    }

    public GadgetEntityMB withAvailable(boolean isAvailable) {
        when(gadget.isAvailable()).thenReturn(isAvailable);
        return this;
    }

    public GadgetEntityMB withTotalNumber(Long totalNumber) {
        when(gadget.getTotalNumber()).thenReturn(totalNumber);
        return this;
    }

    public GadgetEntityMB withRemainingNumber(Long remainingNumber) {
        when(gadget.getRemainingNumber()).thenReturn(remainingNumber);
        return this;
    }

    public GadgetEntity build() {
        return gadget;
    }
}
