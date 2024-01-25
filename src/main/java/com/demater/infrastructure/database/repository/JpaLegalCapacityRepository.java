package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.LegalCapacityEntity;
import com.demater.infrastructure.database.entity.customer.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaLegalCapacityRepository extends JpaRepository<LegalCapacityEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM legal_capacity lc WHERE lc.id = :id")
    Optional<LegalCapacityEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
