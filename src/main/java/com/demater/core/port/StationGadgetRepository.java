package com.demater.core.port;

import com.demater.core.domain.station.StationGadget;

import java.util.Set;
import java.util.UUID;

public interface StationGadgetRepository {
    Set<StationGadget> findAllByStationAndGadgetIn(UUID stationId, Set<UUID> gadgetsIds);
}
