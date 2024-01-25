package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.MaritalStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMaritalStatusRepository extends JpaRepository<MaritalStatusEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM marital_status mt WHERE mt.id = :id")
    Optional<MaritalStatusEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
