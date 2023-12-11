package com.demater.core.domain.gadget;

import com.demater.core.domain.exception.InsufficientGadgetException;
import com.demater.core.domain.exception.UnavailableGadgetException;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Gadget {
    private UUID id;
    private String designation;
    private GadgetType type;
    private String description;
    private String details;
    private Long totalNumber;
    private Long remainingNumber;
    private boolean isAvailable;

    public void update(String designation,
                       GadgetType type,
                       String description,
                       String details,
                       Long totalNumber,
                       Long remainingNumber,
                       boolean isAvailable) {
        this.designation = designation;
        this.type = type;
        this.description = description;
        this.details = details;
        this.totalNumber = totalNumber;
        this.remainingNumber = remainingNumber;
        this.isAvailable = isAvailable;
    }

    public void updateForCreating(Long totalNumber, GadgetType gadgetType) {
        this.remainingNumber = totalNumber;
        this.type = gadgetType;
    }

    public void makeUnavailable() {
        this.isAvailable = false;
    }

    public void gadgetToStation(Long gadgetNumber) {
        throwIfGadgetUnavailable();
        throwIfGadgetInsufficient(gadgetNumber);
        this.remainingNumber -= gadgetNumber;
    }

    public String typeDesignation() {
        return getType().getDesignation();
    }

    private void throwIfGadgetUnavailable() {
        if (!isAvailable()) {
            throw new UnavailableGadgetException("Unavailable Gadget [" + getDesignation() + "]");
        }
    }

    private void throwIfGadgetInsufficient(Long gadgetNumber) {
        if (getRemainingNumber() < gadgetNumber) {
            throw new InsufficientGadgetException("Insufficient Gadget ["
                    + getDesignation() + "] ;  Remaining Number = " + getRemainingNumber());
        }
    }
}
