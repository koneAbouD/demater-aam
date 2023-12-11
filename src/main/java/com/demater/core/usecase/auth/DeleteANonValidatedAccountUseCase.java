package com.demater.core.usecase.auth;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.DeleteANonValidAccountEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.auth.exception.UserAlreadyActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;
import static com.demater.core.domain.common.Constants.USER_WITH_THIS_TOKEN_IS_ALREADY_ACTIVATE;

@RequiredArgsConstructor
public class DeleteANonValidatedAccountUseCase {
    private final UserRepository userRepository;
    private final AuthEventPublisher authEventPublisher;
    private final Notification notification;

    public void execute(String token) {
        User user = userRepository.findByConfirmationToken(token)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_WITH_THIS_TOKEN));

        if (user.isValid()) {
            throw new UserAlreadyActivatedException(USER_WITH_THIS_TOKEN_IS_ALREADY_ACTIVATE);
        }

        userRepository.delete(user.getId());
        sendEmailForNonValidateAccountDeleting(user);
        authEventPublisher.publishANonValidAccount(new DeleteANonValidAccountEvent(user.getEmail()));
    }

    private void sendEmailForNonValidateAccountDeleting(User user) {
        notification.notifyForAccountDeleted(user);
    }
}
