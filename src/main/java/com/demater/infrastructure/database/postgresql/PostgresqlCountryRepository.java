package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.reference.Country;
import com.demater.core.port.CountryRepository;
import com.demater.infrastructure.database.entity.reference.CountryEntity;
import com.demater.infrastructure.database.repository.JpaCountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlCountryRepository implements CountryRepository {
    private final JpaCountryRepository countryRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return countryRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public Country save(Country country) {
        CountryEntity countryToSave = objectMapper.convertValue(country, CountryEntity.class);
        CountryEntity countrySaved = countryRepository.save(countryToSave);
        return objectMapper.convertValue(countrySaved, Country.class);
    }

    @Override
    public Optional<Country> findById(Long id) {
        Optional<CountryEntity> country = countryRepository.findById(id);
        return country.map(g -> objectMapper.convertValue(g, Country.class));
    }

    @Override
    public void delete(Country country) {
        CountryEntity countryToDelete = objectMapper.convertValue(country, CountryEntity.class);
        countryRepository.delete(countryToDelete);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Country.class))
                .toList();
    }
}
