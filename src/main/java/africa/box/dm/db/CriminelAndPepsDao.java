package africa.box.dm.db;
import africa.box.dm.db.entities.CriminelAndPeps;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriminelAndPepsDao extends JpaRepository<CriminelAndPeps,String> {
//    public Optional<CriminelAndPeps> findByNom_crim_pepsAndPrenom_crim_peps(String nom_crim_peps, String prenom_crim_peps);
    public List<CriminelAndPeps> findAll();
}
