package africa.box.dm;

import africa.box.dm.db.CreditCardParameterDao;
import africa.box.dm.db.entities.CreditCardParameter;
import africa.box.dm.service.SystemParameterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
public class SystemParameterTest {

    @Autowired
    SystemParameterService parameterService;

    @Autowired
    CreditCardParameterDao creditCardParameterDao;

//    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("dmPu");
//    final EntityManager entityManager = factory.createEntityManager();

    void setup() {

    }

    //@Before
    public void cleanDatabase() {
        creditCardParameterDao.deleteAll();
    }

    //@Test
    public void creditcardShouldNotHaveSameName() {
        CreditCardParameter cc1 =
                CreditCardBuilber.anCreditCard()
                .withName("VISA CLASSIC")
                .withAmount(BigInteger.valueOf(1000))
                .withFeatures(new String[]{"Feature 1", "Feature 2"})
                .build();

        parameterService.addCreditCard(cc1);

        CreditCardParameter cc2 =
                CreditCardBuilber.anCreditCard()
                        .withName("VISA GOLD")
                        .withAmount(BigInteger.valueOf(1100))
                        .withFeatures(new String[]{"Feature 1", "Feature 2"})
                        .build();

        Long cc2Id = parameterService.addCreditCard(cc2);

        assertThat(parameterService.findAll()).size().isEqualTo(2);

        assertThat(cc2Id).isNotNull();
        cc2.setId(cc2Id);
        cc2.setName("VISA TEST");
        parameterService.update(cc2);

        parameterService.delete(cc2Id);

        assertThat(parameterService.findAll()).size().isEqualTo(1);
        System.out.println(cc1.getFeatures());
    }

    //@Test
    public void shouldHaveInsurance() {
        CreditCardParameter cc1 =
                CreditCardBuilber.anCreditCard()
                        .withName("VISA CLASSIC")
                        .withAmount(BigInteger.valueOf(1000))
                        .withFeatures(new String[]{"Feature 1", "Feature 2"})
                        .withInsurances(
                                CCInsuranceBuilder.anCCInsaurance()
                                .withName("OPTION 1")
                                .withFeatures(new String[]{"Insurance Feature 1", "Insurance feature 2"})
                                .build()
                        )
                        .withInsurances(
                                CCInsuranceBuilder.anCCInsaurance()
                                        .withName("OPTION 2")
                                        .withFeatures(new String[]{"Insurance Feature 1", "Insurance feature 2"})
                                        .build()
                        )
                        .build();
        Long cc1Id = parameterService.addCreditCard(cc1);
        cc1.setId(cc1Id);
        List<CreditCardParameter.CreditCardInsurance> ccInsurances = parameterService.findAll()
                .get(0)
                .getPossibleInsurance();
        assertThat(ccInsurances.size()).isEqualTo(2);

        System.out.println(ccInsurances.get(0).getName());

    }

}
