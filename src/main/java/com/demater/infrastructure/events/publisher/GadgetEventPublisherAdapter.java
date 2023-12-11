package com.demater.infrastructure.events.publisher;

import com.demater.core.event.gadget.*;
import com.demater.core.publisher.GadgetEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class GadgetEventPublisherAdapter implements GadgetEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishGadgetTypeCreatingEvent(GadgetTypeCreatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetTypeUpdatingEvent(GadgetTypeUpdatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetTypeDeletingEvent(GadgetTypeDeletingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishAllGadgetsTypeGetting(GadgetsTypeGettingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetCreatingEvent(GadgetCreatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetUpdatingEvent(GadgetUpdatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetDeleting(GadgetDeletingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetsGetting(GadgetsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishGadgetReception(GadgetConfirmationEvent event) {
        eventPublisher.publishEvent(event);
    }
}
