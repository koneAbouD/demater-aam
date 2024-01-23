package com.demater.core.port;

import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.domain.customer.Language;

import java.util.List;
import java.util.Optional;

public interface FamilyStatusRepository {
    boolean existsByNameIgnoreCase(String name);
    FamilyStatus save(FamilyStatus familyStatus);
    Optional<FamilyStatus> findById(Long id);
    void delete(FamilyStatus familyStatus);
    List<FamilyStatus> findAll();
}
