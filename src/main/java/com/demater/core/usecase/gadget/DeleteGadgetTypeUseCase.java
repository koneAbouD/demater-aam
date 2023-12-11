package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeDeletingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteGadgetTypeUseCase {
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public void execute(Long id) {
        GadgetType gadgetType = gadgetTypeRepository.findById(id)
                .orElseThrow(() -> new GadgetTypeNotFoundException("Gadget type ID=[" + id + "] don't exists"));
        gadgetTypeRepository.delete(gadgetType);
        gadgetEventPublisher.publishGadgetTypeDeletingEvent(new GadgetTypeDeletingEvent(id));
    }
}
