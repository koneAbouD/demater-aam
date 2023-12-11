package com.demater.core.publisher;


import com.demater.core.event.station.*;

public interface StationEventPublisher {
    void publishStationCreating(StationCreatingEvent event);
    void publishStationUpdating(StationUpdatingEvent event);
    void publishStationDeleting(StationDeletingEvent event);
    void publishStationsGetting(StationsGettingEvent event);
    void publishStationsImporting(StationsImportingEvent event);
    void publishStationsAlreadyImported(StationsAlreadyImportedEvent event);
    void publishUsersAddingToStation(UserAddingToStationEvent event);
    void publishUsersRemovingFromStation(UserRemovingFromStationEvent event);
    void publishStationGadgetIntegrating(StationGadgetIntegratingEvent event);

    void publishRecoveringSentGadgets(RecoveringSentGadgetsEvent event);
}
