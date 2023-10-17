package africa.box.dm.db;

import africa.box.dm.db.entities.CapaciteJuridique;
import africa.box.dm.db.entities.Territorialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritorialiteDao extends JpaRepository<Territorialite, Long> {
}
