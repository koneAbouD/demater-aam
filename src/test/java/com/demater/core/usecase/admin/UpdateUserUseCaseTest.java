package com.demater.core.usecase.admin;

import com.demater.builder.RoleMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserDeletingEvent;
import com.demater.core.event.user.UserUpdatingByAdminEvent;
import com.demater.core.port.RoleRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.AdminCreatingException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;
import java.util.Set;

import static com.demater.core.domain.common.Constants.ROLES_ARE_NOT_FOUND;
import static com.demater.core.domain.common.Constants.SUPER_ADMIN_CREATING;
import static com.demater.core.domain.user.ERole.ROLE_ADMIN;
import static com.demater.core.domain.user.ERole.ROLE_SUPER_ADMIN;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class UpdateUserUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PositionRepository positionRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserEventPublisher userEventPublisher;
    private UpdateUserUseCase updateUserUseCase;

    @BeforeEach
    void setUp() {
        updateUserUseCase = new UpdateUserUseCase(userRepository, roleRepository, userEventPublisher);
    }

    @Test
    void should_throw_when_admin_update_user_with_user_dont_exists() {
        // Given
        String login = "dsoumaila";
        User user = new UserMB().withLogin(login).build();
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(Optional.empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> updateUserUseCase.execute(login, user));

        // Then
        assertEquals("User [" + login + "] not exists", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(login);
        verify(userRepository, never()).save(any(User.class));
        verify(userEventPublisher, never()).publishUserDeleting(new UserDeletingEvent(login));
    }

    @Test
    void should_throw_when_admin_update_user_with_role_empty() {
        // Given
        String login = "ssdsd";
        String firstName = "aaaaa";
        String lastName = "bbbbb";
        User user = new UserMB().withLogin(login).withFirstName(firstName).withLastName(lastName).build();
        User userExisting = new UserMB().withLogin(login).withFirstName(firstName).withLastName(lastName).build();
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(of(userExisting));

        // When
        Exception exception = assertThrows(RoleNotFoundException.class, () -> updateUserUseCase.execute(login, userExisting));

        // Then
        assertEquals(ROLES_ARE_NOT_FOUND, exception.getMessage());
        verify(userRepository).findByEmailOrLogin(login);
        verify(userRepository, never()).save(any(User.class));
        verify(userEventPublisher, never()).publishUserDeleting(new UserDeletingEvent(login));
    }

    @Test
    void should_throw_when_admin_update_user_with_user_role_is_super_admin() {
        // Given
        String login = "ssdsd";
        String firstName = "aaaaa";
        String lastName = "bbbbb";
        Role role = new RoleMB().withName(ROLE_SUPER_ADMIN).build();
        User user = new UserMB().withLogin(login).withFirstName(firstName)
                .withLastName(lastName).withRoles(Set.of(role)).build();
        when(user.hasRoleSuperAdmin()).thenReturn(true);
        Role roleExisting = new RoleMB().withName(ROLE_SUPER_ADMIN).build();
        User userExisting = new UserMB().withLogin(login).withFirstName(firstName)
                .withLastName(lastName).withRoles(Set.of(roleExisting)).build();
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(of(userExisting));

        // When
        Exception exception = assertThrows(AdminCreatingException.class, () -> updateUserUseCase.execute(login, user));

        // Then
        assertEquals(SUPER_ADMIN_CREATING, exception.getMessage());
        verify(userRepository).findByEmailOrLogin(login);
        verify(userRepository, never()).save(any(User.class));
        verify(userEventPublisher, never()).publishUserUpdatingByAdmin(new UserUpdatingByAdminEvent(login));
    }

    @Test
    void should_admin_update_user() {
        // Given
        String login = "ssdsd";
        String firstName = "aaaaa";
        String lastName = "bbbbb";
        Role role = new RoleMB().withName(ROLE_ADMIN).build();
        User user = new UserMB().withLogin(login).withFirstName(firstName)
                .withLastName(lastName).withRoles(Set.of(role)).withActivate(true).build();
        when(user.hasRoleSuperAdmin()).thenReturn(false);
        when(user.rolesNames()).thenReturn(Set.of(ROLE_ADMIN));
        Role roleExisting = new RoleMB().withName(ROLE_ADMIN).build();
        User userExisting = new UserMB().withLogin(login).withFirstName(firstName)
                .withLastName(lastName).withRoles(Set.of(roleExisting)).build();
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(of(userExisting));
        when(roleRepository.findAllByNameIn(user.rolesNames())).thenReturn(Set.of(roleExisting));
        when(userRepository.save(userExisting)).thenReturn(userExisting);

        // When
        updateUserUseCase.execute(login, user);

        // Then
        verify(roleRepository).findAllByNameIn(user.rolesNames());
        verify(userRepository).findByEmailOrLogin(user.getLogin());
        verify(userRepository).save(userExisting);
        verify(userEventPublisher).publishUserUpdatingByAdmin(any());
    }
}
