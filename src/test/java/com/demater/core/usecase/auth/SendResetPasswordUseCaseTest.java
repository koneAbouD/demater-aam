package com.demater.core.usecase.auth;

import com.demater.builder.UserMB;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.ResetPasswordMailSentEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATE;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class SendResetPasswordUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private Password password;
    @Mock
    private Notification notification;
    @Mock
    private AuthEventPublisher authEventPublisher;
    private SendResetPasswordUseCase sendResetPasswordUseCase;

    @BeforeEach
    void setUp() {
        sendResetPasswordUseCase = new SendResetPasswordUseCase(userRepository,
                password,
                notification,
                authEventPublisher
        );
    }

    @Test
    void should_throw_when_send_reset_password_mail_with_user_not_exists() {
        // Given
        String email = "ss@gmail.com";
        when(userRepository.findByEmailOrLogin(email)).thenReturn(Optional.empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> sendResetPasswordUseCase.execute(email));

        // Then
        assertEquals("User [ss@gmail.com] not found", exception.getMessage());
        verify(password, never()).generateJwtToken(email);
        verify(userRepository, never()).save(any());
        verify(authEventPublisher, never()).publishResetPasswordLinkSent(new ResetPasswordMailSentEvent(email));
        verify(notification, never()).notifyForResetPasswordSent(any());
    }

    @Test
    void should_throw_when_send_reset_password_mail_with_user_not_activate() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withValid(false).build();
        when(userRepository.findByEmailOrLogin(user.getEmail())).thenReturn(of(user));

        // When
        Exception exception = assertThrows(UserNotActivatedException.class, () -> sendResetPasswordUseCase.execute(user.getEmail()));

        // Then
        assertEquals(USER_NOT_ACTIVATE, exception.getMessage());
        verify(userRepository).findByEmailOrLogin(user.getEmail());
        verify(authEventPublisher, never()).publishResetPasswordLinkSent(new ResetPasswordMailSentEvent(user.getEmail()));
        verify(notification, never()).notifyForResetPasswordSent(any());
    }

    @Test
    void should_send_reset_password_mail() {
        // Given
        String token = "dqkldfqfbsjnf123&kfdfn";
        String passwordGenerated = "14341vbWJ@!cbdscbwx";
        String passwordEncoded = "14341vbWJ@!cbdscbwx14341vbWJ131ffjbdsfsbdfdsfbb";
        User user = new UserMB().withEmail("soum@gmail.com").withValid(true).build();
        when(userRepository.findByEmailOrLogin(user.getEmail())).thenReturn(of(user));
        when(password.generateJwtToken(user.getEmail())).thenReturn(token);
        when(password.encode(passwordGenerated)).thenReturn(passwordEncoded);
        when(password.generatePassword()).thenReturn(passwordGenerated);

        // When
        sendResetPasswordUseCase.execute(user.getEmail());

        // Then
        verify(userRepository).findByEmailOrLogin(user.getEmail());
        verify(password).generateJwtToken(user.getEmail());
        verify(password).encode(passwordGenerated);
        verify(password).generatePassword();
        verify(user).updateForResetPasswordWith(token, passwordGenerated, passwordEncoded);
        verify(userRepository).save(user);
        verify(notification).notifyForResetPasswordSent(user);
        verify(authEventPublisher).publishResetPasswordLinkSent(any());
    }
}
