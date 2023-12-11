package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeCreatingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateGadgetTypeUseCase {
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public GadgetType execute(String name) {
        if (gadgetTypeRepository.existsByDesignationIgnoreCase(name)) {
            throw new GadgetTypeAlreadyExistsException("Gadget type [" + name + "] already exists");
        }

        GadgetType gadgetType = gadgetTypeRepository.save(new GadgetType(name));
        gadgetEventPublisher.publishGadgetTypeCreatingEvent(new GadgetTypeCreatingEvent(name));
        return gadgetType;
    }
}
