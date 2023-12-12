package com.demater.core.publisher;

import com.demater.core.event.folder.FoldersGettingEvent;

public interface FolderEventPublisher {
    void publishFoldersGettingEvent(FoldersGettingEvent event);
}
