package africa.box.dm.db;

import africa.box.dm.db.entities.BusinessKeySeq;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessKeySeqDao extends CrudRepository<BusinessKeySeq, Integer> {
    List<BusinessKeySeq> findAll();
}