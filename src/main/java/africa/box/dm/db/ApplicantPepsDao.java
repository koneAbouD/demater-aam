package africa.box.dm.db;

import africa.box.dm.db.entities.ApplicantPeps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantPepsDao extends CrudRepository<ApplicantPeps, Long> {
    Optional<ApplicantPeps> findOneByBusinessKey(String businessKey);
    Optional<ApplicantPeps> findFirstByBusinessKey(String businessKey);
}
