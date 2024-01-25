package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.port.LegalCapacityRepository;
import com.demater.core.port.NationalityRepository;
import com.demater.infrastructure.database.entity.customer.LegalCapacityEntity;
import com.demater.infrastructure.database.entity.customer.LegalCapacityEntity;
import com.demater.infrastructure.database.repository.JpaLegalCapacityRepository;
import com.demater.infrastructure.database.repository.JpaNationalityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlLegalCapacityRepository implements LegalCapacityRepository {
    private final JpaLegalCapacityRepository legalCapacityRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return legalCapacityRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public LegalCapacity save(LegalCapacity legalCapacity) {
        LegalCapacityEntity legalCapacityToSave = objectMapper.convertValue(legalCapacity, LegalCapacityEntity.class);
        LegalCapacityEntity legalCapacityEntitySaved = legalCapacityRepository.save(legalCapacityToSave);
        return objectMapper.convertValue(legalCapacityEntitySaved, LegalCapacity.class);
    }

    @Override
    public Optional<LegalCapacity> findById(Long id) {
        Optional<LegalCapacityEntity> legalCapacity = legalCapacityRepository.findById(id);
        return legalCapacity.map(g -> objectMapper.convertValue(g, LegalCapacity.class));
    }

    @Override
    public void delete(LegalCapacity legalCapacity) {
        LegalCapacityEntity legalCapacityToDelete = objectMapper.convertValue(legalCapacity, LegalCapacityEntity.class);
        legalCapacityRepository.delete(legalCapacityToDelete);
    }

    @Override
    public List<LegalCapacity> findAll() {
        return legalCapacityRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, LegalCapacity.class))
                .toList();
    }
}
