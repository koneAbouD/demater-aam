package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.gadget.GadgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaGadgetRepository extends JpaRepository<GadgetEntity, UUID> {
    boolean existsByDesignationIgnoreCase(String designation);
}
