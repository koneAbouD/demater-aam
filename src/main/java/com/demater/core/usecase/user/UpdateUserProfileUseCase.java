package com.demater.core.usecase.user;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserProfileUpdatingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserProfileUseCase {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public User execute(User user) {
        User userToUpdated = userRepository.findByEmailOrLogin(user.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User [" + user.getEmail() + "] not exists"));
        userToUpdated.updateProfileWith(user.getFirstName(), user.getLastName());
        User userUpdated = userRepository.save(userToUpdated);
        userEventPublisher.publishUserProfileUpdating(new UserProfileUpdatingEvent(user.getEmail()));
        return userUpdated;
    }
}
