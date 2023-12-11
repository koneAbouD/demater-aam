package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetCreatingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateGadgetUseCase {
    private final GadgetRepository gadgetRepository;
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public Gadget execute(Gadget gadget) {
        if (gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())) {
            throw new GadgetAlreadyExistsException("Gadget [" + gadget.getDesignation() + "] already exists");
        }
        GadgetType gadgetType = gadgetTypeRepository.findById(gadget.getType().getId())
                .orElseThrow(() -> new GadgetTypeNotFoundException("Gadget type ID=[" + gadget.getType().getId() + "] don't exists"));
        gadget.updateForCreating(gadget.getTotalNumber(), gadgetType);
        Gadget gadgetToSave = gadgetRepository.save(gadget);
        gadgetEventPublisher.publishGadgetCreatingEvent(new GadgetCreatingEvent(gadget.getDesignation()));
        return gadgetToSave;
    }
}
