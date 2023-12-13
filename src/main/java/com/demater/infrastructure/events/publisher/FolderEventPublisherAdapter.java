package com.demater.infrastructure.events.publisher;

import com.demater.core.event.folder.FoldersGettingEvent;
import com.demater.core.event.user.RolesGettingEvent;
import com.demater.core.publisher.FolderEventPublisher;
import com.demater.core.publisher.RoleEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class FolderEventPublisherAdapter implements FolderEventPublisher {
    private final ApplicationEventPublisher eventPublisher;


    @Override
    public void publishFoldersGettingEvent(FoldersGettingEvent event) {
        eventPublisher.publishEvent(event);
    }
}
