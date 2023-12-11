package com.demater.builder;

import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StationMB {
    private Station station;

    public StationMB() {
        station = mock(Station.class);
    }

    public StationMB withId(UUID id) {
        when(station.getId()).thenReturn(id);
        return this;
    }

    public StationMB withDesignation(String designation) {
        when(station.getDesignation()).thenReturn(designation);
        return this;
    }

    public StationMB withCity(City city) {
        when(station.getCity()).thenReturn(city);
        return this;
    }

    public Station build() {
        return station;
    }
}
