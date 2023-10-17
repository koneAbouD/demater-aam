package africa.box.dm.db;

import africa.box.dm.db.entities.Gestionnaire;
import africa.box.dm.db.entities.UrgenceContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrgenceContactDao extends JpaRepository<UrgenceContact, Long> {

}
