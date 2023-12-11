package com.demater.infrastructure.provider;

import com.demater.core.port.StationDeleteTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;

@Component
public class StationDeleteTimeProvider implements StationDeleteTime {
    @Override
    public Long get() {
        return new Timestamp(currentTimeMillis()).getTime();
    }
}
