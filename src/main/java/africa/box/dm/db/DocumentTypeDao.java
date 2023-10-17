package africa.box.dm.db;

import africa.box.dm.db.entities.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeDao extends CrudRepository<DocumentType,Integer> {
    DocumentType findByDocCode(String docCode);
}
