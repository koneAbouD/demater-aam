package com.demater.core.usecase.user;

import com.demater.core.domain.auth.CredentialsForUpdatePassword;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UpdatePasswordEvent;
import com.demater.core.port.Notification;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserPasswordUseCase {
    private final UserRepository userRepository;
    private final Password password;
    private final Notification notification;
    private final UserEventPublisher userEventPublisher;

    public void execute(CredentialsForUpdatePassword credentials) {
        User user = userRepository.findByEmailOrLogin(credentials.email())
                .orElseThrow(() -> new UserNotFoundException("User [" + credentials.email() + "] not exists"));

        if (!user.isValid()) {
            throw new UserNotActivatedException("User [" + credentials.email() + "] not activated");
        }

        user.setPassword(password.encode(credentials.password()));
        userRepository.save(user);
        sendEmailForPasswordUpdated(user);
        userEventPublisher.publishUserPasswordUpdating(new UpdatePasswordEvent(credentials.email()));
    }

    private void sendEmailForPasswordUpdated(User user) {
        notification.notifyForUserPasswordUpdating(user);
    }
}
