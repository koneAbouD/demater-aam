package com.demater.core.usecase.auth;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.ResetPasswordMailSentEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATE;

@RequiredArgsConstructor
public class SendResetPasswordUseCase {
    private final UserRepository userRepository;
    private final Password password;
    private final Notification notification;
    private final AuthEventPublisher authEventPublisher;

    public void execute(String email) {
        User user = userRepository.findByEmailOrLogin(email)
                .orElseThrow(() -> new UserNotFoundException("User [" + email + "] not found"));

        if (!user.isValid()) {
            throw new UserNotActivatedException(USER_NOT_ACTIVATE);
        }

        String token = password.generateJwtToken(email);
        String passwordGenerated = password.generatePassword();
        user.updateForResetPasswordWith(token, passwordGenerated, password.encode(passwordGenerated));
        userRepository.save(user);
        sendResetPasswordMail(user);
        authEventPublisher.publishResetPasswordLinkSent(new ResetPasswordMailSentEvent(email));
    }

    private void sendResetPasswordMail(User user) {
        notification.notifyForResetPasswordSent(user);
    }
}
