package com.demater.infrastructure.events.publisher;

import com.demater.core.event.user.RolesGettingEvent;
import com.demater.core.publisher.RoleEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class RoleEventPublisherAdapter implements RoleEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishRolesGettingEvent(RolesGettingEvent event) {
        eventPublisher.publishEvent(event);
    }
}
