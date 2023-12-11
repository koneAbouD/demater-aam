package com.demater.infrastructure.events.publisher;

import com.demater.core.event.user.*;
import com.demater.core.publisher.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class UserEventPublisherAdapter implements UserEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishUserPasswordUpdating(UpdatePasswordEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserDetailsGetting(UserDetailsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserProfileUpdating(UserProfileUpdatingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUsersGetting(UsersGettingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserUpdatingByAdmin(UserUpdatingByAdminEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserDeleting(UserDeletingEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishPositionsGettingEvent(PositionsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }
}
