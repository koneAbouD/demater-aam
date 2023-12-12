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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "folder", description = "TotalEnergies gas station")})
@RestController
@RequestMapping("folder")
@RequiredArgsConstructor
public class
FolderController {
    private final GetAllFoldersUseCase getAllFolders;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Get all folders by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<List<FolderOut>> getStations() {
        List<Folder> folders = getAllFolders.execute();
        List<FolderOut> results = folders.stream()
                .map(s -> objectMapper.convertValue(s, FolderOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
