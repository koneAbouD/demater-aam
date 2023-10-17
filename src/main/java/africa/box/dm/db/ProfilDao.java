package africa.box.dm.db;

import africa.box.dm.db.entities.Profil;
import africa.box.dm.db.entities.ResidenceDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilDao extends JpaRepository<Profil, Long> {
}
