package africa.box.dm.db;

import africa.box.dm.db.entities.LevelDecision;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelDecisionDao extends CrudRepository<LevelDecision,Integer> {
    @OrderBy(clause = "id asc")
    public List<LevelDecision> findByBusinessKey(String bk);

    @Query(value = "SELECT coalesce ((SELECT level\n" +
            " FROM public.level_decision\n" +
            " where level = (Select max(level) from public.level_decision)\n" +
            " and businesskey =?1),0) +1",nativeQuery = true)
    public Integer findMaxLevel(String businesskey);
}