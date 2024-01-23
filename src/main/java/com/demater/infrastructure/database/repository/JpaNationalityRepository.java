package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaNationalityRepository extends JpaRepository<NationalityEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM nationality at WHERE at.id = :id")
    Optional<NationalityEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
