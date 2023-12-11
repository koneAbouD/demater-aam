package com.demater.core.usecase.user;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.UserDetailsGettingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserDetailsUseCase {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public User execute(String email) {
        User user = userRepository.findByEmailOrLogin(email)
                .orElseThrow(() -> new UserNotFoundException("User [" + email + "] not exists"));
        userEventPublisher.publishUserDetailsGetting(new UserDetailsGettingEvent(email));
        return user;
    }
}
