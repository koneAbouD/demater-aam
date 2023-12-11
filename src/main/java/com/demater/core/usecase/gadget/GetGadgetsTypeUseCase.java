package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetsTypeGettingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetGadgetsTypeUseCase {
    private final GadgetTypeRepository gadgetTypeRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public List<GadgetType> execute() {
        List<GadgetType> gadgetTypes = gadgetTypeRepository.findAll();
        gadgetEventPublisher.publishAllGadgetsTypeGetting(new GadgetsTypeGettingEvent());
        return gadgetTypes;
    }
}
