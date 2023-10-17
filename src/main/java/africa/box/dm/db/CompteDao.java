package africa.box.dm.db;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompteDao extends JpaRepository<Compte,String> {

    public Optional<Compte> findByBusinessKey(String businessKey);
    public List<Compte> findAll();

    List<Compte> findByAgence(String agence);
    @Query("select c from Compte c where c.customercode = :customerCode")
    Optional<Compte> findCompteWithCustomerCode(@Param("customerCode") String customerCode);
}
