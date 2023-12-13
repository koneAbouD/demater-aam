package com.demater.builder;

import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMB {
    private User user;

    public UserMB() {
        user = mock(User.class);
    }

    public UserMB withFirstName(String firstName) {
        when(user.getFirstName()).thenReturn(firstName);
        return this;
    }

    public UserMB withLastName(String lastName) {
        when(user.getLastName()).thenReturn(lastName);
        return this;
    }

    public UserMB withEmail(String email) {
        when(user.getEmail()).thenReturn(email);
        return this;
    }

    public UserMB withLogin(String login) {
        when(user.getLogin()).thenReturn(login);
        return this;
    }

    public UserMB withPassword(String password) {
        when(user.getPassword()).thenReturn(password);
        return this;
    }

    public UserMB withRoles(Set<Role> roles) {
        when(user.getRoles()).thenReturn(roles);
        return this;
    }


    public UserMB withActivate(boolean isActivate) {
        when(user.isActivate()).thenReturn(isActivate);
        return this;
    }

    public UserMB withValid(boolean isValid) {
        when(user.isValid()).thenReturn(isValid);
        return this;
    }

    public UserMB withConfirmationToken(String confirmationToken) {
        when(user.getConfirmationToken()).thenReturn(confirmationToken);
        return this;
    }

    public User build() {
        return user;
    }
}
