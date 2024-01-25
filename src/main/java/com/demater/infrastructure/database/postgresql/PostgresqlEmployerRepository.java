package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.profession.Employer;
import com.demater.core.port.EmployerRepository;
import com.demater.infrastructure.database.entity.profession.EmployerEntity;
import com.demater.infrastructure.database.repository.JpaEmployerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostgresqlEmployerRepository implements EmployerRepository {
    private final JpaEmployerRepository employerRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return employerRepository.existsByNameIgnoreCase(name);
    }
    @Override
    public List<Employer> findAll() {
        return employerRepository.findAll()
                .stream()
                .map(c -> objectMapper.convertValue(c, Employer.class))
                .toList();
    }

    @Override
    public Employer save(Employer employer) {
        EmployerEntity employerToSave = objectMapper.convertValue(employer, EmployerEntity.class);
        EmployerEntity employerSaved = employerRepository.save(employerToSave);
        return objectMapper.convertValue(employerSaved, Employer.class);
    }

    @Override
    public void delete(Employer employer) {
        EmployerEntity employerToDelete = objectMapper.convertValue(employer, EmployerEntity.class);
        employerRepository.delete(employerToDelete);
    }
}
