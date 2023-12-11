package com.demater.core.usecase.admin;

import com.demater.core.domain.user.Position;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserCreatedEvent;
import com.demater.core.port.*;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.usecase.auth.exception.UserAlreadyExistsException;
import com.demater.core.usecase.common.exception.AdminCreatingException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.demater.core.domain.common.Constants.*;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final RoleRepository roleRepository;
    private final AuthEventPublisher authEventPublisher;
    private final Password password;
    private final Notification notification;

    public User execute(User user) {
        if (userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }

        User userToSave = registerUser(user);
        sendAccountCreatedMail(userToSave);
        authEventPublisher.publishUserCreated(new UserCreatedEvent(user));
        return userToSave;
    }

    private User registerUser(User user) {
        String passwordGenerated = password.generatePassword();
        user.updateUserForCreatingWith(getPositions(user),
                getUserRoles(user),
                password.encode(passwordGenerated),
                password.generateJwtToken(user.getLogin()),
                passwordGenerated);
        return userRepository.save(user);
    }

    private Set<Position> getPositions(User user) {
        return positionRepository.findAllByCodeIn(user.codesPositions());
    }

    private Set<Role> getUserRoles(User user) {
        if (user.getRoles().isEmpty()) {
            throw new RoleNotFoundException(ROLES_ARE_NOT_FOUND);
        }

        if (user.hasRoleSuperAdminOrAdmin()) {
            throw new AdminCreatingException(ADMIN_CREATING);
        }

        return roleRepository.findAllByNameIn(user.rolesNames());
    }

    private void sendAccountCreatedMail(User user) {
        notification.notifyForAccountCreated(user);
    }
}
