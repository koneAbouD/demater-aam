package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.station.Station;
import com.demater.core.port.StationRepository;
import com.demater.infrastructure.database.entity.station.StationEntity;
import com.demater.infrastructure.database.repository.JpaStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlStationRepository implements StationRepository {
    private final JpaStationRepository stationRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByDesignationAndCity(String designation, Long cityId) {
        return stationRepository.existsByDesignationAndCity(designation, cityId);
    }

    @Override
    public Set<Station> findByDesignationIgnoreCaseIn(Set<String> designations) {
        return stationRepository.findByDesignationIgnoreCaseIn(designations)
                .stream()
                .map(s -> objectMapper.convertValue(s, Station.class))
                .collect(toSet());
    }

    @Override
    public Station save(Station station) {
        StationEntity stationToSave = objectMapper.convertValue(station, StationEntity.class);
        StationEntity stationSaved = stationRepository.save(stationToSave);
        return objectMapper.convertValue(stationSaved, Station.class);
    }

    @Override
    public Optional<Station> findById(UUID id) {
        Optional<StationEntity> station = stationRepository.findById(id);
        return station.map(s -> objectMapper.convertValue(s, Station.class));
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll()
                .stream()
                .map(s -> objectMapper.convertValue(s, Station.class))
                .toList();
    }

    @Override
    public List<Station> saveAll(List<Station> stations) {
        List<StationEntity> stationsToSave = stations.stream()
                .map(s -> objectMapper.convertValue(s, StationEntity.class))
                .toList();
        List<StationEntity> stationsSaved = stationRepository.saveAll(stationsToSave);
        return stationsSaved.stream()
                .map(s -> objectMapper.convertValue(s, Station.class))
                .toList();
    }
}
