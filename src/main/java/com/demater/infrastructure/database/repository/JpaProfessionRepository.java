package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.profession.ProfessionEntity;
import com.demater.infrastructure.database.entity.reference.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaProfessionRepository extends JpaRepository<ProfessionEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM profession at WHERE at.id = :id")
    Optional<ProfessionEntity> findById(@Param("id") UUID id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM profession s WHERE s.id IN :ids")
    List<ProfessionEntity> findAllByIdsIn(@Param("ids") List<UUID> ids);
}
