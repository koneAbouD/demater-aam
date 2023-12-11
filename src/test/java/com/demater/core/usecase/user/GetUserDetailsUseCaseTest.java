package com.demater.core.usecase.user;

import com.demater.builder.UserMB;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserDetailsGettingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetUserDetailsUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserEventPublisher userEventPublisher;
    private GetUserDetailsUseCase getUserDetailsUseCase;

    @BeforeEach
    void setUp() {
        getUserDetailsUseCase = new GetUserDetailsUseCase(userRepository, userEventPublisher);
    }

    @Test
    void should_throw_when_get_user_details_with_user_dont_exist() {
        // Given
        String email = "sss@gmail.com";
        when(userRepository.findByEmailOrLogin(email)).thenReturn(Optional.empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> getUserDetailsUseCase.execute(email));

        // Then
        assertEquals("User [sss@gmail.com] not exists", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(email);
        verify(userEventPublisher, never()).publishUserDetailsGetting(new UserDetailsGettingEvent(email));
    }

    @Test
    void should_get_user_details() {
        // Given
        String email = "sss@gmail.com";
        User user = new UserMB().withEmail(email).withValid(true).build();
        when(userRepository.findByEmailOrLogin(email)).thenReturn(Optional.of(user));

        // When
        getUserDetailsUseCase.execute(email);

        // Then
        verify(userRepository).findByEmailOrLogin(email);
        verify(userEventPublisher).publishUserDetailsGetting(any());
    }
}
