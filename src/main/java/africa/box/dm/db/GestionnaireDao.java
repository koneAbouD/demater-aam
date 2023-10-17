package africa.box.dm.db;

import africa.box.dm.db.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionnaireDao extends JpaRepository<Gestionnaire, Long> {

}
