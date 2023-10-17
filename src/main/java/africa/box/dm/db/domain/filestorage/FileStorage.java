package africa.box.dm.db.domain.filestorage;

import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.dto.DocumentDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface FileStorage {
    void save(String businessKey, MultipartFile file, String filename, String docId, DocumentDto documentDto);
    Optional<Resource> get(String businessKey, String docId);
    void delete(String businessKey, CompteDocument doc);
}
