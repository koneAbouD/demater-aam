package com.demater.rest.folder.out;

import java.util.UUID;

public record FolderOut(
        UUID id,
        String businessKey,
        String designation,
        boolean isDeleted) {
}
