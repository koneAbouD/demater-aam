package africa.box.dm;

import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.DmStatus;
import africa.box.dm.db.entities.Notes;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.DmDecisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.assertj.core.api.Assertions;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubmitDossierTest {

    private final static Logger Log = LoggerFactory.getLogger(SubmitDossierTest.class.getName());

    private Optional<Compte> mayBe;
    private Notes note;
    private final static String businessKey = "AA057";

    @Autowired
    private CompteService compteService;

    @Autowired
    private DmDecisionService decisionService;



    public void soumttre() {

        assertTrue(mayBe.isPresent());

    }
}
