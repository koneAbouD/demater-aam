package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.gadget.GadgetConfirmationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaGadgetConfirmationRepository extends JpaRepository<GadgetConfirmationEntity, UUID> {
    Optional<GadgetConfirmationEntity> findById(UUID id);
}
