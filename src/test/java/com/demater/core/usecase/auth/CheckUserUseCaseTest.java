package com.demater.core.usecase.auth;

import com.demater.builder.UserMB;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserCheckedEvent;
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

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATED;
import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CheckUserUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthEventPublisher authEventPublisher;
    private CheckUserUseCase checkUserUseCase;

    @BeforeEach
    void setUp() {
        checkUserUseCase = new CheckUserUseCase(userRepository, authEventPublisher);
    }

    @Test
    void should_check_user_with_user_dont_exists() {
        // Given
        String confirmationCode = "qdsqdsqdsq";
        when(userRepository.findByConfirmationToken(confirmationCode)).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> checkUserUseCase.execute(confirmationCode));

        // Then
        assertEquals(USER_NOT_FOUND_WITH_THIS_TOKEN, exception.getMessage());
        verify(userRepository).findByConfirmationToken(confirmationCode);
        verify(authEventPublisher, never()).publishUserChecked(new UserCheckedEvent(any()));
    }

    @Test
    void should_check_user_with_user_not_validate() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withValid(false).build();
        String confirmationCode = "qdsqdsqdsq";
        when(userRepository.findByConfirmationToken(confirmationCode)).thenReturn(Optional.of(user));

        // When
        Exception exception = assertThrows(UserNotActivatedException.class, () -> checkUserUseCase.execute(confirmationCode));

        // Then
        assertEquals(USER_NOT_ACTIVATED, exception.getMessage());
        verify(userRepository).findByConfirmationToken(confirmationCode);
        verify(authEventPublisher, never()).publishUserChecked(new UserCheckedEvent(any()));
    }

    @Test
    void should_check_user() {
        // Given
        User user = new UserMB().withEmail("soum@gmail.com").withValid(true).build();
        String confirmationCode = "qdsqdsqdsq";
        when(userRepository.findByConfirmationToken(confirmationCode)).thenReturn(Optional.of(user));

        // When
        User userChecked = checkUserUseCase.execute(confirmationCode);

        // Then
        verify(userRepository).findByConfirmationToken(confirmationCode);
        assertNotNull(userChecked);
        verify(authEventPublisher).publishUserChecked(any());
    }
}
