package africa.box.dm.controllers;

import africa.box.dm.db.CompteDao;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.DmStatus;
import africa.box.dm.db.entities.NoteTypes;
import africa.box.dm.db.entities.Notes;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.ExternalEndPointService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/externalendpoint")
@CrossOrigin(value = "*", origins = "*")
public class ExternalEndPointController {

    @Autowired
    ExternalEndPointService externalEndPointService;

    @Autowired
    CompteService compteService;

    @GetMapping("/synchroniser")
    @ResponseBody
    public StatusDto synchronisationWithOnBoarding() {
        try{
            System.out.println("+++++++++++++++ START TASK ++++++++++++++++");
            JSONObject params = new JSONObject();
            params.put("date",null);
            String response = externalEndPointService.saveExternalCompteInitiate(params, false);
            System.out.println("+++++++++++++++ END TASK ++++++++++++++++" +response);
            String msg = Integer.parseInt(response)>1? response+" commptes créés.":response+" compte créé.";
            return StatusDto.ofSuccess("Synchronisation éffectuée avec succès, "+msg);
        }catch (Exception e){
            e.printStackTrace();
            return StatusDto.ofEchec("Synchronisation échouée");
        }
    }

    @PostMapping("/documentrecu")
    @ResponseBody
    public StatusDto updateOnboardingCompteState(@RequestBody Compte compte) {
        try{
            Optional<Compte> c = compteService.getCompte(compte.getBusinessKey());
            if (c.isPresent()){
                System.out.println(c.get());
                if (c.get().getStatus().equals(DmStatus.NOUVEAU)){
                    JSONObject p  = new JSONObject();
                    p.put("state", DmStatus.EN_TRAITEMENT);
                    p.put("businesskey",compte.getBusinessKey());
                    String rslt = externalEndPointService.updateCompteState(p);
                    System.out.println(" updateCompteState ======> "+rslt);
//                    if (rslt.length()>0){
//
//                    }
                    Notes note = new Notes();
                    note.setNote("Documents pyshiques bien reçu.");
                    note.setBusinessKey(c.get().getBusinessKey());
                    note.setType(NoteTypes.INFORMATION);
                    note.setDate(new Date());
                    c.get().setStatus(DmStatus.EN_TRAITEMENT);
                    compteService.updateCompte(c.get(),note);
                    return StatusDto.ofSuccess("Synchronisation éffectuée avec succès.");
                }
            }
            return StatusDto.ofEchec("Ce compte ne provient pas du Onboarding.");
        }catch (Exception e){
            e.printStackTrace();
            return StatusDto.ofEchec("Synchronisation échouée");
        }
    }

}
