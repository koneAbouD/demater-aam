package com.demater.infrastructure.database.repository;

import com.demater.core.domain.referential.ESetting;
import com.demater.infrastructure.database.entity.referential.SettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSettingsRepository extends JpaRepository<SettingsEntity, Long> {
    SettingsEntity findByName(ESetting setting);
}
