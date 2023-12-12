package com.demater.core.usecase.folder;

import com.demater.core.domain.folder.Folder;
import com.demater.core.domain.user.Role;
import com.demater.core.event.folder.FoldersGettingEvent;
import com.demater.core.event.user.RolesGettingEvent;
import com.demater.core.port.FolderRepository;
import com.demater.core.port.RoleRepository;
import com.demater.core.publisher.FolderEventPublisher;
import com.demater.core.publisher.RoleEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllFoldersUseCase {
    private final FolderRepository folderRepository;
    private final FolderEventPublisher folderEventPublisher;

    public List<Folder> execute() {
        List<Folder> folders = folderRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(r -> r.getBusinessKey()))
            .toList();
        folderEventPublisher.publishFoldersGettingEvent(new FoldersGettingEvent());
        return folders;
    }
}
