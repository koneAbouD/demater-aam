package com.demater.core.port;

import com.demater.core.domain.folder.Folder;

import java.util.List;

public interface FolderRepository {
    List<Folder> findAll();
    Folder save(Folder folder);
}
