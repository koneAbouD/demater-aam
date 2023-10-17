package africa.box.dm.service;
import africa.box.dm.db.CriminelAndPepsDao;
import africa.box.dm.db.entities.CriminelAndPeps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CriminelAndPepsService {


    @Autowired
    CriminelAndPepsDao criminelAndPepsDao ;


    public List<CriminelAndPeps> getAllCriminel(){
        return criminelAndPepsDao.findAll();
    }

    public CriminelAndPeps saveCrimAndPepsInformation(CriminelAndPeps c){
        return criminelAndPepsDao.save(c);
    }

//    public Optional<CriminelAndPeps> getCriminel(String a, String b){
//        return criminelAndPepsDao.findByNom_crim_pepsAndPrenom_crim_peps(a,b);
//    }
}
