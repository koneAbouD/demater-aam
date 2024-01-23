package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.LanguageEntity;
import com.demater.infrastructure.database.entity.customer.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaLanguageRepository extends JpaRepository<LanguageEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM language at WHERE at.id = :id")
    Optional<LanguageEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
