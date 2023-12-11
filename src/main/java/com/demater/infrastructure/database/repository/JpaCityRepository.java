package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.referential.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface JpaCityRepository extends JpaRepository<CityEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM city c WHERE TRIM(LOWER(c.designation)) IN :designations")
    List<CityEntity> findByDesignationIgnoreCaseIn(@Param("designations") Set<String> designations);

    @Query(nativeQuery = true, value = "SELECT * FROM city c WHERE c.id = :id")
    Optional<CityEntity> findById(@Param("id") Long id);
}
