package com.demater.rest.folder.in;

import java.util.UUID;

public record FolderIn(
        UUID id,
        String businessKey,
        String designation,
        boolean isDeleted
) {
}
