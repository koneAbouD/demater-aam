package com.demater.infrastructure.events.publisher;

import com.demater.core.event.user.*;
import com.demater.core.publisher.AuthEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class AuthEventPublisherAdapter implements AuthEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishUserCreated(UserCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserAuthenticated(UserAuthenticatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserChecked(UserCheckedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishResetPasswordLinkSent(ResetPasswordMailSentEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishUserResetPassword(ResetPasswordEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishANonValidAccount(DeleteANonValidAccountEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
