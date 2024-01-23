package com.demater.core.port;

import com.demater.core.domain.customer.Language;
import com.demater.core.domain.customer.MaritalStatus;

import java.util.List;
import java.util.Optional;

public interface MaritalStatusRepository {
    boolean existsByNameIgnoreCase(String name);
    MaritalStatus save(MaritalStatus maritalStatus);
    Optional<MaritalStatus> findById(Long id);
    void delete(MaritalStatus maritalStatus);
    List<MaritalStatus> findAll();
}
