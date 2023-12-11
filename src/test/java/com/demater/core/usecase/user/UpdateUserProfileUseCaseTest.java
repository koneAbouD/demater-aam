package com.demater.core.usecase.user;

import com.demater.builder.UserMB;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserProfileUpdatingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
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
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class UpdateUserProfileUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserEventPublisher userEventPublisher;
    private UpdateUserProfileUseCase updateUserProfileUseCase;

    @BeforeEach
    void setUp() {
        updateUserProfileUseCase = new UpdateUserProfileUseCase(userRepository, userEventPublisher);
    }

    @Test
    void should_throw_when_update_user_profile_with_user_dont_exist() {
        // Given
        User user = new UserMB().withEmail("ssdsd@gmail.com").build();
        when(userRepository.findByEmailOrLogin(user.getEmail())).thenReturn(empty());

        // When
        Exception exception = assertThrows(UserNotFoundException.class, () -> updateUserProfileUseCase.execute(user));

        // Then
        assertEquals("User [" + user.getEmail() + "] not exists", exception.getMessage());
        verify(userRepository).findByEmailOrLogin(user.getEmail());
        verify(userRepository, never()).save(user);
        verify(userEventPublisher, never()).publishUserProfileUpdating(new UserProfileUpdatingEvent(user.getEmail()));
    }

    @Test
    void should_update_user_profile() {
        // Given
        String email = "ssdsd@gmail.com";
        String firstName = "aaaaa";
        String lastName = "bbbbb";
        User user = new UserMB().withEmail(email).withFirstName(firstName).withLastName(lastName).build();
        when(userRepository.findByEmailOrLogin(user.getEmail())).thenReturn(of(user));

        // When
        updateUserProfileUseCase.execute(user);

        // Then
        verify(userRepository).findByEmailOrLogin(user.getEmail());
        verify(user).updateProfileWith(firstName, lastName);
        verify(userRepository).save(user);
        verify(userEventPublisher).publishUserProfileUpdating(any());
    }
}
