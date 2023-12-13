package com.demater.rest.folder;

import com.demater.core.domain.folder.Folder;
import com.demater.core.usecase.folder.GetAllFoldersUseCase;
import com.demater.rest.folder.out.FolderOut;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {
        @Tag(name = "Folder", description = "")
})
@RestController
@RequestMapping("Folders")
@RequiredArgsConstructor
public class FolderController {
    private final GetAllFoldersUseCase getAllFolders;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting all folders")
    public ResponseEntity<List<FolderOut>> getFolders() {
        List<Folder> folders = getAllFolders.execute();
        List<FolderOut> results = folders.stream()
                .map(r -> objectMapper.convertValue(r, FolderOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
