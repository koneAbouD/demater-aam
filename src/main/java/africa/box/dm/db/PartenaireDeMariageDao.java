package africa.box.dm.db;

import africa.box.dm.db.entities.PartenaireDeMariage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenaireDeMariageDao extends JpaRepository<PartenaireDeMariage, Long> {
}
