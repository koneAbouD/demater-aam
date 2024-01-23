package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.Nationality;
import com.demater.core.port.NationalityRepository;
import com.demater.infrastructure.database.entity.customer.NationalityEntity;
import com.demater.infrastructure.database.repository.JpaNationalityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlNationalityRepository implements NationalityRepository {
    private final JpaNationalityRepository nationalityRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return nationalityRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public Nationality save(Nationality nationality) {
        NationalityEntity nationalityToSave = objectMapper.convertValue(nationality, NationalityEntity.class);
        NationalityEntity nationalityEntitySaved = nationalityRepository.save(nationalityToSave);
        return objectMapper.convertValue(nationalityEntitySaved, Nationality.class);
    }

    @Override
    public Optional<Nationality> findById(Long id) {
        Optional<NationalityEntity> nationality = nationalityRepository.findById(id);
        return nationality.map(g -> objectMapper.convertValue(g, Nationality.class));
    }

    @Override
    public void delete(Nationality nationality) {
        NationalityEntity nationalityToDelete = objectMapper.convertValue(nationality, NationalityEntity.class);
        nationalityRepository.delete(nationalityToDelete);
    }

    @Override
    public List<Nationality> findAll() {
        return nationalityRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Nationality.class))
                .toList();
    }
}
