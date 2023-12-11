package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.station.StationGadgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface JpaStationGadgetRepository extends JpaRepository<StationGadgetEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM station_gadget WHERE station_id = :station AND gadget_id IN :gadgets")
    Set<StationGadgetEntity> findAllByStationAndGadgetIn(@Param("station") UUID stationId, @Param("gadgets") Set<UUID> gadgetsIds);
}
