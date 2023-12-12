package com.demater.core.port;

import com.demater.core.exception.NotificationException;
import com.demater.core.domain.user.User;

public interface Notification {
    void notifyForAccountCreated(User user) throws NotificationException;
    void notifyForResetPasswordSent(User user);
    void notifyForResetPassword(User user);
    void notifyForAccountDeleted(User user);
    void notifyForUserPasswordUpdating(User user);
}
