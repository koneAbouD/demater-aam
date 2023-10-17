package africa.box.dm.db;

import africa.box.dm.db.entities.LienApparenteBanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LienApparenteBanqueDao extends JpaRepository<LienApparenteBanque, Long> {
}
