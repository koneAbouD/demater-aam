package com.demater.core.publisher;

import com.demater.core.event.user.*;

public interface UserEventPublisher {
    void publishUserPasswordUpdating(UpdatePasswordEvent event);
    void publishUserDetailsGetting(UserDetailsGettingEvent event);
    void publishUserProfileUpdating(UserProfileUpdatingEvent event);
    void publishUsersGetting(UsersGettingEvent event);
    void publishUserUpdatingByAdmin(UserUpdatingByAdminEvent event);
    void publishUserDeleting(UserDeletingEvent event);
    void publishPositionsGettingEvent(PositionsGettingEvent event);
}
