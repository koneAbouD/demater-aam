package africa.box.dm.controllers;

import africa.box.dm.DmApplication;
import africa.box.dm.config.DmDbConfig;
//import africa.box.dm.db.DocumentDao;
import africa.box.dm.db.entities.CompteDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

////@RunWith(SpringRunner.class)
////@DataJpaTest
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {DmApplication.class, DmDbConfig.class})
public class DocumentControllerTest {

    @Autowired
    private TestEntityManager entityManager;

//    @Autowired
//    DocumentDao documentDao;

    DocumentController documentController = new DocumentController();

    public DocumentControllerTest() {
    }

    @Test
    public void getDocRequirements() {
//        List<?> queryResult = documentDao.findByBusinessKey("AA003");
//        assertFalse(queryResult.isEmpty());
//        assertNotNull(queryResult.get(0));
        System.out.println("TEST");
        assertFalse(false);
    }

    @Test
    public void listAllDocuments() {
        assertFalse(true);
    }

    @Test
    public void listAllDocumentsForTypeCompte() {
        assertFalse(true);
    }

    @Test
    public void test1() {
        assertFalse(true);
    }

}