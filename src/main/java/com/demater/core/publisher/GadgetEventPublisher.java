package com.demater.core.publisher;

import com.demater.core.event.gadget.*;

public interface GadgetEventPublisher {
    void publishGadgetTypeCreatingEvent(GadgetTypeCreatingEvent event);
    void publishGadgetTypeUpdatingEvent(GadgetTypeUpdatingEvent event);
    void publishGadgetTypeDeletingEvent(GadgetTypeDeletingEvent event);
    void publishAllGadgetsTypeGetting(GadgetsTypeGettingEvent event);
    void publishGadgetCreatingEvent(GadgetCreatingEvent event);
    void publishGadgetUpdatingEvent(GadgetUpdatingEvent event);
    void publishGadgetDeleting(GadgetDeletingEvent event);
    void publishGadgetsGetting(GadgetsGettingEvent event);
    void publishGadgetReception(GadgetConfirmationEvent event);
}
