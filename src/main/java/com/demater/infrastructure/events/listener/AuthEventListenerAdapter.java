package com.demater.infrastructure.events.listener;

import com.demater.core.event.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthEventListenerAdapter {
    @EventListener
    public void handle(UserCreatedEvent event) {
        log.info("User [" + event.getUser().toString() + " ] created at " + event.getDate());
    }

    @EventListener
    public void handle(UserAuthenticatedEvent event) {
        log.info("User [" + event.getUser().toString() + " ] logged at " + event.getDate());
    }

    @EventListener
    public void handle(UserCheckedEvent event) {
        log.info("User [" + event.getUser().toString() + " ] account checked at " + event.getDate());
    }

    @EventListener
    public void handle(ResetPasswordMailSentEvent event) {
        log.info("User [" + event.getEmail() + " ] reset password at " + event.getDate());
    }

    @EventListener
    public void handle(ResetPasswordEvent event) {
        log.info("User [" + event.getEmail() + " ] reset password at " + event.getDate());
    }

    @EventListener
    public void handle(DeleteANonValidAccountEvent event) {
        log.info("A non valid User [" + event.getEmail() + " ] has been deleted at " + event.getDate());
    }
}
