package africa.box.dm.controllers;

import africa.box.dm.db.entities.*;
import africa.box.dm.service.ParametrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parametrage")
@CrossOrigin(value = "*", origins = "*")
public class ParametrageController {
    @Autowired
    private ParametrageService parametrageService;

    @GetMapping("/gestionnaire/all")
    @ResponseBody
    public List<Gestionnaire> getGestionnaire(){
        return parametrageService.listGestionnaire();
    }
    @GetMapping("/niveauRisqueRelationClient/all")
    @ResponseBody
    public List<NiveauRisqueRelationClient> getNiveauRisqueRelationClient(){
        return parametrageService.listNiveauRisqueRelationClient();
    }
    @GetMapping("/capaciteJuridique/all")
    @ResponseBody
    public List<CapaciteJuridique> getCapaciteJuridique(){
        return parametrageService.listCapaciteJuridique();
    }
    @GetMapping("/categorieProfessionnelle/all")
    @ResponseBody
    public List<CategorieProfessionnelle> getCategorieProfessionnelle(){
        return parametrageService.listCategorieProfessionnelle();
    }
    @GetMapping("/lienApparenteBanque/all")
    @ResponseBody
    public List<LienApparenteBanque> getLienApparenteBanque(){
        return parametrageService.listLienApparenteBanque();
    }
    @GetMapping("/partenaireDeMariage/all")
    @ResponseBody
    public List<PartenaireDeMariage> getPartenaireDeMariage(){
        return parametrageService.listPartenaireDeMariage();
    }
    @GetMapping("/residenceDeclaration/all")
    @ResponseBody
    public List<ResidenceDeclaration> getResidenceDeclaration(){
        return parametrageService.listResidenceDeclaration();
    }
    @GetMapping("/territorialite/all")
    @ResponseBody
    public List<Territorialite> getTerritorialite(){
        return parametrageService.listTerritorialite();
    }
    @GetMapping("/profil/all")
    @ResponseBody
    public List<Profil> getProfil(){
        return parametrageService.listProfil();
    }
}
