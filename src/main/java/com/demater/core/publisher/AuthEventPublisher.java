package com.demater.core.publisher;

import com.demater.core.event.user.*;

public interface AuthEventPublisher {
    void publishUserCreated(UserCreatedEvent event);
    void publishUserAuthenticated(UserAuthenticatedEvent event);
    void publishUserChecked(UserCheckedEvent event);
    void publishResetPasswordLinkSent(ResetPasswordMailSentEvent event);
    void publishUserResetPassword(ResetPasswordEvent event);
    void publishANonValidAccount(DeleteANonValidAccountEvent event);
}
