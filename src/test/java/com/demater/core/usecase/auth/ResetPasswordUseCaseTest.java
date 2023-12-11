package com.demater.core.usecase.auth;

import com.demater.builder.UserMB;
import com.demater.core.domain.auth.CredentialsForResetPassword;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.ResetPasswordEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATE;
import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class ResetPasswordUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private Password password;
    @Mock
    private Notification notification;
    @Mock
    private AuthEventPublisher authEventPublisher;
    private ResetPasswordUseCase resetPasswordUseCase;

    @BeforeEach
    void setUp() {
        resetPasswordUseCase = new ResetPasswordUseCase(userRepository, password, notification, authEventPublisher);
    }

    @Test
    void should_throw_when_reset_password_with_user_not_exist() {
        // Given
        CredentialsForResetPassword credentials = new CredentialsForResetPassword("ss@gmail.com", "qdkhqsfbdsqjbfjsqbf", "bonjour");
        when(userRepository.findByEmailAndConfirmationToken(credentials.email(), credentials.token())).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> resetPasswordUseCase.execute(credentials));

        // Then
        Assertions.assertEquals(USER_NOT_FOUND_WITH_THIS_TOKEN, exception.getMessage());
        verify(userRepository, never()).save(any());
        verify(notification, never()).notifyForResetPassword(any());
        verify(authEventPublisher, never()).publishUserResetPassword(new ResetPasswordEvent(any()));
    }

    @Test
    void should_throw_when_reset_password_with_user_not_activated() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withValid(false).build();
        CredentialsForResetPassword credentials = new CredentialsForResetPassword("ss@gmail.com", "qdkhqsfbdsqjbfjsqbf", "bonjour");
        when(userRepository.findByEmailAndConfirmationToken(credentials.email(), credentials.token())).thenReturn(Optional.of(user));

        // When
        Exception exception = assertThrows(UserNotActivatedException.class, () -> resetPasswordUseCase.execute(credentials));

        // Then
        Assertions.assertEquals(USER_NOT_ACTIVATE, exception.getMessage());
        verify(userRepository, never()).save(any());
        verify(notification, never()).notifyForResetPassword(user);
        verify(authEventPublisher, never()).publishUserResetPassword(new ResetPasswordEvent(user.getEmail()));
    }

    @Test
    void should_reset_password() {
        // Given
        User user = new UserMB().withLastName("DIAK")
                .withFirstName("Soum")
                .withEmail("soum@gmail.com")
                .withValid(true).build();
        CredentialsForResetPassword credentials = new CredentialsForResetPassword("ss@gmail.com", "qdkhqsfbdsqjbfjsqbf", "bonjour");
        when(userRepository.findByEmailAndConfirmationToken(credentials.email(), credentials.token())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        // When
        resetPasswordUseCase.execute(credentials);

        // Then
        verify(password).encode(credentials.password());
        verify(user).setPassword(any());
        verify(userRepository).save(any());
        verify(notification).notifyForResetPassword(user);
        verify(authEventPublisher).publishUserResetPassword(any());
    }
}
