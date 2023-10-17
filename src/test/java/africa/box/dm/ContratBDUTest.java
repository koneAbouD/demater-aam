package africa.box.dm;


import africa.box.dm.db.CompteDao;
import africa.box.dm.db.entities.ApplicantGood;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.IDCardType;
import africa.box.dm.db.entities.RegisteredID;
import africa.box.dm.service.CompteService;
import africa.box.dm.utils.ContratPdfBDU;
import africa.box.dm.utils.DateFormatter;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ContratBDUTest {

    private final static Logger LOG = LoggerFactory.getLogger(ContratBDUTest.class.getName());

    @Autowired
    private CompteService compteService;
    @Autowired
    private CompteDao compteDao;
    private Compte compte;

    @Before
    public void setup(){
        compte = compteService.getCompte("AA064").get();
    }

    @Test
    public void generateCarteDeSignature() {
        assertNotNull(compte);
        try {
            System.out.println(System.getProperty("java.io.tmpdir"));
            ContratPdfBDU.createCartonSignaturePdf(compte);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    //@Test
    public void shouldHasRegisteredIDWithCNIAuthority(){
        assertThat(compte.getRegisteredID()).isNull();

        LOG.info("Registered ID is null");
        RegisteredID registeredID = new RegisteredID();
        registeredID.setAuthority(IDCardType.CNI.name());
        registeredID.setNumber("CI0687656");
        registeredID.setValidFrom(DateFormatter.toDate(""));
        LOG.info("Correcte Valid From Date");
        registeredID.setValidTo(DateFormatter.toDate("12/08/2023"));
        LOG.info("Correcte Valid To Date");
        compte.setRegisteredID(registeredID);
        //compteDao.save(compte);
        assertThat(compte.getRegisteredID().getAuthority()).isEqualTo(IDCardType.CNI.name());
        assertThat(compte.getRegisteredID().getNumber()).isNotNull();
        assertThat(compte.getRegisteredID().getValidFrom()).isNotNull();

    }

    //@Test
    public void shouldHaveRegisteredNumber(){
        //assertThat(compte.getRegisteredID()).isNull();
        //compte = compteDao.save(compte);



    }

}
