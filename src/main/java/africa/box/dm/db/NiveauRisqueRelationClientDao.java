package africa.box.dm.db;

import africa.box.dm.db.entities.NiveauRisqueRelationClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRisqueRelationClientDao extends JpaRepository<NiveauRisqueRelationClient, Long> {
}
