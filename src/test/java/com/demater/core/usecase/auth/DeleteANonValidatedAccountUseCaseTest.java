package com.demater.core.usecase.auth;

import com.demater.builder.UserMB;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.DeleteANonValidAccountEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.auth.exception.UserAlreadyActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;
import static com.demater.core.domain.common.Constants.USER_WITH_THIS_TOKEN_IS_ALREADY_ACTIVATE;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class DeleteANonValidatedAccountUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthEventPublisher authEventPublisher;
    @Mock
    private Notification notification;
    private DeleteANonValidatedAccountUseCase deleteANonValidatedAccountUseCase;

    @BeforeEach
    void setUp() {
        deleteANonValidatedAccountUseCase = new DeleteANonValidatedAccountUseCase(
                userRepository, authEventPublisher, notification
        );
    }

    @Test
    void should_throw_when_delete_a_non_valid_account_with_token_dont_exist() {
        // Given
        String token = "sfndsjhdsjfnds";
        when(userRepository.findByEmailOrLogin(token)).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> deleteANonValidatedAccountUseCase.execute(token));

        // Then
        Assertions.assertEquals(USER_NOT_FOUND_WITH_THIS_TOKEN, exception.getMessage());
        verify(userRepository).findByConfirmationToken(token);
        verify(notification, never()).notifyForAccountDeleted(any());
        verify(authEventPublisher, never()).publishANonValidAccount(new DeleteANonValidAccountEvent(any()));
    }

    @Test
    void should_throw_when_delete_a_non_valid_account_with_account_already_validate() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withConfirmationToken("sfjdsbfsdjbfds").withValid(true).build();
        when(userRepository.findByConfirmationToken(user.getConfirmationToken())).thenReturn(Optional.of(user));

        // When
        Exception exception = assertThrows(UserAlreadyActivatedException.class,
                () -> deleteANonValidatedAccountUseCase.execute(user.getConfirmationToken()));

        // Then
        Assertions.assertEquals(USER_WITH_THIS_TOKEN_IS_ALREADY_ACTIVATE, exception.getMessage());
        verify(userRepository).findByConfirmationToken(user.getConfirmationToken());
        verify(notification, never()).notifyForAccountDeleted(any());
        verify(authEventPublisher, never()).publishANonValidAccount(new DeleteANonValidAccountEvent(any()));
    }

    @Test
    void should_delete_a_non_valid_account() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withConfirmationToken("sfjdsbfsdjbfds").withValid(false).build();
        when(userRepository.findByConfirmationToken(user.getConfirmationToken())).thenReturn(Optional.of(user));

        // When
        deleteANonValidatedAccountUseCase.execute(user.getConfirmationToken());

        // Then
        verify(userRepository).findByConfirmationToken(user.getConfirmationToken());
        verify(userRepository).delete(user.getId());
        verify(notification).notifyForAccountDeleted(user);
        verify(authEventPublisher).publishANonValidAccount(any());
    }
}
