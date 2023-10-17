package africa.box.dm.db;

import africa.box.dm.db.entities.ResidenceDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceDeclarationDao extends JpaRepository<ResidenceDeclaration, Long> {
}
