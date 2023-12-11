package com.demater.core.port;

import com.demater.core.domain.referential.ESetting;
import com.demater.core.domain.referential.Settings;

public interface SettingsRepository {
    Settings findByName(ESetting setting);
}
