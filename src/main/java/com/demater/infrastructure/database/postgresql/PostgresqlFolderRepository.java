package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.folder.Folder;
import com.demater.core.port.FolderRepository;
import com.demater.infrastructure.database.repository.JpaFolderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostgresqlFolderRepository implements FolderRepository {
    private final JpaFolderRepository folderRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<Folder> findAll() {
        return folderRepository.findAll()
                .stream()
                .map(r -> objectMapper.convertValue(r, Folder.class))
                .toList();
    }

    @Override
    public Folder save(Folder folder) {
        return null;
    }
}
