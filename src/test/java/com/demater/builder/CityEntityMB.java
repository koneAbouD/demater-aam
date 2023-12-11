package com.demater.builder;

import com.demater.infrastructure.database.entity.referential.CityEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CityEntityMB {
    private CityEntity city;

    public CityEntityMB() {
        city = mock(CityEntity.class);
    }

    public CityEntityMB withId(Long id) {
        when(city.getId()).thenReturn(id);
        return this;
    }

    public CityEntityMB withCode(String code) {
        when(city.getCode()).thenReturn(code);
        return this;
    }

    public CityEntityMB withDesignation(String designation) {
        when(city.getDesignation()).thenReturn(designation);
        return this;
    }

    public CityEntity build() {
        return city;
    }
}
