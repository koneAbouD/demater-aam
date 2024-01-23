package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.port.FamilyStatusRepository;
import com.demater.infrastructure.database.entity.customer.FamilyStatusEntity;
import com.demater.infrastructure.database.repository.JpaFamilyStatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlFamilyStatusRepository implements FamilyStatusRepository {
    private final JpaFamilyStatusRepository familyStatusRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return familyStatusRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public FamilyStatus save(FamilyStatus familyStatus) {
        FamilyStatusEntity nationalityToSave = objectMapper.convertValue(familyStatus, FamilyStatusEntity.class);
        FamilyStatusEntity nationalityEntitySaved = familyStatusRepository.save(nationalityToSave);
        return objectMapper.convertValue(nationalityEntitySaved, FamilyStatus.class);
    }

    @Override
    public Optional<FamilyStatus> findById(Long id) {
        Optional<FamilyStatusEntity> familyStatus = familyStatusRepository.findById(id);
        return familyStatus.map(g -> objectMapper.convertValue(g, FamilyStatus.class));
    }

    @Override
    public void delete(FamilyStatus familyStatus) {
        FamilyStatusEntity nationalityToDelete = objectMapper.convertValue(familyStatus, FamilyStatusEntity.class);
        familyStatusRepository.delete(nationalityToDelete);
    }

    @Override
    public List<FamilyStatus> findAll() {
        return familyStatusRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, FamilyStatus.class))
                .toList();
    }
}
