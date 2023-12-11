package com.demater.core.usecase.auth;

import com.demater.core.domain.auth.CredentialsForResetPassword;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.ResetPasswordEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATE;
import static com.demater.core.domain.common.Constants.USER_NOT_FOUND_WITH_THIS_TOKEN;

@RequiredArgsConstructor
public class ResetPasswordUseCase {
    private final UserRepository userRepository;
    private final Password password;
    private final Notification notification;
    private final AuthEventPublisher authEventPublisher;

    public void execute(CredentialsForResetPassword credentials) {
        User user = userRepository.findByEmailAndConfirmationToken(credentials.email(), credentials.token())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_WITH_THIS_TOKEN));

        if (!user.isValid()) {
            throw new UserNotActivatedException(USER_NOT_ACTIVATE);
        }

        user.setPassword(password.encode(credentials.password()));
        user = userRepository.save(user);
        sendEmailToConfirmPasswordChanged(user);
        authEventPublisher.publishUserResetPassword(new ResetPasswordEvent(user.getEmail()));
    }

    private void sendEmailToConfirmPasswordChanged(User user) {
        notification.notifyForResetPassword(user);
    }
}
