package africa.box.dm.controllers;

import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.controllers.exceptions.CompteNotException;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.DocumentEntryAddDto;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.service.*;
import africa.box.dm.utils.ContratFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/document")
@CrossOrigin(value = "*", origins = "*")
public class DocumentController {

    @Autowired
    Utils utils;

    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    private PdfDocService pdfDocService;

    @Autowired
    private CompteService compteService;

    @Autowired
    private LogInfoService logInfoService;

    private final String[] documentsToBeSigned =
            {"KYC personne physique BDU-CI", "Formualire SMS et EBanking",
                    "Formulaire d'adhésion au service Monétique BDU-CI", "Demande Ouverture de compte",
                    "Convention BDU", "Carton de signature", "Demande de chequier", "Formulaire d'obtention de consentement"};

    @GetMapping(path = "{businessKey}/doc-requirements")
    @ResponseBody
    public List<CompteDocument> getDocRequirements(
            @PathVariable("businessKey") String businessKey,
            @RequestParam(name = "status", required = false) DocumentStatus status){
        return compteDocumentDao.findByBusinessKeyAndDocumentStatus(businessKey, status);
    }

    /**
     * Liste des documents requis pour l'ouverture de compte
     * exceptés les documents à signer
     * @param businessKey du compte {@link Compte}
     * @return La liste des documents réquis {@link List<CompteDocument>}
     */
    @GetMapping(path = "{businessKey}/required")
    @ResponseBody
    public List<CompteDocument> getDemandeurDocumentsRequired(
            @PathVariable("businessKey") String businessKey){
        return compteDocumentDao.findByBusinessKeyAndDocumentStatus(businessKey, DocumentStatus.MANQUANT).stream()
                .filter(doc->{
                    Boolean found = true;
                    for (String documentToBeSigned:documentsToBeSigned){
                        if (doc.getName().trim().equalsIgnoreCase(documentToBeSigned)){
                            found = false;
                            break;
                        }
                    }
                    return found;
                })
                .collect(Collectors.toList());
    }

    /**
     * Liste des documents de la banque qui doivent etre signés par le demadeur po
     * ur l'ouverture de compte
     * @param businessKey du compte {@link Compte}
     * @return La liste des documents à signer {@link List<CompteDocument>}
     */
    @GetMapping(path = "{businessKey}/with-signature")
    @ResponseBody
    public Set<CompteDocument> getBankDocumentsRequiredToBesignedByDemandeur(@PathVariable String businessKey){
        return compteDocumentDao.findByBusinessKeyAndDocumentStatus(businessKey, DocumentStatus.MANQUANT).stream()
                .filter(doc->{
                    Boolean found = false;
                    for (String documentToBeSigned:documentsToBeSigned){
                        if (doc.getName().trim().equalsIgnoreCase(documentToBeSigned)){
                            found = true;
                            break;
                        }

                    }
                    return found;
                })
                .collect(Collectors.toSet());
    }

    @GetMapping(path = "{businessKey}/signed")
    @ResponseBody
    public Set<CompteDocument> getBankDocumentsRequiredAlreadySigned(@PathVariable String businessKey){
        return compteDocumentDao.findByBusinessKeyAndDocumentStatus(businessKey, DocumentStatus.EN_TRAITEMENT).stream()
                .filter(doc->{
                    Boolean found = false;
                    for (String documentToBeSigned:documentsToBeSigned){
                        if (doc.getName().trim().equalsIgnoreCase(documentToBeSigned)){
                            found = true;
                            break;
                        }
                    }
                    return found;
                })
                .collect(Collectors.toSet());
    }

    /**
     * La liste de tous les doucments réquis pour l'ouverture d'un compte
     * @param businessKey du compte {@link Compte}
     * @return La liste de tous les documents resuis {@link List<CompteDocument>}
     */
    public List<CompteDocument> getAllDocumentAboutDemandeur(String businessKey){
        return null;
    }

    @GetMapping(path = "{busniessKey}/contrat")
    @ResponseBody
    public CompteDocument getDocContrat(@PathVariable("businessKey") String businessKey){
        List<CompteDocument> cmptDoc = compteDocumentDao.findByBusinessKeyAndName(businessKey,"Contrat ouverture de compte");
        if (!cmptDoc.isEmpty()) {
            return cmptDoc.get(0);
        }
        return null;
    }
    @GetMapping(path = "{businessKey}/volo")
    @ResponseBody
    public CompteDocument getDocVolo(@PathVariable("businessKey") String businessKey){

        List<CompteDocument> voloDoc = compteDocumentDao.findByBusinessKeyAndName(businessKey,"Contrat VOLO");
        if (!voloDoc.isEmpty()) {
            return voloDoc.get(0);
        }
        return null;

    }

    @GetMapping("/all")
    @ResponseBody
    public List<DocumentType> listAllDocuments() {
        return  utils.documentPerCas("tous");
    }

    @PostMapping("/compte")
    @ResponseBody
    public List<DocumentType> listAllDocumentsForTypeCompte(@RequestBody Compte compte) {
        return  utils.getListDocumentRequirements(compte);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return  "{\n" +
                "                \"message\": \"data retreived ...\",\n" +
                "                \"data\": [\n" +
                "                    {\n" +
                "                        \"loantype\": \"Immobilier\",\n" +
                "                        \"senioritytimetype\": \"Année\",\n" +
                "                        \"monthlyreturned\": null,\n" +
                "                        \"statut_demande\": null,\n" +
                "                        \"undercatloan\": \"Prêt à la consommation\",\n" +
                "                        \"seniority\": 5,\n" +
                "                        \"childrens\": 5,\n" +
                "                        \"statut_docs\": 200,\n" +
                "                        \"loanamount\": 7890000.0,\n" +
                "                        \"employeremail\": null,\n" +
                "                        \"peoplescharges\": 7,\n" +
                "                        \"statut_confirm\": 200,\n" +
                "                        \"duration\": 12,\n" +
                "                        \"post\": null,\n" +
                "                        \"degree\": \"Bac+3\",\n" +
                "                        \"id\": 38,\n" +
                "                        \"creditdetails\": [],\n" +
                "                        \"typeduration\": \"Mois\",\n" +
                "                        \"employer\": \"MTN\",\n" +
                "                        \"businesskey\": \"1d814bf0-6097-11eb-be21-1cbfc05f736c\",\n" +
                "                        \"ownerhouse\": [\n" +
                "                            \"M\",\n" +
                "                            \"A\"\n" +
                "                        ],\n" +
                "                        \"returneddetails\": [],\n" +
                "                        \"loanmotif\": \"Projet\",\n" +
                "                        \"levelinoffice\": \"Responsable/chef de service\",\n" +
                "                        \"businesskey_loan\": null,\n" +
                "                        \"statut_stepper\": true,\n" +
                "                        \"regurlarpay\": false,\n" +
                "                        \"typesalaria\": \"Fonctionnaire\",\n" +
                "                        \"chargeamount\": 250000,\n" +
                "                        \"accountnumber\": 1452636958795.0,\n" +
                "                        \"useruid\": \"1327349b-ba03-4ad2-ab5a-a0eaa73a901a\",\n" +
                "                        \"effectifemployers\": null,\n" +
                "                        \"updated_at\": \"2021-01-31\",\n" +
                "                        \"matricule\": \"78556M\",\n" +
                "                        \"created_at\": \"2021-01-27\",\n" +
                "                        \"monthlypay\": 800000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"length\": 1,\n" +
                "                \"synchronisation\": \"2021-02-10\"\n" +
                "            }";
    }

    @PostMapping(path = "/addDoc/{businessKey}")
    @ResponseBody
    public StatusDto addDocuments(@PathVariable("businessKey") String businessKey, @RequestBody DocumentEntryAddDto doc) throws JsonProcessingException {
        doc.setBusinessKey(businessKey);
        if(doc.getName()!=null && doc.getDescription()!=null){
            CompteDocument dossierdoc=new CompteDocument();
            dossierdoc.setFacultatif(doc.getFacultatif());
            dossierdoc.setNumberOfCopies(doc.getNumberOfCopies());
            dossierdoc.setDocCode(doc.getDocCode());
            dossierdoc.setIdentifiant(UUID.randomUUID().toString());
            dossierdoc.setName(doc.getName());
            dossierdoc.setDescription(doc.getDescription());
            dossierdoc.setBusinessKey(businessKey);
            dossierdoc.setDocumentstatus(DocumentStatus.MANQUANT);
            doc.setStatut(doc.getConfirmation()==null || doc.getConfirmation()==true?"confirmation":"schema");
            dossierdoc.setStatut(doc.getStatut());
            compteDocumentDao.save(dossierdoc);//

            // Ajout de log: document ajouté manuellement
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.DOCUMENT_AJOUTE+" ("+doc.getName()+")",
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.ETAPE_CHARGER_LES_DOCUMENTS);

            return  StatusDto.ofSuccess("Information bien enregistrée");
        }

        return StatusDto.ofError("Erreur d'enregistrement du nouveau document",new MyAppException("Erreur d'ajout du document"));
    }

    //  produces = {"application/octet-stream"}

    //@GetMapping(path = "/contrat-ouverture-compt/{dossierId}", produces = {"application/octet-stream"})
    public ResponseEntity<Resource> getContrat(
            @PathVariable String dossierId, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Compte compte = compteService.getCompte(dossierId).orElseThrow(()->new CompteNotException());
        //pdfDocService.createContrat(compte.getNomDemandeur() + " "+ compte.getPrenomDemandeur(), compte.getTypeCompte());
        Resource resource = pdfDocService.generateContratOC(compte.getNomDemandeur() , compte.getPrenomDemandeur(), compte.getTypeCompte());

        String contentType = null;
        ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();
        try {
            //contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            String extn = FilenameUtils.getExtension(resource.getFilename());

            switch(extn){
                case "png":
                    respEnt.contentType(MediaType.IMAGE_PNG);
                    break;
                case "jpeg":
                case "jpg":
                    respEnt.contentType(MediaType.IMAGE_JPEG);
                    break;
                case "pdf":
                    respEnt.contentType(MediaType.APPLICATION_PDF);
                    break;
                case "tiff":
                    respEnt.contentType(MediaType.valueOf("image/tiff"));
                    break;
                case "xtiff":
                    respEnt.contentType(MediaType.valueOf("image/x-tiff"));
                    break;
                case "doc":
                    respEnt.contentType(MediaType.valueOf("application/doc"));
                    break;
                case "docx":
                    respEnt.contentType(MediaType.valueOf("application/docx"));
                    break;
                default:
                    respEnt.contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"");

            }

        } catch (Exception ex) {
        }

        return respEnt
                //dynamically set the content-type.
                /*.header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"")*/
                .body(resource);

//        // Fallback to the default content type if type could not be determined
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                //.contentType(MediaType.parseMediaType(contentType))
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
    }

    @GetMapping(path = "/contrats/{businessKey}/{name}")
    @ResponseBody
    public ResponseEntity<Resource> viewContratOvertureDeCompte(
            @PathVariable String businessKey, @PathVariable String name, HttpServletRequest request,
            HttpServletResponse response) throws  Exception{

        Compte compte = compteService.getCompte(businessKey).orElseThrow(()->new CompteNotException());
        ContratFactory contratFactory = ContratFactory.contratsFor(compte);

        Resource resource = contratFactory.findContratByName(name.replace("_", " "));

        String contentType = null;
        ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            System.out.println(contentType);
            String extn = FilenameUtils.getExtension(resource.getFilename());

            switch (extn) {
                case "png":
                    respEnt.contentType(MediaType.IMAGE_PNG);
                    break;
                case "jpeg":
                case "jpg":
                    respEnt.contentType(MediaType.IMAGE_JPEG);
                    break;
                case "pdf":
                    respEnt.contentType(MediaType.APPLICATION_PDF);
                    break;
                case "tiff":
                    respEnt.contentType(MediaType.valueOf("image/tiff"));
                    break;
                case "xtiff":
                    respEnt.contentType(MediaType.valueOf("image/x-tiff"));
                    break;
                case "doc":
                    respEnt.contentType(MediaType.valueOf("application/doc"));
                    break;
                case "docx":
                    respEnt.contentType(MediaType.valueOf("application/docx"));
                    break;
                default:
                    respEnt.contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

            }
        }
            catch (Exception ex) {
        }

        //return respEnt.body(resource);

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                //.contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

        }

    @GetMapping(path = "/rib/{businessKey}")
    @ResponseBody
    public ResponseEntity<Resource> viewReleveIdentiteBancaire(
            @PathVariable String businessKey, HttpServletRequest request,
            HttpServletResponse response) throws  Exception{

        Compte compte = compteService.getCompte(businessKey).orElseThrow(()->new CompteNotException());
        ContratFactory contratFactory = ContratFactory.contratsFor(compte);
        Resource resource = contratFactory.generateRib();

        String contentType = null;
        ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            String extn = FilenameUtils.getExtension(resource.getFilename());

            switch (extn) {
                case "png":
                    respEnt.contentType(MediaType.IMAGE_PNG);
                    break;
                case "jpeg":
                case "jpg":
                    respEnt.contentType(MediaType.IMAGE_JPEG);
                    break;
                case "pdf":
                    respEnt.contentType(MediaType.APPLICATION_PDF);
                    break;
                case "tiff":
                    respEnt.contentType(MediaType.valueOf("image/tiff"));
                    break;
                case "xtiff":
                    respEnt.contentType(MediaType.valueOf("image/x-tiff"));
                    break;
                case "doc":
                    respEnt.contentType(MediaType.valueOf("application/doc"));
                    break;
                case "docx":
                    respEnt.contentType(MediaType.valueOf("application/docx"));
                    break;
                default:
                    respEnt.contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

            }
        }
        catch (Exception ex) {
        }

        //return respEnt.body(resource);

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                //.contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }

    @GetMapping(path = "/contrats/all/{businessKey}")
    public ResponseEntity<StreamingResponseBody> downloadContratZip(
            @PathVariable String businessKey, HttpServletResponse response) throws Exception{
        Compte compte = compteService.getCompte(businessKey).orElseThrow(()->new CompteNotException());
        //pdfDocService.createContrat(compte.getNomDemandeur() + " "+ compte.getPrenomDemandeur(), compte.getTypeCompte());
//        List<Resource> resources = new ArrayList<>();
//        resources.add(pdfDocService.generateContratOC(compte.getNomDemandeur() , compte.getPrenomDemandeur(), compte.getTypeCompte()));
//        resources.add(pdfDocService.generateContratVOLO(compte.getNomDemandeur() , compte.getPrenomDemandeur()));
//        if (compte.getCarteBancaires().size() > 0){
//            resources.add(pdfDocService.generateContratDemandeCartCredit(compte.getNomDemandeur() , compte.getPrenomDemandeur()));
//        }

        ContratFactory contratFactory = ContratFactory.contratsFor(compte);
        List<Resource> resources = contratFactory.generateAllPdf();
        int BUFFER_SIZE = 1024;

        StreamingResponseBody streamResponseBody = out -> {

            final ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            ZipEntry zipEntry = null;
            InputStream inputStream = null;

            try {
                for (Resource resource : resources) {
                    //File file = new File(path);
                    zipEntry = new ZipEntry(resource.getFilename());

                    inputStream = new FileInputStream(resource.getFile());

                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] bytes = new byte[BUFFER_SIZE];
                    int length;
                    while ((length = inputStream.read(bytes)) >= 0) {
                        zipOutputStream.write(bytes, 0, length);
                    }

                }
                // set zip size in response
                response.setContentLength((int) (zipEntry != null ? zipEntry.getSize() : 0));
            } catch (IOException e) {
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            }

        };

        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=liste-des-contrats.zip");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Expires", "0");

        return ResponseEntity.ok(streamResponseBody);
    }

}