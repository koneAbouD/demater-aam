package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.referential.ESetting;
import com.demater.core.domain.referential.Settings;
import com.demater.core.port.SettingsRepository;
import com.demater.infrastructure.database.repository.JpaSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgresqlSettingsRepository implements SettingsRepository {
    private final JpaSettingsRepository settingsRepository;

    @Override
    public Settings findByName(ESetting setting) {
        return null;
    }
}
