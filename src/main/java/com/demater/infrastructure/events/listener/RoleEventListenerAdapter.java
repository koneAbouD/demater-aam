package com.demater.infrastructure.events.listener;

import com.demater.core.event.user.RolesGettingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RoleEventListenerAdapter {
    @EventListener
    public void handle(RolesGettingEvent event) {
        log.info("Roles retrieved at " + event.getDate());
    }
}
