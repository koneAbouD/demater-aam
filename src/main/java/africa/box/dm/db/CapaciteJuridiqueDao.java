package africa.box.dm.db;

import africa.box.dm.db.entities.CapaciteJuridique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaciteJuridiqueDao extends JpaRepository<CapaciteJuridique, Long> {
}
