package com.demater.builder;

import com.demater.core.domain.user.Position;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositionMB {
    private Position position;

    public PositionMB() {
        position = mock(Position.class);
    }

    public PositionMB withId(long id) {
        when(position.getId()).thenReturn(id);
        return this;
    }

    public PositionMB withCode(String code) {
        when(position.getCode()).thenReturn(code);
        return this;
    }

    public PositionMB withDesignation(String designation) {
        when(position.getDesignation()).thenReturn(designation);
        return this;
    }

    public Position build() {
        return position;
    }
}
