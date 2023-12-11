package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.station.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface JpaStationRepository extends JpaRepository<StationEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT case when count(s)> 0 then true else false end FROM station s " +
            "WHERE lower(s.designation) LIKE lower(?1) AND s.city_id = ?2")
    boolean existsByDesignationAndCity(String designation, Long cityId);

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM station s WHERE TRIM(LOWER(s.designation)) IN :designations")
    Set<StationEntity> findByDesignationIgnoreCaseIn(@Param("designations") Set<String> designations);
}
