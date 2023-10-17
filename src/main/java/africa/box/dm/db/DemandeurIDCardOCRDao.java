package africa.box.dm.db;

import africa.box.dm.db.entities.DemandeurIDCardOCR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemandeurIDCardOCRDao extends CrudRepository<DemandeurIDCardOCR, Long> {
    Optional<DemandeurIDCardOCR> findOneByScanRef(String scanRef);
    Optional<DemandeurIDCardOCR> findFirstByBusinessKey(String bussinessKey);
}
