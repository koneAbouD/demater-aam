package com.demater.builder;

import com.demater.core.domain.user.ERole;
import com.demater.core.domain.user.Role;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoleMB {
    private Role role;

    public RoleMB() {
        role = mock(Role.class);
    }

    public RoleMB withId(long id) {
        when(role.getId()).thenReturn(id);
        return this;
    }

    public RoleMB withName(ERole eRole) {
        when(role.getName()).thenReturn(eRole);
        return this;
    }

    public Role build() {
        return role;
    }
}
