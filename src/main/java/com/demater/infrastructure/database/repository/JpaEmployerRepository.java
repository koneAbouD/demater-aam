package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.LegalCapacityEntity;
import com.demater.infrastructure.database.entity.profession.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaEmployerRepository extends JpaRepository<EmployerEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM employer em WHERE em.id = :id")
    Optional<EmployerEntity> findById(@Param("id") UUID id);
    boolean existsByNameIgnoreCase(String name);
}
