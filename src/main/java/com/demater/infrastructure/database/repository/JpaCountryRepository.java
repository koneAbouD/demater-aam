package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.FamilyStatusEntity;
import com.demater.infrastructure.database.entity.reference.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCountryRepository extends JpaRepository<CountryEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM country fs WHERE fs.id = :id")
    Optional<CountryEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
