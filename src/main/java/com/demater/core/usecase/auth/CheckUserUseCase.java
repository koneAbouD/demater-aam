package com.demater.core.usecase.auth;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserCheckedEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATED;
import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;

@RequiredArgsConstructor
public class CheckUserUseCase {
    private final UserRepository userRepository;
    private final AuthEventPublisher authEventPublisher;

    public User execute(String confirmationCode) {
        User user = userRepository.findByConfirmationToken(confirmationCode)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_WITH_THIS_TOKEN));

        if (!user.isValid()) {
            throw new UserNotActivatedException(USER_NOT_ACTIVATED);
        }

        authEventPublisher.publishUserChecked(new UserCheckedEvent(user));
        return user;
    }
}
