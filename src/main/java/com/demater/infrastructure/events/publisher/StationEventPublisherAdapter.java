package com.demater.infrastructure.events.publisher;

import com.demater.core.event.station.*;
import com.demater.core.publisher.StationEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class StationEventPublisherAdapter implements StationEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishStationCreating(StationCreatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationUpdating(StationUpdatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationDeleting(StationDeletingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationsGetting(StationsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationsImporting(StationsImportingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationsAlreadyImported(StationsAlreadyImportedEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUsersAddingToStation(UserAddingToStationEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUsersRemovingFromStation(UserRemovingFromStationEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishStationGadgetIntegrating(StationGadgetIntegratingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishRecoveringSentGadgets(RecoveringSentGadgetsEvent event) {
        eventPublisher.publishEvent(event);
    }
}
