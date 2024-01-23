package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.MaritalStatus;
import com.demater.core.port.MaritalStatusRepository;
import com.demater.infrastructure.database.entity.customer.MaritalStatusEntity;
import com.demater.infrastructure.database.repository.JpaMaritalStatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlMaritalStatusRepository implements MaritalStatusRepository {
    private final JpaMaritalStatusRepository maritalStatusRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return maritalStatusRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public MaritalStatus save(MaritalStatus maritalStatus) {
        MaritalStatusEntity maritalStatusToSave = objectMapper.convertValue(maritalStatus, MaritalStatusEntity.class);
        MaritalStatusEntity maritalStatusEntitySaved = maritalStatusRepository.save(maritalStatusToSave);
        return objectMapper.convertValue(maritalStatusEntitySaved, MaritalStatus.class);
    }

    @Override
    public Optional<MaritalStatus> findById(Long id) {
        Optional<MaritalStatusEntity> maritalStatus = maritalStatusRepository.findById(id);
        return maritalStatus.map(g -> objectMapper.convertValue(g, MaritalStatus.class));
    }

    @Override
    public void delete(MaritalStatus maritalStatus) {
        MaritalStatusEntity maritalStatusToDelete = objectMapper.convertValue(maritalStatus, MaritalStatusEntity.class);
        maritalStatusRepository.delete(maritalStatusToDelete);
    }

    @Override
    public List<MaritalStatus> findAll() {
        return maritalStatusRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, MaritalStatus.class))
                .toList();
    }
}
