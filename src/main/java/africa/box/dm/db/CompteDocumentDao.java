package africa.box.dm.db;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DocumentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteDocumentDao extends CrudRepository<CompteDocument,String> {
    public List<CompteDocument> findAll();
    public List<CompteDocument> findByBusinessKey(String businessKey);
    public List<CompteDocument>  findByBusinessKeyAndDocCode(String businessKey, String docCode);
    public List<CompteDocument>  findByBusinessKeyAndName(String businessKey, String name);

    List<CompteDocument> findByName(String name);
    public List<CompteDocument>  findByBusinessKeyAndFromClient(String businessKey, Boolean fromClient);

    Optional<CompteDocument> findFirstByBusinessKeyAndName(String businessKey, String name);

    @Query("select d from CompteDocument d where d.businessKey = :businessKey and " +
            "(:status is null or d.documentstatus = :status)")
    List<CompteDocument> findByBusinessKeyAndDocumentStatus(
            @Param("businessKey") String businessKey,
            @Param("status") DocumentStatus status);
}
