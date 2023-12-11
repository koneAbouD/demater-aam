package com.demater.builder;

import com.demater.infrastructure.database.entity.referential.CityEntity;
import com.demater.infrastructure.database.entity.station.StationEntity;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StationEntityMB {
    private StationEntity station;

    public StationEntityMB() {
        station = mock(StationEntity.class);
    }

    public StationEntityMB withId(UUID id) {
        when(station.getId()).thenReturn(id);
        return this;
    }

    public StationEntityMB withDesignation(String designation) {
        when(station.getDesignation()).thenReturn(designation);
        return this;
    }

    public StationEntityMB withCity(CityEntity city) {
        when(station.getCity()).thenReturn(city);
        return this;
    }

    public StationEntity build() {
        return station;
    }
}
