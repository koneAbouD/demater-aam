package com.demater.infrastructure.events.listener;

import com.demater.core.event.station.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StationEventListenerAdapter {
    @EventListener
    public void handle(StationCreatingEvent event) {
        log.info("Station [" + event.getDesignation() + "] created at " + event.getDate());
    }

    @EventListener
    public void handle(StationUpdatingEvent event) {
        log.info("Station [" + event.getId() + "] updated at " + event.getDate());
    }

    @EventListener
    public void handle(StationDeletingEvent event) {
        log.info("Station [" + event.getId() + "] deleted at " + event.getDate());
    }

    @EventListener
    public void handle(StationsGettingEvent event) {
        log.info("Stations retrieved at " + event.getDate());
    }

    @EventListener
    public void handle(StationsImportingEvent event) {
        log.info("Stations imported at " + event.getDate());
    }

    @EventListener
    public void handle(StationsAlreadyImportedEvent event) {
        log.info("Stations "  + event.getNames() + " already imported.");
    }

    @EventListener
    public void handle(UserAddingToStationEvent event) {
        log.info("Users " + event.getUsersLogin() + " added to station [" + event.getStationId() + "] at " + event.getDate());
    }

    @EventListener
    public void handle(UserRemovingFromStationEvent event) {
        log.info("Users " + event.getUsersLogin() + " removed to station [" + event.getStationId() + "] at " + event.getDate());
    }

    @EventListener
    public void handle(StationGadgetIntegratingEvent event) {
        log.info("Station [" + event.getId() + "] integrated gadgets " + event.getGadgetsName() + " at " + event.getDate());
    }

    @EventListener
    public void handle(RecoveringSentGadgetsEvent event) {
        log.info("Recovering sent gadgets with Query : " + event.getQuery() + " at " + event.getDate());
    }
}
