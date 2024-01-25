package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.profession.CatProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCatProfessionalRepository extends JpaRepository<CatProfessionalEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM category_professional cat WHERE cat.id = :id")
    Optional<CatProfessionalEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
