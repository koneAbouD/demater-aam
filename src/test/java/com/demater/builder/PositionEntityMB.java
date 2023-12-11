package com.demater.builder;

import com.demater.infrastructure.database.entity.user.PositionEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositionEntityMB {
    private PositionEntity position;

    public PositionEntityMB() {
        position = mock(PositionEntity.class);
    }

    public PositionEntityMB withId(Long id) {
        when(position.getId()).thenReturn(id);
        return this;
    }

    public PositionEntityMB withCode(String code) {
        when(position.getCode()).thenReturn(code);
        return this;
    }

    public PositionEntityMB withDesignation(String designation) {
        when(position.getDesignation()).thenReturn(designation);
        return this;
    }

    public PositionEntity build() {
        return position;
    }
}
