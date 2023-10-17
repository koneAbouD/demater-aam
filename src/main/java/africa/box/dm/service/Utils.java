package africa.box.dm.service;

import africa.box.dm.config.DmnConstants;
import africa.box.dm.db.BusinessKeySeqDao;
import africa.box.dm.db.CompteDao;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.NotesDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.CountryDTO;
import net.minidev.json.JSONObject;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Utils {

    @Autowired
    CompteDao compteDao;

    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    NotesDao notesDao;

    @Autowired
    BusinessKeySeqDao businessKeySeqDao;

    @Autowired
    ExternalEndPointService externalEndPointService;

    public String generateBusinessKey (){
        /*
            On recupère la ligne de configuration
            On recupère le currentNumber et le currentLettersCode
            On les incrémentes et on les mets à jour
            On génère les lettres à l'aide du currentLettersCode
            On combine le businesskey = currentLettersCode - currentNumber
            On recherche s'il y a un businesskey avec ce même code

            Si oui on reprend
            Si non on retourne le businesskey
         */

        String currentLetters = "";
        int currentNumber= 1;
        String currentNumber_str= ""+currentNumber;
        int currentLettersCode= 26; // => 26 = AA, 27 = AB, 28 = AC, ...
        String businessKey="";

        boolean save = false;
        while (!save) {
            try {
                List<BusinessKeySeq> businessKeySeqs = businessKeySeqDao.findAll();
                BusinessKeySeq businessKeySeq = new BusinessKeySeq();
                if (businessKeySeqs.size()>0) {
                    businessKeySeq = Collections.max(businessKeySeqs, Comparator.comparing(b -> b.getIdentifiant()));
                    currentNumber = businessKeySeq.getCurrentNumber() + 1;
                    if (currentNumber>=999){
                        currentNumber = 1;
                        currentLettersCode = businessKeySeq.getCurrentLettersCode() + 1;
                    }else {
                        currentLettersCode = businessKeySeq.getCurrentLettersCode();
                    }

                    if (currentNumber<10 && currentNumber>=0){
                        currentNumber_str="00"+currentNumber;
                    }else if (currentNumber<100 && currentNumber>=10){
                        currentNumber_str="0"+currentNumber;
                    }
                }
                currentLetters = generateLetters(currentLettersCode);

                businessKeySeq.setCurrentLetters(currentLetters);
                businessKeySeq.setCurrentLettersCode(currentLettersCode);
                businessKeySeq.setCurrentNumber(currentNumber);
                businessKeySeqDao.save(businessKeySeq);

                businessKey = currentLetters+""+currentNumber_str;

                Optional<Compte> compte = compteDao.findById(businessKey);
                if (!compte.isPresent()) save = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return businessKey;
    }

    public String generateLetters(int i) {
        return i < 0 ? "" : generateLetters((i / 26) - 1) + (char)(65 + i % 26);
    }
    public static String newKey() {
        return UUID.randomUUID().toString();
    }

    @Autowired
    private ProcessEngine processEngine;

    public List<DocumentType> getListDocumentRequirements(Compte compte) {
        Set<DocumentType> set = new HashSet<>();
        List<String> initialiseur = CheckInitialisateur(compte);

        initialiseur.forEach(x -> System.out.println("doccum"+x));
        if (compte != null) {
            initialiseur.stream().
                    forEach(cond -> {
                        set.addAll(documentPerCas(cond));
                    });
            List<DocumentType> result = set.stream()
                    .sorted((x, y) -> x.getName().compareTo(y.getName()))
                    .distinct()
                    .collect(Collectors.toList());
            return result;
        }
        return null;
    }

    public List<DocumentType> documentPerCas(String condition) {
        DecisionService decisionService = processEngine.getDecisionService();
        VariableMap variables = Variables.createVariables()
                .putValue("conditions", condition);
        DmnDecisionResult decisionResult = decisionService
                .evaluateDecisionByKey(DmnConstants.DMN_DECISION_KEY)
                .variables(variables)
                .evaluate();
        List<Map<String, Object>> listD = decisionResult.getResultList();
        List<DocumentType> list = new ArrayList<>();
        listD.parallelStream().forEach(o -> {
            DocumentType d = new DocumentType((String) o.get("docCode"), (String) o.get("name"), (String) o.get("description"));
            d.setId((Integer) o.get("id"));
            d.setStatut((String) o.get("statut"));
            d.setFacultatif((Boolean) o.get("facultatif"));
            d.setNumberOfCopies((Integer) o.get("numberOfCopies"));
            d.setFromClient((Boolean) o.get("fromClient"));
            list.add(d);
        });
        return list;
    }

    public List<String> CheckInitialisateur(Compte c) {
        System.out.println("CheckInitialisateur "+c.getTypeDePiece());
        List<String> conditions = new ArrayList<String>();
        if (!c.getNationalite().getNationalite().trim().equalsIgnoreCase(DmnConstants.NATIONALITE.NATIONALITE_IVOIRIENNE)){
            conditions.add(DmnConstants.PERSONNE_ETRANGERE);
        }

       /* if (c.getCreditCardType() != null && !c.getCreditCardType().isEmpty()){
            conditions.add(DmnConstants.CREDIT_CARD);
        }*/

        if (c.getIsConjoint().equals(true)){
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_CONJOINT);
            if (!c.getConjoint().getTypeDePiece().equalsIgnoreCase(DmnConstants.IDCardType.PASSEPORT)){
                conditions.add(DmnConstants.ID_CARD_CONJOINT_VERSO);
            }
        }

        if (!c.getTypeDePiece().equalsIgnoreCase(DmnConstants.IDCardType.PASSEPORT)){
            conditions.add(DmnConstants.ID_CARD_VERSO);
        }

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_COMPTE_COURANT);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.EPARGNE) &&
                c.getTypeDemandeur().equalsIgnoreCase(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_COMPTE_EPARGNE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equalsIgnoreCase(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE) &&
                c.getSousTypeClient().equals(DmnConstants.TYPE_DOMAINE_DEMANDEUR.COMMERCANT))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_COMMERCANT_COMPTE_COURANT);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE) &&
                c.getSousTypeClient().equals(DmnConstants.TYPE_DOMAINE_DEMANDEUR.GENDARME))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_CORPS_COMPTE_COURANT);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE) &&
                c.getSousTypeClient().equals(DmnConstants.TYPE_DOMAINE_DEMANDEUR.CORPS))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_CORPS_COMPTE_COURANT);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.PHYSIQUE) &&
                c.getSousTypeClient().equals(DmnConstants.TYPE_DOMAINE_DEMANDEUR.COMMERCANT))
            conditions.add(DmnConstants.PERSONNE_PHYSIQUE_COMMERCANT_COMPTE_COURANT);

        // PERSONNE MORALE

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                (c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.ENTREPRISE_INDIVIDUELLE) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.ASSOCIATION_CIVILE) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.AVOCAT) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.CABINET_ARCHITECTURE) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.CLINIQUES_MEDICALES) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.COURTIER_ASSURANCE) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.LIQUIDATEUR) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.HUISSIER) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.PHARMACIE) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SA) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SARL) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SOCIETE_CIVILE_EXPLOITANTS_FORESTIERS) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SOCIETES_CIVILES_IMMOBILIERES) ||
                        c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.NOTAIRE)))
            conditions.add(DmnConstants.PERSONNE_MORALE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.ENTREPRISE_INDIVIDUELLE))
            conditions.add(DmnConstants.PERSONNE_MORALE_ENTR_INDIVID);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.NOTAIRE))
            conditions.add(DmnConstants.PERSONNE_MORALE_NOTAIRE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SARL))
            conditions.add(DmnConstants.PERSONNE_MORALE_SARL);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SA))
            conditions.add(DmnConstants.PERSONNE_MORALE_SA);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SOCIETES_CIVILES_IMMOBILIERES))
            conditions.add(DmnConstants.PERSONNE_MORALE_SOCIETE_IMMOBILIERE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.SOCIETE_CIVILE_EXPLOITANTS_FORESTIERS))
            conditions.add(DmnConstants.PERSONNE_MORALE_SOCIETE_CIVIL_EXPLOITATION);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.PHARMACIE))
            conditions.add(DmnConstants.PERSONNE_MORALE_PHARMACIE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.CLINIQUES_MEDICALES))
            conditions.add(DmnConstants.PERSONNE_MORALE_CLINIQUES_MEDICALE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.HUISSIER))
            conditions.add(DmnConstants.PERSONNE_MORALE_HUISSIER);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.COURTIER_ASSURANCE))
            conditions.add(DmnConstants.PERSONNE_MORALE_COURTIER_ASS);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.AVOCAT))
            conditions.add(DmnConstants.PERSONNE_MORALE_AVOCAT);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.LIQUIDATEUR))
            conditions.add(DmnConstants.PERSONNE_MORALE_LIQUIDATEUR);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.CABINET_ARCHITECTURE))
            conditions.add(DmnConstants.PERSONNE_MORALE_CABINET_ARCHITECTURE);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getSousTypeClient().equals(DmnConstants.FORME_JURIDIQUE_ENTREPRISE.ASSOCIATION_CIVILE))
            conditions.add(DmnConstants.PERSONNE_MORALE_ASSOCIATION_CIVIL);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getIsNouvelleSociete() == true)
            conditions.add(DmnConstants.PERSONNE_MORALE_NOUVEAU);

        if (c.getTypeCompte().equals(DmnConstants.TYPE_COMPTE.CHECK) &&
                c.getTypeDemandeur().equals(DmnConstants.TYPE_DEMANDEUR.MORALE) &&
                c.getIsNouvelleSociete() == false)
            conditions.add(DmnConstants.PERSONNE_MORALE_ANCIEN);
        System.out.println("CheckInitialisateur "+c.getTypeCompte());
        conditions.forEach(x -> System.out.println("conditions "+x));
        return conditions;
    }

    public boolean compteCanBeInTraitement(String businessKey){
        Optional<Compte> dos= compteDao.findById(businessKey);
        boolean enTraitement = false;
        if(dos.isPresent()){
            Compte compte=dos.get();
            List<CompteDocument> compteDocument = compteDocumentDao.findByBusinessKeyAndFromClient(businessKey,true);
            enTraitement = true;
            // On verifie si tous les documents obligatoires du compte provenant du client on un statut différent de manquant
            for (CompteDocument dossierDocument: compteDocument){
                if (!(dossierDocument.getFromClient() != null &&
                        dossierDocument.getFromClient() &&
                        !dossierDocument.getDocumentstatus().equals(DocumentStatus.MANQUANT)))
                    enTraitement = false;
            }

            // SI le compte PEUT passer EN_TRAITEMENT ET qu'il est EN_ATTENTE :
            // On ajoute une note
            // Si non s'il est déjà EN_TRAITEMENT on ne fait rien
            if (enTraitement){
                if (compte.getStatus().equals(DmStatus.EN_ATTENTE) ||
                        compte.getStatus().equals(DmStatus.NOUVEAU)) {
                    compte.setStatus(DmStatus.EN_TRAITEMENT);
                    compteDao.save(compte);

                    Notes note=new Notes();
                    note.setBusinessKey(businessKey);
                    note.setType(NoteTypes.INFORMATION);
                    note.setNote("Compte passé en traitement");
                    note.setSla("START");
                    notesDao.save(note);
                }

                if (compte.getFromOnboarding()!=null && compte.getFromOnboarding()){
                    JSONObject params = new JSONObject();
                    params.put("state",DmStatus.EN_TRAITEMENT);
                    params.put("businesskey",compte.getBusinessKey());

                    externalEndPointService.updateCompteState(params);
                }

            } else if (compte.getStatus().equals(DmStatus.EN_TRAITEMENT)) {
                compte.setStatus(DmStatus.EN_ATTENTE);
                compteDao.save(compte);

                Notes note=new Notes();
                note.setBusinessKey(businessKey);
                note.setType(NoteTypes.INFORMATION);
                note.setNote("Compte remis en attente");
                note.setSla("PAUSE");
                notesDao.save(note);

                if (compte.getFromOnboarding()!=null && compte.getFromOnboarding()){
                    JSONObject params = new JSONObject();
                    params.put("state",DmStatus.EN_ATTENTE);
                    params.put("businesskey",compte.getBusinessKey());

                    externalEndPointService.updateCompteState(params);
                }

            }
        }
        return enTraitement ;
    }

//    public String getLoanDocumentFileUploaded (String externalBusinessKey, DossierDocument d){
//        String urlFileUploaded = externalEndPointConfig.getGet_file_uploaded_url()+"/"+externalBusinessKey+"/"+d.getDocCode();
//        MultipartFile file = restTemplate3().execute(urlFileUploaded, HttpMethod.GET, null, clientHttpResponse -> {
//            File ret = File.createTempFile("download", "tmp");
//            FileOutputStream fichier=new FileOutputStream(ret);
//            StreamUtils.copy(clientHttpResponse.getBody(), fichier);
//            System.out.println(clientHttpResponse.getHeaders().getContentType());
//
//            FileItem fileItem = new DiskFileItem("mainFile", ""+clientHttpResponse.getHeaders().getContentType(), false, ret.getName(), (int) ret.length(), ret.getParentFile());
//
//            try {
//                InputStream input = new FileInputStream(ret);
//                OutputStream os = fileItem.getOutputStream();
//                IOUtils.copy(input, os);
//                // Or faster..
//                // IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
//            } catch (IOException ex) {
//                // do something.
//            }
//
//            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//            // CommonsMultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//
//            fichier.close();
//            return multipartFile;
//        });
//
//        DossierDocumentDto dto = storageService.store(
//                d.getBusinessKey(),
//                file,
//                d.getIdentifiant(),
//                ModelMapper.convertDossierDocumentToDossierDocumentDto(d)
//        );
//
//        return dto.getDocPath();
//    }


    //    isNouvelleSociete, getIsNouvelleSociete==true



    public static List<CountryDTO> listCountries(String langKey){
        List<CountryDTO> countries = new ArrayList<>();
        String[] isoCountries = Locale.getISOCountries();

        for (String country : isoCountries){
            Locale locale = new Locale(langKey, country);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            if (!"".equals(iso) && !"".equals(code) && !"".equals(name)){
                countries.add(new CountryDTO(iso, code, name));
            }
        }

        return countries;
    }

}
