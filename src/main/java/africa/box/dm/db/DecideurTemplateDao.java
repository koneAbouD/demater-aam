package africa.box.dm.db;

import africa.box.dm.db.entities.DecideurTemplate;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecideurTemplateDao extends CrudRepository<DecideurTemplate,Integer> {
    @OrderBy(clause = "id desc")
    public List<DecideurTemplate> findAll();

    @OrderBy(clause = "priorite desc")
    public List<DecideurTemplate> findByTypeLevel(String typeLevel);

    @OrderBy(clause = "id desc")
    public List<DecideurTemplate> findByTypeLevelAndAgence(String typeLevel,String agence);
}