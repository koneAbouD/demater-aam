package com.demater.infrastructure.events.listener;

import com.demater.core.event.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventListenerAdapter {
    @EventListener
    public void handle(UpdatePasswordEvent event) {
        log.info("A User [" + event.getEmail() + " ] has been updated his password at " + event.getDate());
    }

    @EventListener
    public void handle(UserDetailsGettingEvent event) {
        log.info("A User [" + event.getEmail() + "] has been retrieved at " + event.getDate());
    }

    @EventListener
    public void handle(UserProfileUpdatingEvent event) {
        log.info("A user [" + event.getEmail() + "] has been updating at " + event.getDate());
    }

    @EventListener
    public void handle(UsersGettingEvent event) {
        log.info("All Users got at : " + event.getDate());
    }

    @EventListener
    public void handle(UserUpdatingByAdminEvent event) {
        log.info("User [" + event.getLogin() + "] updated by admin at " + event.getDate());
    }

    @EventListener
    public void handle(UserDeletingEvent event) {
        log.info("User [" + event.getLogin() + "] deleted by admin at " + event.getDate());
    }

    @EventListener
    public void handle(PositionsGettingEvent event) {
        log.info("Positions retrieved at " + event.getDate());
    }
}
