package com.demater.core.usecase.admin;

import com.demater.builder.RoleMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserDeletingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.admin.exception.AdminDeletingException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Set;

import static com.demater.core.domain.user.ERole.ROLE_ADMIN;
import static com.demater.core.domain.user.ERole.ROLE_USER;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class DeleteUserUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserEventPublisher userEventPublisher;
    private DeleteUserUseCase deleteUserUseCase;

    @BeforeEach
    void setUp() {
        deleteUserUseCase = new DeleteUserUseCase(userRepository, userEventPublisher);
    }

    @Test
    void should_admin_delete_user_with_user_dont_exists() {
        // Given
        User user = new UserMB().withLogin("dsdsd").build();
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> deleteUserUseCase.execute(user.getLogin()));

        // Then
        assertEquals("User [" + user.getLogin() + "] not exists", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(user.getLogin());
        verify(userRepository, never()).delete(any());
        verify(userEventPublisher, never()).publishUserDeleting(new UserDeletingEvent(user.getLogin()));
    }

    @Test
    void should_admin_delete_user_with_user_role_is_admin_or_super_admin() {
        // Given
        Role role = new RoleMB().withName(ROLE_ADMIN).build();
        User user = new UserMB().withLogin("dsoumaila").withRoles(Set.of(role)).build();
        when(user.hasRoleAdmin()).thenReturn(true);
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(of(user));

        // When
        Exception exception = assertThrows(AdminDeletingException.class, () -> deleteUserUseCase.execute(user.getLogin()));

        // Then
        assertEquals("User [" + user.getLogin() + "] have Admin role, so can't be delete", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(user.getLogin());
        verify(userRepository, never()).delete(any());
        verify(userEventPublisher, never()).publishUserDeleting(new UserDeletingEvent(user.getLogin()));
    }

    @Test
    void should_admin_delete_user() {
        // Given
        Role role = new RoleMB().withName(ROLE_USER).build();
        User user = new UserMB().withLogin("dsoumaila").withRoles(Set.of(role)).build();
        when(user.hasRoleAdmin()).thenReturn(false);
        when(user.hasRoleSuperAdmin()).thenReturn(false);
        when(userRepository.findByEmailOrLogin(user.getLogin())).thenReturn(of(user));

        // When
        deleteUserUseCase.execute(user.getLogin());

        // Then
        verify(userRepository).findByEmailOrLogin(user.getLogin());
        verify(userRepository).delete(user.getId());
        verify(userEventPublisher).publishUserDeleting(any());
    }
}
