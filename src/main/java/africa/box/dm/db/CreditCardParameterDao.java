package africa.box.dm.db;

import africa.box.dm.db.entities.CreditCardParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardParameterDao extends JpaRepository<CreditCardParameter, Long> {

    Optional<CreditCardParameter> findOneByName(String name);
}
