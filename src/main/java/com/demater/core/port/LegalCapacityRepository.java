package com.demater.core.port;

import com.demater.core.domain.customer.LegalCapacity;

import java.util.List;
import java.util.Optional;

public interface LegalCapacityRepository {
    boolean existsByNameIgnoreCase(String name);
    LegalCapacity save(LegalCapacity legalCapacity);
    Optional<LegalCapacity> findById(Long id);
    void delete(LegalCapacity legalCapacity);
    List<LegalCapacity> findAll();
}
