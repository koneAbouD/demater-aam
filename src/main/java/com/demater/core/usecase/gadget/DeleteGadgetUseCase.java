package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.event.gadget.GadgetDeletingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteGadgetUseCase {
    private final GadgetRepository gadgetRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public void execute(UUID id) {
        Gadget gadget = gadgetRepository.findById(id)
                .orElseThrow(() -> new GadgetNotFoundException("Gadget ID=[" + id + "] don't exists"));
        // TODO: Check if gadget already sent to station, throw exception or delete (not make unavailable)
        gadget.makeUnavailable();
        gadgetRepository.save(gadget);
        gadgetEventPublisher.publishGadgetDeleting(new GadgetDeletingEvent(id));
    }
}
