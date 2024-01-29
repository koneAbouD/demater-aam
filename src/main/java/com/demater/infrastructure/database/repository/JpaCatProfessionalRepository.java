package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.profession.ProfessionalCatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCatProfessionalRepository extends JpaRepository<ProfessionalCatEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM category_professional cat WHERE cat.id = :id")
    Optional<ProfessionalCatEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
