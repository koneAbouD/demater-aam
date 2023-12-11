package com.demater.core.usecase.admin;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserDeletingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.admin.exception.AdminDeletingException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public void execute(String login) {
        User user = userRepository.findByEmailOrLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User [" + login + "] not exists"));

        if (user.hasRoleSuperAdmin() || user.hasRoleAdmin()) {
            throw new AdminDeletingException("User [" + login + "] have Admin role, so can't be delete");
        }

        userRepository.delete(user.getId());
        userEventPublisher.publishUserDeleting(new UserDeletingEvent(login));
    }
}
