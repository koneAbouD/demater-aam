package africa.box.dm.db;

import africa.box.dm.db.entities.DecideurOfLevel;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecideurOfLevelDao extends CrudRepository<DecideurOfLevel,Integer> {
    @OrderBy(clause = "date desc")
    public List<DecideurOfLevel> findByIdlevel(Integer idlevel);

    @OrderBy(clause = "date desc")
    public List<DecideurOfLevel> findByBusinessKeyAndRoleAndIdlevel(String businessKey,String role,int idLevel);

    public List<DecideurOfLevel> findByBusinessKeyAndDecideur(String bk, String decideur);

}