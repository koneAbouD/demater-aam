package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.gadget.GadgetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaGadgetTypeRepository extends JpaRepository<GadgetTypeEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM gadget_type gt WHERE gt.id = :id")
    Optional<GadgetTypeEntity> findById(@Param("id") Long id);
    boolean existsByDesignationIgnoreCase(String name);
}
