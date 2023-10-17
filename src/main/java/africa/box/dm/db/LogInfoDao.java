package africa.box.dm.db;

import africa.box.dm.db.entities.LogInfo;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogInfoDao extends CrudRepository<LogInfo,Integer> {
    @OrderBy(clause = "date desc")
    List<LogInfo> findByTypeAndDestinatairemail(String type, String destinatairemail);
    @OrderBy(clause = "date desc")
    List<LogInfo> findByTypeAndIddossier(String type, String idDossier);
    @OrderBy(clause = "date desc")
    List<LogInfo> findByTypeAndIddossierAndText(String type, String idDossier,String step);
}
