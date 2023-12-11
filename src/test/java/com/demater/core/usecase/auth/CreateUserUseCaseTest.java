package com.demater.core.usecase.auth;

import com.demater.builder.RoleMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.user.ERole;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserCreatedEvent;
import com.demater.core.port.*;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.admin.CreateUserUseCase;
import com.demater.core.usecase.auth.exception.UserAlreadyExistsException;
import com.demater.core.usecase.common.exception.AdminCreatingException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Set;

import static com.demater.core.domain.common.Constants.*;
import static com.demater.core.domain.user.ERole.ROLE_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateUserUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PositionRepository positionRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private AuthEventPublisher authEventPublisher;
    @Mock
    private Password password;
    @Mock
    private Notification notification;
    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(userRepository,
                positionRepository,
                roleRepository,
                authEventPublisher,
                password,
                notification);
    }

    @Test
    void should_throw_when_save_user_with_user_already_exists() {
        // Given
        User user = new UserMB().withLogin("dsoumaila").withEmail("ss@gmail.com").build();
        when(userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())).thenReturn(true);

        // When
        Exception exception = assertThrows(UserAlreadyExistsException.class, () -> createUserUseCase.execute(user));

        // Then
        assertEquals(USER_ALREADY_EXISTS, exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
        verify(authEventPublisher, never()).publishUserCreated(new UserCreatedEvent(any()));
    }

    @Test
    void should_throw_when_save_user_with_roles_is_empty() {
        // Given
        User user = new UserMB().withLogin("dsoumaila").withEmail("ss@gmail.com")
                .withPositions(Set.of())
                .withRoles(Set.of()).build();
        when(user.codesPositions()).thenReturn(Set.of());
        when(userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())).thenReturn(false);
        when(positionRepository.findAllByCodeIn(user.codesPositions())).thenReturn(Set.of());

        // When
        Exception exception = assertThrows(RoleNotFoundException.class, () -> createUserUseCase.execute(user));

        // Then
        assertEquals(ROLES_ARE_NOT_FOUND, exception.getMessage());
        verify(userRepository).existsByEmailOrLogin(user.getEmail(), user.getLogin());
        verify(positionRepository).findAllByCodeIn(user.codesPositions());
        verify(userRepository, never()).save(any(User.class));
        verify(authEventPublisher, never()).publishUserCreated(new UserCreatedEvent(any()));
    }

    @Test
    void should_throw_when_save_user_with_roles_admin() {
        // Given
        Role role = new RoleMB().withName(ERole.ROLE_ADMIN).build();
        User user = new UserMB().withLogin("dsoumaila").withEmail("ss@gmail.com")
                .withPositions(Set.of())
                .withRoles(Set.of(role)).build();
        when(user.codesPositions()).thenReturn(Set.of());
        when(user.hasRoleSuperAdminOrAdmin()).thenReturn(true);
        when(userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())).thenReturn(false);
        when(positionRepository.findAllByCodeIn(user.codesPositions())).thenReturn(Set.of());

        // When
        Exception exception = assertThrows(AdminCreatingException.class, () -> createUserUseCase.execute(user));

        // Then
        assertEquals(ADMIN_CREATING, exception.getMessage());
        verify(userRepository).existsByEmailOrLogin(user.getEmail(), user.getLogin());
        verify(positionRepository).findAllByCodeIn(user.codesPositions());
        verify(userRepository, never()).save(any(User.class));
        verify(authEventPublisher, never()).publishUserCreated(new UserCreatedEvent(any()));
    }

    @Test
    void should_save_user() {
        // Given
        Role role = new RoleMB().withName(ROLE_USER).build();
        User user = new UserMB().withLogin("dsoumaila").withEmail("ss@gmail.com").withPositions(Set.of()).withRoles(Set.of(role)).build();
        when(user.codesPositions()).thenReturn(Set.of());
        when(user.hasRoleSuperAdminOrAdmin()).thenReturn(false);
        when(user.rolesNames()).thenReturn(Set.of(ROLE_USER));
        when(userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())).thenReturn(false);
        String passwordGenerated = "14341vbWJ@!cbdscbwx";
        when(positionRepository.findAllByCodeIn(user.codesPositions())).thenReturn(Set.of());
        when(roleRepository.findAllByNameIn(user.rolesNames())).thenReturn(Set.of(role));
        when(password.generatePassword()).thenReturn(passwordGenerated);
        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        createUserUseCase.execute(user);

        // Then
        verify(userRepository).existsByEmailOrLogin(user.getEmail(), user.getLogin());
        verify(positionRepository).findAllByCodeIn(user.codesPositions());
        verify(roleRepository).findAllByNameIn(user.rolesNames());
        verify(password).generatePassword();
        verify(password).encode(passwordGenerated);
        verify(password).generateJwtToken(user.getLogin());
        verify(userRepository).save(any(User.class));
        verify(authEventPublisher).publishUserCreated(any());
    }
}
