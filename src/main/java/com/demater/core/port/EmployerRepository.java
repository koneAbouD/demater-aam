package com.demater.core.port;

import com.demater.core.domain.profession.Employer;
import com.demater.core.domain.profession.EmployerType;

import java.util.List;
import java.util.Optional;

public interface EmployerRepository {
    boolean existsByNameIgnoreCase(String name);
    Employer save(Employer employer);
    void delete(Employer employer);
    List<Employer> findAll();
}