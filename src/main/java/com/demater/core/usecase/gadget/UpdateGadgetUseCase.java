package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetUpdatingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateGadgetUseCase {
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetRepository gadgetRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public Gadget execute(UUID id, Gadget gadget) {
        Gadget gadgetToUpdate = gadgetRepository.findById(id)
                .orElseThrow(() -> new GadgetNotFoundException("Gadget ID=[" + id + "] don't exists"));

       GadgetType gadgetType = gadgetTypeRepository.findById(gadget.getType().getId())
                .orElseThrow(() -> new GadgetTypeNotFoundException("Gadget type ID=[" + gadget.getType().getId() + "] don't exists"));

        if (!gadgetToUpdate.getDesignation().equalsIgnoreCase(gadget.getDesignation()) &&
                gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())) {
            throw new GadgetAlreadyExistsException("Gadget [" + gadget.getDesignation() + "] already exists");
        }

        gadgetToUpdate.update(
                gadget.getDesignation(),
                gadgetType,
                gadget.getDescription(),
                gadget.getDetails(),
                gadget.getTotalNumber(),
                gadget.getRemainingNumber(),
                gadget.isAvailable()
        );
        Gadget gadgetSaved = gadgetRepository.save(gadgetToUpdate);
        gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return gadgetSaved;
    }
}
