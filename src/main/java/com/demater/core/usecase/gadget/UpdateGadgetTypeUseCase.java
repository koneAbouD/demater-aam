package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeUpdatingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateGadgetTypeUseCase {
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public GadgetType execute(GadgetType gadgetType) {
        GadgetType existingGadgetType = gadgetTypeRepository.findById(gadgetType.getId())
                .orElseThrow(() -> new GadgetTypeNotFoundException("Gadget type ID=[" + gadgetType.getId() + "] don't exists"));

        if (!existingGadgetType.getDesignation().equalsIgnoreCase(gadgetType.getDesignation()) &&
                gadgetTypeRepository.existsByDesignationIgnoreCase(gadgetType.getDesignation())) {
            throw new GadgetTypeAlreadyExistsException("Gadget type ID [" + gadgetType.getDesignation() + "] already exists");
        }

        existingGadgetType.update(gadgetType.getDesignation());
        gadgetTypeRepository.save(existingGadgetType);
        gadgetEventPublisher.publishGadgetTypeUpdatingEvent(new GadgetTypeUpdatingEvent(gadgetType.getDesignation()));
        return existingGadgetType;
    }
}
