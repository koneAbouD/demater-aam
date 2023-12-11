package com.demater.core.usecase.admin;

import com.demater.core.domain.user.User;
import com.demater.core.event.user.UsersGettingEvent;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
public class GetAllUserDetailsUseCase {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public List<User> execute() {
        List<User> users = userRepository.findAll()
                .stream()
                .filter(not(User::hasRoleSuperAdmin))
                .sorted(Comparator.comparing(User::getFirstName)
                        .thenComparing(User::getLastName))
                .toList();
        userEventPublisher.publishUsersGetting(new UsersGettingEvent());
        return users;
    }
}
