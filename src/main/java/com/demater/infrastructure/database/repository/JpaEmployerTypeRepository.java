package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.entity.profession.EmployerTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaEmployerTypeRepository extends JpaRepository<EmployerTypeEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM employer_type et WHERE et.id = :id")
    Optional<EmployerTypeEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
