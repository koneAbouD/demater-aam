package africa.box.dm.db;

import africa.box.dm.db.entities.Actionnaire;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionnaireDao extends CrudRepository<Actionnaire,Integer> {
    public List<Actionnaire> findByBusinessKey(String bk);
}