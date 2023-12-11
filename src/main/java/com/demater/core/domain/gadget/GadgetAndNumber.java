package com.demater.core.domain.gadget;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GadgetAndNumber {
    private Gadget gadget;
    private Long gadgetNumber;

    public String gadgetName() {
        return getGadget().getDesignation();
    }

    public UUID gadgetId() {
        return gadget.getId();
    }

    public boolean isAvailable() {
        return gadget.isAvailable();
    }
}
