package com.demater.core.port;

import com.demater.core.domain.station.Station;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface StationRepository {
    boolean existsByDesignationAndCity(String designation, Long cityId);
    Set<Station> findByDesignationIgnoreCaseIn(Set<String> designations);
    Station save(Station station);
    Optional<Station> findById(UUID id);
    List<Station> findAll();
    List<Station> saveAll(List<Station> stations);
}
