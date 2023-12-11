package com.demater.core.usecase.user;

import com.demater.builder.UserMB;
import com.demater.core.domain.auth.CredentialsForUpdatePassword;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UpdatePasswordEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class UpdateUserPasswordUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private Password password;
    @Mock
    private Notification notification;
    @Mock
    private UserEventPublisher userEventPublisher;
    private UpdateUserPasswordUseCase updateUserPasswordUseCase;

    @BeforeEach
    void setUp() {
        updateUserPasswordUseCase = new UpdateUserPasswordUseCase(userRepository,
                password,
                notification,
                userEventPublisher
        );
    }

    @Test
    void should_throw_when_update_password_with_user_dont_exist() {
        // Given
        CredentialsForUpdatePassword credentials = new CredentialsForUpdatePassword("ssdsd@gmail.com", "qdsqjbdsqd");
        when(userRepository.findByEmailOrLogin(credentials.email())).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> updateUserPasswordUseCase.execute(credentials));

        // Then
        assertEquals("User [" + credentials.email() + "] not exists", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(credentials.email());
        verify(userRepository, never()).save(any(User.class));
        verify(notification, never()).notifyForUserPasswordUpdating(any());
        verify(userEventPublisher, never()).publishUserPasswordUpdating(new UpdatePasswordEvent(credentials.email()));
    }

    @Test
    void should_throw_when_update_password_with_user_not_activate() {
        // Given
        CredentialsForUpdatePassword credentials = new CredentialsForUpdatePassword("ssdsd@gmail.com", "qdsqjbdsqd");
        User user = new UserMB().withEmail("ssdsd@gmail.com").withValid(false).build();
        when(userRepository.findByEmailOrLogin(credentials.email())).thenReturn(of(user));

        // When
        Exception exception = assertThrows(UserNotActivatedException.class, () -> updateUserPasswordUseCase.execute(credentials));

        // Then
        assertEquals("User [" + credentials.email() + "] not activated", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(credentials.email());
        verify(userRepository, never()).save(any(User.class));
        verify(notification, never()).notifyForUserPasswordUpdating(user);
        verify(userEventPublisher, never()).publishUserPasswordUpdating(new UpdatePasswordEvent(credentials.email()));
    }

    @Test
    void should_update_password() {
        // Given
        CredentialsForUpdatePassword credentials = new CredentialsForUpdatePassword("ssdsd@gmail.com", "qdsqjbdsqd");
        User user = new UserMB().withEmail(credentials.email()).withValid(true).build();
        when(userRepository.findByEmailOrLogin(credentials.email())).thenReturn(of(user));
        when(password.encode(credentials.password())).thenReturn("qdsdjsqdqs@@&@");

        // When
        updateUserPasswordUseCase.execute(credentials);

        // Then
        verify(userRepository).findByEmailOrLogin(credentials.email());
        verify(password).encode(credentials.password());
        verify(user).setPassword("qdsdjsqdqs@@&@");
        verify(userRepository).save(user);
        verify(notification).notifyForUserPasswordUpdating(user);
        verify(userEventPublisher).publishUserPasswordUpdating(any());
    }
}
