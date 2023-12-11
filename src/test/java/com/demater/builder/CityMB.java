package com.demater.builder;

import com.demater.core.domain.referential.City;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CityMB {
    private City city;

    public CityMB() {
        city = mock(City.class);
    }

    public CityMB withId(Long id) {
        when(city.getId()).thenReturn(id);
        return this;
    }

    public CityMB withCode(String code) {
        when(city.getCode()).thenReturn(code);
        return this;
    }

    public CityMB withDesignation(String designation) {
        when(city.getDesignation()).thenReturn(designation);
        return this;
    }

    public City build() {
        return city;
    }
}
