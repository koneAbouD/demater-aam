package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.profession.EmployerType;
import com.demater.core.port.EmployerTypeRepository;
import com.demater.infrastructure.database.entity.profession.EmployerTypeEntity;
import com.demater.infrastructure.database.repository.JpaEmployerTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlEmployerTypeRepository implements EmployerTypeRepository {
    private final JpaEmployerTypeRepository employerTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return employerTypeRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public EmployerType save(EmployerType employerType) {
        EmployerTypeEntity employerTypeToSave = objectMapper.convertValue(employerType, EmployerTypeEntity.class);
        EmployerTypeEntity employerTypeEntitySaved = employerTypeRepository.save(employerTypeToSave);
        return objectMapper.convertValue(employerTypeEntitySaved, EmployerType.class);
    }

    @Override
    public Optional<EmployerType> findById(Long id) {
        Optional<EmployerTypeEntity> employerType = employerTypeRepository.findById(id);
        return employerType.map(g -> objectMapper.convertValue(g, EmployerType.class));
    }

    @Override
    public void delete(EmployerType employerType) {
        EmployerTypeEntity employerTypeToDelete = objectMapper.convertValue(employerType, EmployerTypeEntity.class);
        employerTypeRepository.delete(employerTypeToDelete);
    }

    @Override
    public List<EmployerType> findAll() {
        return employerTypeRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, EmployerType.class))
                .toList();
    }
}
