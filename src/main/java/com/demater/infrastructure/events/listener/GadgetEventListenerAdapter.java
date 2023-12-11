package com.demater.infrastructure.events.listener;

import com.demater.core.event.gadget.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GadgetEventListenerAdapter {
    @EventListener
    public void handle(GadgetTypeCreatingEvent event) {
        log.info("Gadget type [ " + event.getDesignation() + "] created at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetTypeUpdatingEvent event) {
        log.info("Gadget type [ " + event.getDesignation() + "] updated at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetTypeDeletingEvent event) {
        log.info("Gadget type ID [ " + event.getId() + "] deleted at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetsTypeGettingEvent event) {
        log.info("All Gadgets types retrieved at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetCreatingEvent event) {
        log.info("Gadget [" + event.getDesignation() + "] created at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetUpdatingEvent event) {
        log.info("Gadget ID[" + event.getId() + "] updated at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetDeletingEvent event) {
        log.info("Gadget ID[" + event.getId() + "] deleted at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetsGettingEvent event) {
        log.info("Gadgets retrieved at " + event.getDate());
    }

    @EventListener
    public void handle(GadgetConfirmationEvent event) {
        log.info("Gadget [" + event.getUuid() +"] confirmed by User[" + event.getLogin() + "] at " + event.getDate());
    }
}
