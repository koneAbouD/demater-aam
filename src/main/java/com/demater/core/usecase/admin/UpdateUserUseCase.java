package com.demater.core.usecase.admin;

import com.demater.core.domain.user.Position;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserUpdatingByAdminEvent;
import com.demater.core.port.PositionRepository;
import com.demater.core.port.RoleRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.AdminCreatingException;
import com.demater.core.usecase.common.exception.RoleNotFoundException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.demater.core.domain.common.Constants.ROLES_ARE_NOT_FOUND;
import static com.demater.core.domain.common.Constants.SUPER_ADMIN_CREATING;

@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final RoleRepository roleRepository;
    private final UserEventPublisher userEventPublisher;

    public User execute(String login, User user) {
        User userToUpdate = userRepository.findByEmailOrLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User [" + login + "] not exists"));
        Set<Role> roles = getUserRoles(user);
        userToUpdate.updateProfileWith(user.getFirstName(),
                user.getLastName(),
                roles,
                user.isValid(),
                user.isActivate());
        User userSaved = userRepository.save(userToUpdate);
        userEventPublisher.publishUserUpdatingByAdmin(new UserUpdatingByAdminEvent(login));
        return userSaved;
    }

    private Set<Role> getUserRoles(User user) {
        if (user.getRoles().isEmpty()) {
            throw new RoleNotFoundException(ROLES_ARE_NOT_FOUND);
        }

        if (user.hasRoleSuperAdmin()) {
            throw new AdminCreatingException(SUPER_ADMIN_CREATING);
        }

        return roleRepository.findAllByNameIn(user.rolesNames());
    }
}
