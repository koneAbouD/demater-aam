package africa.box.dm.service;

import africa.box.dm.db.*;
import africa.box.dm.db.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ParametrageService {
    @Autowired
    private GestionnaireDao gestionnaireDao;
    @Autowired
    private CapaciteJuridiqueDao capaciteJuridiqueDao;
    @Autowired
    private CategorieProfessionnelleDao categorieProfessionnelleDao;
    @Autowired
    private LienApparenteBanqueDao lienApparenteBanqueDao;
    @Autowired
    private NiveauRisqueRelationClientDao niveauRisqueRelationClientDao;
    @Autowired
    private PartenaireDeMariageDao partenaireDeMariageDao;
    @Autowired
    private ResidenceDeclarationDao residenceDeclarationDao;
    @Autowired
    private TerritorialiteDao territorialiteDao;
    @Autowired
    private ProfilDao profilDao;

    public List<Gestionnaire> listGestionnaire() {
        return gestionnaireDao.findAll();
    }
    public List<CapaciteJuridique> listCapaciteJuridique() {
        return capaciteJuridiqueDao.findAll();
    }
    public List<CategorieProfessionnelle> listCategorieProfessionnelle() {
        return categorieProfessionnelleDao.findAll();
    }
    public List<LienApparenteBanque> listLienApparenteBanque() {
        return lienApparenteBanqueDao.findAll();
    }
    public List<NiveauRisqueRelationClient> listNiveauRisqueRelationClient() {
        return niveauRisqueRelationClientDao.findAll();
    }
    public List<PartenaireDeMariage> listPartenaireDeMariage() {
        return partenaireDeMariageDao.findAll();
    }
    public List<ResidenceDeclaration> listResidenceDeclaration() {
        return residenceDeclarationDao.findAll();
    }
    public List<Territorialite> listTerritorialite() {
        return territorialiteDao.findAll();
    }
    public List<Profil> listProfil() {
        return profilDao.findAll();
    }

}
