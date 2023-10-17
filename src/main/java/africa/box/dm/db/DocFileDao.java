package africa.box.dm.db;

import africa.box.dm.db.domain.filestorage.DocFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocFileDao extends JpaRepository<DocFile, Long> {

    Optional<DocFile> findOneByDocIdAndBusinessKey(String docId, String BusinessKey);

    Optional<DocFile> findOneByDocIdAndFilename(String id, String filename);
}
