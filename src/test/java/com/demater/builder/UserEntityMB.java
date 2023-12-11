package com.demater.builder;

import com.demater.infrastructure.database.entity.user.PositionEntity;
import com.demater.infrastructure.database.entity.user.RoleEntity;
import com.demater.infrastructure.database.entity.user.UserEntity;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserEntityMB {
    private UserEntity user;

    public UserEntityMB() {
        user = mock(UserEntity.class);
    }

    public UserEntityMB withFirstName(String firstName) {
        when(user.getFirstName()).thenReturn(firstName);
        return this;
    }

    public UserEntityMB withLastName(String lastName) {
        when(user.getLastName()).thenReturn(lastName);
        return this;
    }

    public UserEntityMB withEmail(String email) {
        when(user.getEmail()).thenReturn(email);
        return this;
    }

    public UserEntityMB withLogin(String login) {
        when(user.getLogin()).thenReturn(login);
        return this;
    }
    public UserEntityMB withConfirmationToken(String confirmationToken) {
        when(user.getConfirmationToken()).thenReturn(confirmationToken);
        return this;
    }

    public UserEntityMB withRoles(Set<RoleEntity> roles) {
        when(user.getRoles()).thenReturn(roles);
        return this;
    }

    public UserEntityMB withPositions(Set<PositionEntity> positions) {
        when(user.getPositions()).thenReturn(positions);
        return this;
    }

    public UserEntityMB withValid(boolean isValid) {
        when(user.isValid()).thenReturn(isValid);
        return this;
    }

    public UserEntity build() {
        return user;
    }
}
