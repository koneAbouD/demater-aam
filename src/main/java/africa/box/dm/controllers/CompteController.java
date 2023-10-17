package africa.box.dm.controllers;

import africa.box.dm.config.DecisionConfig;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.config.RolesConfig;
import africa.box.dm.controllers.exceptions.CompteNotException;
import africa.box.dm.db.*;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.*;
import africa.box.dm.service.*;
import africa.box.dm.service.ocerisation.NanonetsService;
import africa.box.dm.service.ocerisation.RegulaService;
//import africa.box.dm.service.sumsub.AppTokenJavaService;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Controller
@RequestMapping("/compte")
@CrossOrigin(value = "*", origins = "*")
public class CompteController {
    @Autowired(required=true)
    CompteService compteService;

    @Autowired(required=true)
    ExternalEndPointService externalEndPointService;

//    @Autowired(required=true)
//    SumsubService sumsubService;
//
//    @Autowired
//    AppTokenJavaService appTokenJavaService;

    @Autowired
    ActionnaireDao actionnaireDao;

    @Autowired
    DmDecisionService decisionServices;

    @Autowired
    DecideurOfLevelDao decideurOfLevelDao;

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    CompteDao compteDao;

    @Autowired
    ContratDocService contratDocService;


    @Autowired
    CustomKeycloakService customKeycloakService;

    @Autowired
    PdfDocService pdfDocService;

    @Autowired
    NanonetsService nanonetsService;

    @Autowired
    RegulaService regulaService;

    @Autowired
    NotesDao notesDao;

    @Autowired
    private CompteDocumentDao compteDocumentDao;

    @Autowired
    private DemandeurIDCardOCRDao idCardOCRDao;

    @Autowired
    private StorageService storageService;

//    @Autowired
//    PdfContratTemplate pdfcontratTemplate;

    private String[] creditCardType = {"VISA GOLD", "VISA CLASSIC", "CARTE GIM UEMOA"};


    @PostMapping(path = "/informations_compte")
    @ResponseBody
    public Compte informationsCompte(@RequestBody Compte d) throws Exception {

        Compte cmpt = compteService.saveInformationCompte(d);

        // Ajout de log si inexistant: initialisation du dossier
        List<LogInfo> logInfo = logInfoService.getLogOfDossierByStep(
                d.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);
        if (logInfo.isEmpty()){
            logInfoService.addLog(LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER,
                    cmpt.getBusinessKey(),
                    null);
        }

        return cmpt;
    }



    @PostMapping(path = "/informations_client/{businessKey}")
    @ResponseBody
    public Compte informationsClient(@PathVariable("businessKey") String businessKey,@RequestBody Compte d){

        List<Actionnaire> actionnaireList = new ArrayList<>();
        try{
            actionnaireList = d.getListAutreActionnaire();
            List<Actionnaire> oldactionnaireList = actionnaireDao.findByBusinessKey(d.getBusinessKey());
            actionnaireDao.deleteAll(oldactionnaireList);

            if (actionnaireList != null && !actionnaireList.isEmpty()){
                actionnaireList.forEach(actionnaire -> {
                    actionnaire.setBusinessKey(d.getBusinessKey());

                });
                actionnaireDao.saveAll(actionnaireList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        Compte cmpt = compteService.saveInformationClient(d);

        logInfoService.addLog(
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INFORMATION_DEMANDEUR,
                cmpt.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);

        return cmpt;
    }
    @PostMapping(path = "/verification_peps/{businessKey}")
    @ResponseBody
    public Compte verificationPeps(@PathVariable("businessKey") String businessKey, @RequestBody Compte d)  {

        Compte cmpt = compteService.saveInformationListPeps(d);

        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.INITIALISATION_PEPs_CRIMINELLE,
                cmpt.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE);
        return cmpt;
    }
    @PostMapping(path = "/informations_coordonnees_client/{businessKey}")
    @ResponseBody
    public Compte informationsCoordonneesClient(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        Compte cmpt = compteService.saveCoordonneesClient(d);
        logInfoService.addLog(
                LogInfoConstante.INITIALISATION_DU_DOSSIER.COORDONNEES_DEMANDEUR,
                cmpt.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);

        return cmpt;
    }
    @PostMapping(path = "/informations_revenus_employeur/{businessKey}")
    @ResponseBody
    public Compte informationsRevenusEmployeur(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        Compte cmpt = compteService.saveRevenusEmployeur(d);
        logInfoService.addLog(
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INFORMATION_REVENUS_ET_EMPLOYEUR,
                cmpt.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);

        return cmpt;
    }
    @PostMapping(path = "/informations_complementaire/{businessKey}")
    @ResponseBody
    public Compte informationsComplementaire(@PathVariable("businessKey") String businessKey, @RequestBody Compte d) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        Compte cmpt = compteService.saveInformationComplementaire(d);
        logInfoService.addLog(
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INFORMATION_COMPLEMENTAIRE,
                cmpt.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);

        return cmpt;
    }
    @Transactional
    @PostMapping(path = "/validate/{businessKey}")
    @ResponseBody
    public Compte validate(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){

        Optional<Compte> mayBe = compteService.getCompte(businessKey);
        if (!mayBe.isPresent())
            throw new CompteNotException();
        // creation des différents pdf
        Compte compte = mayBe.get();
        //System.out.println("compte__________bb"+compte);
        //Version : 1.0.4
        compteService.createContratsFor(compte);

         compteService.sauvegardeListeDesdocuments(d);

        logInfoService.addLog(
                LogInfoConstante.INITIALISATION_DU_DOSSIER.VALIDER_POUR_TRAITEMENT,
                compte.getBusinessKey(),
                LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);
        // - Traitement des Dossiers
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER,
                compte.getBusinessKey(),null);

        // Traitement des Dossiers ===> Chargement des documents
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.ETAPE_CHARGER_LES_DOCUMENTS,
                compte.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

        // Traitement des Dossiers ===> Enregistrement des données
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_ENREGISTREMENT_DES_DONNEES.ETAPE_ENREGISTREMENT_DES_DONNEES,
                compte.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

        // Traitement des Dossiers ===> Vérification CIP
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP,
                compte.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

        // Traitement des Dossiers ===> Vérification PEPS et criminelle
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE,
                compte.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

        if (compte.getIsConjoint().equals(true)){
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP_CONJOINT,
                    compte.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

            // Traitement des Dossiers ===> Vérification PEPS et criminelle
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE_CONJOINT,
                    compte.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);
        }

        // Traitement des Dossiers ===> Vérification signature
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE,
                compte.getBusinessKey(),
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

        //  - Approbation
        logInfoService.addLog(
                LogInfoConstante.APPROBATION_DU_DOSSIER.APPROBATION_DU_DOSSIER,
                compte.getBusinessKey(),null);

        return compte;
    }

    @PostMapping(path = "/update/{businessKey}")
    @ResponseBody
    public Compte update(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        Notes note=new Notes();

        Optional<Compte> opionalCompte = compteService.getCompte(d.getBusinessKey());

        if (!opionalCompte.isPresent())
            throw new CompteNotException();

        compteService.updateImformationPepsCompte(d);

        if (d.getListPepsEtCrimVerifier() == true) {
            note.setBusinessKey(d.getBusinessKey());
            note.setType(NoteTypes.INFORMATION);
            note.setNote("Vérification PEPs et criminelle validé avec succès");
            notesDao.save(note);

            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.VALIDATION,
                    d.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE);

        } else {
            note.setBusinessKey(d.getBusinessKey());
            note.setType(NoteTypes.INFORMATION);
            note.setNote("Vérification PEPs et criminelle modifié avec succès");
            notesDao.save(note);

            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.MODIFICATION_PEPs_CRIMINELLE,
                    d.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE);

        }

        return d;
    }
    @PostMapping(path = "/updateConjoint/{businessKey}")
    @ResponseBody
    public Compte updateConjoint(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        Notes note=new Notes();

        Optional<Compte> opionalCompte = compteService.getCompte(d.getBusinessKey());

        if (!opionalCompte.isPresent())
            throw new CompteNotException();

        compteService.updateImformationPepsCompte(d);
        Conjoint conjoint = new Conjoint();
        conjoint = d.getConjoint();
        if (conjoint.getListPepsEtCrimVerifier() == true) {
            note.setBusinessKey(d.getBusinessKey());
            note.setType(NoteTypes.INFORMATION);
            note.setNote("Vérification PEPs et criminelle du conjoint validé avec succès");
            notesDao.save(note);

            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.VALIDATION_CONJOINT,
                    d.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE_CONJOINT);

        } else {
            note.setBusinessKey(d.getBusinessKey());
            note.setType(NoteTypes.INFORMATION);
            note.setNote("Vérification PEPs et criminelle du conjoint modifié avec succès");
            notesDao.save(note);

            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.MODIFICATION_PEPs_CRIMINELLE_CONJOINT,
                    d.getBusinessKey(),
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_PEPs_CRIMINELLE.ETAPE_VERIFICATION_PEPs_CRIMINELLE_CONJOINT);

        }

        return d;
    }

//    @PostMapping(path = "/cip/update/{businessKey}")
//    @ResponseBody
//    public Compte updateCip(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
//        Notes note=new Notes();
//
//
//        Compte cmpt = compteService.saveCip(d);
//
//        note.setBusinessKey(d.getBusinessKey());
//        note.setType(NoteTypes.INFORMATION);
//        note.setNote("Vérification CIP modifié avec succès");
//        notesDao.save(note);
//
//        logInfoService.addLog(
//                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.MODIFICATION_VERIFICATION_CIP,
//                d.getBusinessKey(),
//                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP);
//
//
//        return cmpt;
//    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Compte> test(){
        //return compteService.getAll();
        User connectedUser = UserService.getUser();

        if (connectedUser.getRoles().contains(RolesConfig.Role_chef_reseau)){
            return compteService.getAll();
        }
        return compteService.getByAgence(UserService.getConnectedUser().getAgence());
    }

    @GetMapping(path = "/{businessKey}")
    @ResponseBody
    public Compte getCompte(@PathVariable("businessKey") String businessKey){
        Optional<Compte> dossier = compteService.getCompte(businessKey);
        if (dossier.isPresent()){
            Compte compte = dossier.get();
            compte.setListAutreActionnaire(actionnaireDao.findByBusinessKey(compte.getBusinessKey()));
            return compte;
        }
        return null;
    }

    @PostMapping("/soumettre")
    @ResponseBody
    public StatusDto soumettre(@RequestBody Notes note){
        Optional<Compte> compte=  compteService.getCompte(note.getBusinessKey());
        Compte c = null;
        if(compte.isPresent()) {
            c=compte.get();

            if (!c.getStatus().equals(DmStatus.SOUMIS)) {

                decisionServices.createLevelByActionAndCondition(c.getBusinessKey(),
                        DecisionConfig.action_soumettre,null);
                c.setStatus(DmStatus.SOUMIS);
                c= compteService.updateCompte(c,note);

                if ( c.getFromOnboarding() != null && c.getFromOnboarding()){

                    JSONObject params = new JSONObject();
                    params.put("state",DmStatus.SOUMIS);
                    params.put("businesskey",c.getBusinessKey());

                    externalEndPointService.updateCompteState(params);

                }
            }else{
                throw new MyAppException("Le compte est déjà soumis");
            }
        } else{
            throw new MyAppException("Le Compte n'existe pas");
        }
        // creation des différents pdf

//                try {
//                    pdfDocService.createComptePDF(c.getBusinessKey());
//                    pdfDocService.createVoloPDF(c.getBusinessKey());
//                } catch (Exception e){
//                    e.printStackTrace();
//                }

        logInfoService.addLog(
                LogInfoConstante.APPROBATION_DU_DOSSIER.SOUMISSION,
                c.getBusinessKey(),
                LogInfoConstante.APPROBATION_DU_DOSSIER.APPROBATION_DU_DOSSIER);
        return StatusDto.ofSuccess("Mise à jour bien effectué");
    }

    @PostMapping("/approbation")
    @ResponseBody
    public StatusDto approbation(@RequestBody Notes note){
        Optional<Compte> compte=  compteService.getCompte(note.getBusinessKey());
        Compte c=null;
        DmStatus noteStatus = null;
        String textLog ="";
        if (note.getType().equals(NoteTypes.APPROUVE)) {
            note.setSla("END");
            noteStatus = DmStatus.APPROUVE;
            textLog ="Approuvé par le chef d'agence.";
        } else if (note.getType().equals(NoteTypes.COMPLEMENT)) {noteStatus = DmStatus.EN_TRAITEMENT;
            textLog ="Ramené en traitement par le chef d'agence.";
        } else if (note.getType().equals(NoteTypes.REFUSE)) { noteStatus = DmStatus.REFUSE;
            textLog ="Refusé par le chef d'agence.";
        }else return StatusDto.ofEchec("Statut de la note est incorrect (Doit être Approuvé ou A compléter ou Refusé");

        if(compte.isPresent()) {
            c=compte.get();
            if (c.getStatus().equals(DmStatus.SOUMIS)){
                try {
                    DmInitiationServices services = new DmInitiationServices();
                    User user = services.getUser();
                    List<DecideurOfLevel> decideurOfLevels = decideurOfLevelDao.findByBusinessKeyAndDecideur(note.getBusinessKey(), user.getFullName());

                    if(decideurOfLevels!=null && !decideurOfLevels.isEmpty()) {
                      DecideurOfLevel decideurOfLevel = Collections.max(decideurOfLevels, Comparator.comparing(d -> d.getId()));
                      decideurOfLevel.setDecision(note.getType());
                      decideurOfLevelDao.save(decideurOfLevel);
                    }

                    textLog ="Approuver par le chef d'agence.";

                }catch (Exception e){
                    e.printStackTrace();
                }
//                c.setStatus(DmStatus.APPROUVE);
                c.setStatus(noteStatus);
                c= compteService.updateCompte(c,note);
                if (c.getFromOnboarding() != null && c.getFromOnboarding()){
                    JSONObject params = new JSONObject();
//                  params.put("state",DmStatus.APPROUVE);
                    params.put("state",note.getType());
                    params.put("businesskey",c.getBusinessKey());

                    externalEndPointService.updateCompteState(params);
                }
                // Ajout de log: Décision du chef d'agence

                logInfoService.addLog(
                        textLog,
                        c.getBusinessKey(),
                        LogInfoConstante.APPROBATION_DU_DOSSIER.APPROBATION_DU_DOSSIER);
                return StatusDto.ofSuccess("Mise à jour bien effectué");
            }else {
                return StatusDto.ofEchec("Le compte doit être soumis avant d'être approuvé");
            }
        } else{
            throw new MyAppException("Le Compte n'existe pas");
        }

    }

    @GetMapping(path = "/update/status/{businessKey}/{status}")
    @ResponseBody
    public StatusDto updateStatus(@PathVariable("businessKey") String businessKey,@PathVariable("status") DmStatus status){
        Optional<Compte> compte=  compteService.getCompte(businessKey);
        if(compte.isPresent()) {
            try {
                Compte dmd=compte.get();
                dmd.setStatus(status);
//                mdm=compteDao.save(mdm);

                // +++++++++++++++++++ Sauvegarder une note ++++++++++++++++++++++++
                Notes notes = new Notes();
                notes.setBusinessKey(dmd.getBusinessKey());
                notes.setDate(new Date());
                notes.setType(NoteTypes.INFORMATION);
                notes.setNote("Mise à jour du statut du dossier ("+dmd.getStatus()+")");
                notes.setSla("INPROCESS");
//                notes=notesDao.save(notes);

                dmd= compteService.updateCompte(dmd,notes);
                // +++++++++++++++++++ END Sauvegarder une note ++++++++++++++++++++++++
                return StatusDto.ofSuccess("Modification avec success de l'état du compte");
            }catch(Exception e){
                e.printStackTrace();
                throw new MyAppException("Impossible de Mettre à jour le dossier");
            }

        } else{
            throw new MyAppException("Le compte n'existe pas");
        }

    }

    @PostMapping("/notes")
    public Notes ajouterNote(@RequestBody Notes note){
        NoteTypes type = note.getType();
        if(type != null && type.equals(NoteTypes.EFFACE) ){
            Optional<Compte> compte=  compteService.getCompte(note.getBusinessKey());
            if(compte.isPresent()) {
                try {
                    Compte c=compte.get();
                    c.setStatus(DmStatus.valueOf(type.name()));
                    c=compteDao.save(c);
                    return compteService.ajouterNote(note);
                }catch(Exception e){
                    e.printStackTrace();
                    throw new MyAppException("Impossible de Mettre à jour le dossier");
                }
            } else {

            }


        } else{
            throw new MyAppException("Le compte n'existe pas");
        }

        return null;
    }

    @PostMapping("/status")
    @ResponseBody
    public StatusDto editStatus(@RequestBody Notes note){
        Optional<Compte> compte=  compteService.getCompte(note.getBusinessKey());
        Compte c=null;
        if(compte.isPresent()) {
            c=compte.get();
            if (c.getStatus().equals(DmStatus.SOUMIS)){
                DmStatus noteStatus = null;
                if (note.getType().equals(NoteTypes.APPROUVE)) noteStatus = DmStatus.APPROUVE;
                else if (note.getType().equals(NoteTypes.COMPLEMENT)) noteStatus = DmStatus.EN_TRAITEMENT;
                else if (note.getType().equals(NoteTypes.REFUSE)) noteStatus = DmStatus.REFUSE;
                else noteStatus = DmStatus.valueOf(note.getType().name());
                c.setStatus(noteStatus);
                c = compteService.updateCompte(c,note);

                if (c.getFromOnboarding() != null && c.getFromOnboarding()){
                    JSONObject params = new JSONObject();
                    params.put("state",note.getType());
                    params.put("businesskey",c.getBusinessKey());

                    externalEndPointService.updateCompteState(params);
                }
                // Ajout de log: Mise à jour du statut du dossier
                logInfoService.addLog(
                        "Mise à jour du statut du dossier ("+c.getStatus()+")",
                        c.getBusinessKey(),
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

                return StatusDto.ofSuccess("Mise à jour bien effectué");

            }else {
                return StatusDto.ofEchec("Le compte doit être soumis avant de modifier le statut");
            }
        } else{
            throw new MyAppException("Le Compte n'existe pas");
        }

    }

    @GetMapping("/notes/{bussinessKey}/all")
    @ResponseBody
    public List<Notes> getNotesByBusinessKey(@PathVariable(name = "bussinessKey") String bussinessKey){
        return compteService.getNotesByBusinessKey(bussinessKey);
    }

//    @DeleteMapping("/notes/{id}")
//    public void deleteNote(@PathVariable(name = "id") Integer  id){
//        compteService.deleteNote(id);
//    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable(name = "id") Integer  id){
        compteService.deleteNote(id);
    }


    @GetMapping("/decision/{businessKey}")
    @ResponseBody
    public List<DecisionDto> getDecisions(@PathVariable("businessKey")String businessKey){
        System.out.println("/decision/{businessKey_______________________________");
        return decisionServices.getDecisionByBussinessKeyAndLevel(businessKey);
    }

    @PostMapping(path = "/memos/{businessKey}")
    @ResponseBody
    public Compte synthese(@PathVariable("businessKey") String businessKey, @RequestBody Compte d){
        // Ajout de log: Validation de la synthèse
        Compte cmpt = compteService.saveSyntheseInformation(d);
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.VALIDATION_DE_LA_SYNTHESE,
                businessKey,
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);
        return cmpt;
    }
    @PostMapping(path = "/ocerisation/{businessKey}/{identifiant}")
    @ResponseBody
    public StatusDto ocerisation(@PathVariable("businessKey") String businessKey,@PathVariable("identifiant") String identifiant,@RequestBody String pathName) throws UnirestException {

//              String res =  nanonetsService.oceriserDoc(pathName);
        String res =  regulaService.getCniOcrData(pathName,businessKey,identifiant);
        return StatusDto.ofSuccess("ocerisation bien effectué");
    }

//    @PostMapping(path = "/ocerisation/{businessKey}")
//    @ResponseBody
//    public String ocerisation(@PathVariable("businessKey") String businessKey,@RequestBody File pathName) throws UnirestException {
//
//        String res =  nanonetsService.oceriserDoc(pathName);
//        return res;
//    }

    @PostMapping( path= "/{businessKey}/change-signature")
    public ResponseEntity<Void> changeClientSignature(
            @PathVariable String businessKey, @RequestBody MultipartFile file) throws Exception{
        Compte compte = compteService.changeSignatureForCOmpteWithBusinessKey(businessKey,
                file.getBytes()).orElseThrow(()-> new CompteNotException());
        return ResponseEntity.status(204).body(null);
    }


    @GetMapping(path = "/{businessKey}/view-signature")
    public ResponseEntity<CompteSignatureDTO> viewCompteSignature(@PathVariable String businessKey) {
        String base64 = compteService
                .viewCompteSignatureWithBusinessKey(businessKey)
                .orElse(null);

        return ResponseEntity.status(200).body(
                new  CompteSignatureDTO(businessKey, base64)
        );
    }
}
