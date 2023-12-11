package com.demater.builder;

import com.demater.core.domain.user.ERole;
import com.demater.infrastructure.database.entity.user.RoleEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoleEntityMB {
    private RoleEntity role;

    public RoleEntityMB() {
        role = mock(RoleEntity.class);
    }

    public RoleEntityMB withId(Long id) {
        when(role.getId()).thenReturn(id);
        return this;
    }

    public RoleEntityMB withName(ERole eRole) {
        when(role.getName()).thenReturn(eRole);
        return this;
    }

    public RoleEntity build() {
        return role;
    }
}
