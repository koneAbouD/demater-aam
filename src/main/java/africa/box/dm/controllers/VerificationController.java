package africa.box.dm.controllers;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.NotesDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.LogInfoService;
import africa.box.dm.service.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/verification")
@CrossOrigin(value = "*", origins = "*")
public class VerificationController {

    @Autowired
    CompteService compteService;
    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    NotesDao notesDao;

    @Autowired
    LogInfoService logInfoService;

    @PostMapping("/cip/{businessKey}")
    @ResponseBody
    public StatusDto verificationCIP (@PathVariable(name = "businessKey")  String businessKey){
        try {
            Optional<Compte> compteOptional = compteService.getCompte(businessKey);
            if (compteOptional.isPresent()){
                boolean doc_cip_exist=false;
                List<CompteDocument> compteDocuments = compteDocumentDao.findByBusinessKey(businessKey);
                for (CompteDocument compteDocument:compteDocuments){
                    //System.out.println(compteDocument);
                    if (compteDocument.getName().equals(BusinessConstants.DOC_CIP))
                        doc_cip_exist=true;
                }
                if (doc_cip_exist){
                    return StatusDto.ofEchec("L'opération a échoué, le document exist déjà.");
                }else{
                    CompteDocument doc = new CompteDocument();
                    doc.setIdentifiant(String.valueOf(UUID.randomUUID()));
                    doc.setBusinessKey(businessKey);
                    doc.setNumberOfCopies(1);
                    doc.setCreatedAt(new Date());
                    doc.setStatut("confirmation");
                    doc.setDocumentstatus(DocumentStatus.MANQUANT);
                    doc.setFacultatif(false);
                    doc.setName(BusinessConstants.DOC_CIP);
                    doc.setDocCode(BusinessConstants.DOC_CODE_CONFIRMATION);
                    doc.setDescription(BusinessConstants.DOC_CODE_CONFIRMATION);
                    compteDocumentDao.save(doc);

                    return StatusDto.ofSuccess("Opération effectuée avec succès");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return StatusDto.ofEchec("L'opération a échoué");
    }

//    @PostMapping("/validate/cip/{bussinessKey}")
//    @ResponseBody
//    public StatusDto validateCIP (@PathVariable(name = "bussinessKey")  String businessKey){
//        try {
//            Optional<Compte> compteOptional = compteService.getCompte(businessKey);
//            if (compteOptional.isPresent()){
////                boolean doc_cip_exist=false;
//                List<CompteDocument> compteDocument_CIP = compteDocumentDao.findByBusinessKeyAndName(businessKey,BusinessConstants.DOC_CIP);
//                if(compteDocument_CIP!=null && !compteDocument_CIP.isEmpty()){
//                    CompteDocument cipDoc = compteDocument_CIP.get(0);
//                    System.out.println("statut de document cip ========="+cipDoc.getStatut());
//                    if (cipDoc.getDocumentstatus().equals((DocumentStatus.TRAITE))){
//                        return StatusDto.ofSuccess("Opération effectuée avec succès");
//                    }else{
//                        return StatusDto.ofEchec("L'opération a échoué car le document n'a pas été traité.");
//                    }
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return StatusDto.ofEchec("L'opération a échoué");
//    }

    @PostMapping("/validate/cip")
    @ResponseBody
    public StatusDto validateCIP(@RequestBody Notes note, @RequestParam("nomDocument") String nomDocument){
        try {
//            Optional<Compte> compteOptional = compteService.getCompte(businessKey);
            Optional<Compte> compteOptional=  compteService.getCompte(note.getBusinessKey());
            Compte c=compteOptional.get();

            if (compteOptional.isPresent() ){
//                boolean doc_cip_exist=false;
                List<CompteDocument> compteDocument_CIP = compteDocumentDao.findByBusinessKeyAndName(note.getBusinessKey(),nomDocument.trim());
                if(compteDocument_CIP != null && !compteDocument_CIP.isEmpty()){
                    CompteDocument cipDoc = compteDocument_CIP.get(0);

                    System.out.println("statut de document cip ========="+cipDoc.getDocumentstatus());
                    if (cipDoc.getDocumentstatus().equals((DocumentStatus.TRAITE))){
                        if(note.getType().equals((NoteTypes.INFORMATION))){
                            c.setCipVerifier(true);
                            if(nomDocument.trim().equalsIgnoreCase(BusinessConstants.DOC_CIP_CONJOINT)){
                                Conjoint conjoint = c.getConjoint();
                                conjoint.setCipVerifier(true);
                                c.setConjoint(conjoint);
                            }
                            compteService.saveCip(c);
                            notesDao.save(note);
                            // Ajout de log: Verification cip
                            logInfoService.addLog(
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.VALIDATION,
                                    c.getBusinessKey(),
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP);

                            if(nomDocument.trim().equalsIgnoreCase(BusinessConstants.DOC_CIP_CONJOINT)){
                                logInfoService.addLog(
                                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.VALIDATION_CONJOINT,
                                        c.getBusinessKey(),
                                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP_CONJOINT);
                            }
                            return StatusDto.ofSuccess("Vérification CIP validé avec succès");

                        }
                        if(note.getType().equals((NoteTypes.SIGNALER))){
                            notesDao.save(note);
                            c.setCipVerifier(true);
                            if(nomDocument.trim().equalsIgnoreCase(BusinessConstants.DOC_CIP_CONJOINT)){
                                Conjoint conjoint = c.getConjoint();
                                conjoint.setCipVerifier(true);
                                c.setConjoint(conjoint);
                            }
                            compteService.saveCip(c);
                            // Ajout de log: Verification cip
                            logInfoService.addLog(
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.SIGNALER_LA_VERIFICATION_CIP,
                                    c.getBusinessKey(),
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP);

                            if(nomDocument.trim().equalsIgnoreCase(BusinessConstants.DOC_CIP_CONJOINT)){
                                logInfoService.addLog(
                                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.SIGNALER_LA_VERIFICATION_CIP_CONJOINT,
                                        c.getBusinessKey(),
                                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP_CONJOINT);
                            }
                            return StatusDto.ofSuccess("Vérification CIP signalé avec succès");
                        }
                    }else  if (cipDoc.getDocumentstatus().equals((DocumentStatus.MANQUANT)) || cipDoc.getStatut().equals((DocumentStatus.EN_TRAITEMENT))){
                        if(note.getType().equals((NoteTypes.SIGNALER))){
                            notesDao.save(note);
                            c.setCipVerifier(true);
                            if(nomDocument.trim().equalsIgnoreCase(BusinessConstants.DOC_CIP_CONJOINT)){
                               Conjoint conjoint = c.getConjoint();
                               conjoint.setCipVerifier(true);
                               c.setConjoint(conjoint);
                            }
                            compteService.saveCip(c);

                            return StatusDto.ofSuccess("Vérification signalé avec succès");
                        }

                        return StatusDto.ofEchec("L'opération a échoué car le document n'a pas été traité");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return StatusDto.ofEchec("L'opération a échoué");
    }

    @PostMapping("/invalidate/cip")
    @ResponseBody
    public StatusDto invalidateCIP (@RequestBody Notes note){
        try {
//            Optional<Compte> compteOptional = compteService.getCompte(businessKey);
            Optional<Compte> compteOptional=  compteService.getCompte(note.getBusinessKey());

            if (compteOptional.isPresent()){
//                boolean doc_cip_exist=false;
                List<CompteDocument> compteDocument_CIP = compteDocumentDao.findByBusinessKeyAndName(note.getBusinessKey(),BusinessConstants.DOC_CIP);
                if(compteDocument_CIP==null || compteDocument_CIP.isEmpty()){
                    CompteDocument cipDoc = compteDocument_CIP.get(0);
                    if (cipDoc.getDocumentstatus().equals((DocumentStatus.MANQUANT)) || cipDoc.getStatut().equals((DocumentStatus.EN_TRAITEMENT))){
                        if(note!=null) {
                            return StatusDto.ofSuccess("CIP invalidée avec succès");
                        }else { return StatusDto.ofEchec("Le commentaire ne doit pas être nul");}
                    }else{
                        return StatusDto.ofEchec("L'opération a échoué car le document a été traité.");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return StatusDto.ofEchec("L'opération a échoué");
    }

    @PostMapping(path = "/cip/update/{businessKey}")
    @ResponseBody
    public Compte updateCip(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        Notes note=new Notes();


        Compte cmpt = compteService.saveCip(d);

        note.setBusinessKey(d.getBusinessKey());
        note.setType(NoteTypes.INFORMATION);
        note.setNote("Vérification CIP modifié avec succès");
        notesDao.save(note);

        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.MODIFICATION_VERIFICATION_CIP,
                d.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP);

        return cmpt;
    }

}
