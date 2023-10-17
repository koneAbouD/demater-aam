package africa.box.dm.db;


import africa.box.dm.db.entities.CategorieProfessionnelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieProfessionnelleDao extends JpaRepository<CategorieProfessionnelle, Long> {
}
