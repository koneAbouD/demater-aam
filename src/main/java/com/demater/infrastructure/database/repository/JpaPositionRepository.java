package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.user.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface JpaPositionRepository extends JpaRepository<PositionEntity, Long> {
    Set<PositionEntity> findAllByCodeIn(Set<String> codes);
}
