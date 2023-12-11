package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.referential.City;
import com.demater.core.port.CityRepository;
import com.demater.infrastructure.database.entity.referential.CityEntity;
import com.demater.infrastructure.database.repository.JpaCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;

@Repository
@RequiredArgsConstructor
public class PostgresqlCityRepository implements CityRepository {
    private final JpaCityRepository jpaCityRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<City> findByDesignationIgnoreCaseIn(Set<String> designations) {
        return jpaCityRepository.findByDesignationIgnoreCaseIn(designations)
                .stream()
                .map(c -> objectMapper.convertValue(c, City.class))
                .toList();
    }

    @Override
    public List<City> findAll() {
        return jpaCityRepository.findAll()
                .stream()
                .sorted(comparing(CityEntity::getDesignation))
                .map(c -> objectMapper.convertValue(c, City.class))
                .toList();
    }

    @Override
    public Optional<City> findById(Long id) {
        return jpaCityRepository.findById(id)
                .map(c -> objectMapper.convertValue(c, City.class));
    }
}
