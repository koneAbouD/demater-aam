package com.demater.core.publisher;

import com.demater.core.event.user.RolesGettingEvent;

public interface RoleEventPublisher {
    void publishRolesGettingEvent(RolesGettingEvent event);
}
