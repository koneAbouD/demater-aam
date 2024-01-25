package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.FamilyStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaFamilyStatusRepository extends JpaRepository<FamilyStatusEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM family_status fs WHERE fs.id = :id")
    Optional<FamilyStatusEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
