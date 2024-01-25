package com.demater.core.port;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.profession.EmployerType;

import java.util.List;
import java.util.Optional;

public interface EmployerTypeRepository {
    boolean existsByNameIgnoreCase(String name);
    EmployerType save(EmployerType employerType);
    Optional<EmployerType> findById(Long id);
    void delete(EmployerType employerType);
    List<EmployerType> findAll();
}
