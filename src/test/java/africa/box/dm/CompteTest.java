package africa.box.dm;

import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.Mineur;
import africa.box.dm.service.CompteService;
import africa.box.dm.utils.DateFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompteTest {


    private Compte compte;
    @Autowired
    private CompteService compteService;

    @Before
    public void setup() {
        compte = compteService.getCompte("AA062").get();
    }

    @Test
    public void compteShouldBeForMinor(){
        assertThat(compte.getMinor()).isNull();
        Mineur mineur = new Mineur();
        mineur.setNom("Kouakou");
        mineur.setPrenom("Yao");
        mineur.setGenre("Homme");
        mineur.setDateNaissance(DateFormatter.toDate("12/12/2005"));
        mineur.setLieuNaissance("Agboville");

        compte.setMinor(mineur);

        assertThat(compte.getMinor()).isNotNull();

    }

}
