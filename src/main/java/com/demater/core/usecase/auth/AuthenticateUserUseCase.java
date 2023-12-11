package com.demater.core.usecase.auth;

import com.demater.core.domain.auth.AuthCredentials;
import com.demater.core.domain.auth.UserCredentials;
import com.demater.core.event.user.UserAuthenticatedEvent;
import com.demater.core.port.Authentication;
import com.demater.core.publisher.AuthEventPublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticateUserUseCase {
    private final Authentication authentication;
    private final AuthEventPublisher authEventPublisher;

    public UserCredentials execute(AuthCredentials credentials) {
        UserCredentials user = authentication.authenticate(credentials);
        authEventPublisher.publishUserAuthenticated(new UserAuthenticatedEvent(user));
        return user;
    }
}
