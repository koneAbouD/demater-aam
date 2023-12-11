package com.demater.core.usecase.auth;

import com.demater.core.port.Authentication;
import com.demater.core.publisher.AuthEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthenticateUserUseCaseTest {
    @Mock
    private Authentication authentication;
    @Mock
    private AuthEventPublisher authEventPublisher;
    private AuthenticateUserUseCase authenticateUserUseCase;

    @BeforeEach
    void setUp() {
        authenticateUserUseCase = new AuthenticateUserUseCase(authentication, authEventPublisher);
    }


}
