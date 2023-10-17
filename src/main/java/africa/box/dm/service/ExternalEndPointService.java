package africa.box.dm.service;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.ExternalEndPointConfig;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.db.CompteDao;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.DocumentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.*;

@Service
public class ExternalEndPointService {

    @Autowired
    Utils utils;

    @Autowired
    CompteDao compteDao;

    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    ExternalEndPointConfig externalEndPointConfig;

    @Autowired
    PdfDocService pdfDocService;

    @Autowired
    private LogInfoService logInfoService;

    private final StorageService storageService;

    public ExternalEndPointService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Bean
    public RestTemplate restTemplate() {
//        return new RestTemplate(getClientHttpRequestFactory());
        return new RestTemplate();
    }

//    private ClientHttpRequestFactory getClientHttpRequestFactory() {
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        clientHttpRequestFactory.setConnectTimeout(25000);
//        clientHttpRequestFactory.setReadTimeout(20000);
//        return clientHttpRequestFactory;
//    }

    @Transactional
    public String saveExternalCompteInitiate (JSONObject params, boolean fromAdmin){
        /*
            +++++ PROCESS +++++
            * Get all external Compte
            * ForEach external compte
                - Add new businesskey
                - Save in database
                - Get all docs of compte
                - ForEach docs
                    - add businesskey
                    - save in database
                    - get file
                    - save file
                - Update businesskey of externalEndPoint
         */
        // Get all external compte
        System.out.println(" +++++++++ Get all external compte +++++++++ ");
        String rslt = getAllCompte(params);
//        return test(params);
        System.out.println("rslt========="+rslt);

        List <ExternalCompteNew> externalCompteList = new ArrayList<>();
        List <Compte> comptes = new ArrayList<>();
        ObjectMapper oMapper = new ObjectMapper();
        try {
            Map<String, Object> map = oMapper.readValue(rslt, Map.class);
            externalCompteList = (List<ExternalCompteNew>) map.get("jdd");
            System.out.println(externalCompteList);
            // ForEach external account
            System.out.println(" +++++++++ ForEach external account +++++++++ ");
            for (int i=0;i<externalCompteList.size();i++){
                oMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
                oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                ExternalCompteNew e = oMapper.convertValue(externalCompteList.get(i),ExternalCompteNew.class);
                Compte compte= ModelMapper.convertExternalCompteNewToCompte(e,true);
                //- Add new businesskey
                System.out.println(" +++++++++ Add new businesskey +++++++++ ");
                String newBk = utils.generateBusinessKey();
                String oldBk = e.getBusinesskey();
                compte.setBusinessKey(newBk);
                compte.setStatus(DmStatus.NOUVEAU);
                compte.setFromOnboarding(true);
//                //- Save in database
//                System.out.println(" +++++++++ Save in database +++++++++ ");
//                Compte compte = ModelMapper.convertCompteDtoToCompte(compte);
//                compte.setFromAdmin(fromAdmin);
                compte = compteDao.save(compte);
                System.out.println("===== compte Saved ===== ");
                // Ajout de log si inexistant: initialisation de la synchronisation
                List<LogInfo> logInfo = logInfoService.getLogOfDossierByStep(
                        compte.getBusinessKey(),
                        LogInfoConstante.INITIALISATION_DU_DOSSIER.INITIALISATION_DE_DOSSIER);
                if (logInfo.isEmpty()){
                    logInfoService.addLog(LogInfoConstante.INITIALISATION_DU_DOSSIER.SYNCHRONISATION,
                            compte.getBusinessKey(),
                            null);
                }

                logInfoService.addLog(
                        LogInfoConstante.INITIALISATION_DU_DOSSIER.SYNCHRONISER_POUR_TRAITEMENT,
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

                // Traitement des Dossiers ===> Vérification signature
                logInfoService.addLog(
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE,
                        compte.getBusinessKey(),
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.TRAITEMENT_DU_DOSSIER);

                //  - Approbation
                logInfoService.addLog(
                        LogInfoConstante.APPROBATION_DU_DOSSIER.APPROBATION_DU_DOSSIER,
                        compte.getBusinessKey(),null);

//                //- Update businesskey of externalEndPoint
//                System.out.println(" +++++++++ Update businesskey of externalEndPoint +++++++++ ");
//                JSONObject paramsUpdBusinessKey = new JSONObject();
//                paramsUpdBusinessKey.put("businesskey",oldBk);
//                paramsUpdBusinessKey.put("uuid",newBk);
//                String rsltUpdBusinessKey = updateBusinessKey(paramsUpdBusinessKey);
//                Map<String, Object> mapUpdBusinessKey = oMapper.readValue(rslt, Map.class);

                //- Get all docs of account
                System.out.println(" +++++++++ Get all docs of account +++++++++ ");
                JSONObject paramsGetCompteDocs = new JSONObject();
                paramsGetCompteDocs.put("businesskey",oldBk);
                String rsltGetCompteDocs = getCompteDoc(paramsGetCompteDocs);

                List <CompteDocument> compteDocuments = new ArrayList<>();
                List <CompteDocument> compteDocumentsFinal = new ArrayList<>();
                Map<String, Object> mapDoc = oMapper.readValue(rsltGetCompteDocs, Map.class);
                compteDocuments = (List<CompteDocument>) mapDoc.get("jdd");

                System.out.println(" +++++++++ ForEach doc account +++++++++ ");
                for (int y=0;y<compteDocuments.size();y++) {

                    System.out.println(compteDocuments.get(y));
                    ExternalCompteDocument externalCompteDocument = oMapper.convertValue(compteDocuments.get(y),ExternalCompteDocument.class);
                    CompteDocument d = ModelMapper.convertExternalCompteDocumentToCompteDocument(externalCompteDocument);
                    d.setIdentifiant(String.valueOf(UUID.randomUUID()));
                    d.setContentType(externalCompteDocument.getContent_type());
//                    d.setFromAdmin(fromAdmin);
                    d.setCreatedAt(new Date());
                    System.out.println(d);
                    System.out.println(" +++++++++ add businesskey +++++++++ "+d.getIdentifiant()+" +++++ "+d.getName());
                    d.setBusinessKey(newBk);
                    if (d.getDocumentstatus().equals(DocumentStatus.EN_TRAITEMENT)) {
                        try {
//                            String urlDoc =null;
//                            if (d.getDocCode().equals("SIG"))urlDoc = externalCompteDocument.getDocpath();
//                            else if (d.getDocCode().equals("JRESIDE"))urlDoc = externalCompteDocument.getDocpath();

                            String rsltUpload = getCompteDocumentFileUploaded(oldBk+"",d,externalCompteDocument.getDocpath());
                            System.out.println(" +++++++++++ ID-> "+rsltUpload);
                            d.setDocPath(rsltUpload);

                            // Ajout de log: document chargé
                            logInfoService.addLog(
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.DOCUMENT_CHARGE+" ("+externalCompteDocument.getName()+")",
                                    newBk,
                                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.ETAPE_CHARGER_LES_DOCUMENTS);
//                            CompteDocumentDto uploadDocDto = storageService.store(businessKey, file, docId, compteDocumentDto);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    compteDocumentsFinal.add(d);
                }
                CompteDocument doc = new CompteDocument();
                doc.setIdentifiant(String.valueOf(UUID.randomUUID()));
                doc.setBusinessKey(compte.getBusinessKey());
                doc.setNumberOfCopies(1);
                doc.setCreatedAt(new Date());
                doc.setStatut("confirmation");
                doc.setDocumentstatus(DocumentStatus.MANQUANT);
                doc.setFacultatif(false);
                doc.setName(BusinessConstants.DOC_CIP);
                doc.setDocCode(BusinessConstants.DOC_CODE_CONFIRMATION);
                doc.setDescription(BusinessConstants.DOC_CODE_CONFIRMATION);
//                document.setFromAdmin(fromAdmin);
                compteDocumentsFinal.add(doc);

                compteDocumentDao.saveAll(compteDocumentsFinal);
                System.out.println(compte);

                //- Update businesskey of externalEndPoint
                System.out.println(" +++++++++ Update businesskey of externalEndPoint +++++++++ ");
                JSONObject paramsUpdBusinessKey = new JSONObject();
                paramsUpdBusinessKey.put("businesskey",oldBk);
                paramsUpdBusinessKey.put("uuid",newBk);
                String rsltUpdBusinessKey = updateBusinessKey(paramsUpdBusinessKey);
                Map<String, Object> mapUpdBusinessKey = oMapper.readValue(rslt, Map.class);

//                if (compte.getFromOnboarding()){
//                    JSONObject p  = new JSONObject();
//                    p.put("state",DmStatus.EN_TRAITEMENT);
//                    p.put("businesskey",compte.getBusinessKey());
//                    updateCompteState(p);
//                    System.out.println(" updateCompteState ======> ");
//                }
                pdfDocService.createComptePDF(compte.getBusinessKey());
                pdfDocService.createVoloPDF(compte.getBusinessKey());


            }


            return externalCompteList.size()+"";
        } catch (JsonProcessingException | ParseException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @Async
    public String getCompteDocumentFileUploaded (String externalBusinessKey, CompteDocument d, String urlFile){
        String urlFileUploaded = externalEndPointConfig.getGet_file_uploaded_url()+"/"+externalBusinessKey+"/"+d.getDocCode();
        System.out.println("urlFile ===>"+urlFile);
        MultipartFile file = restTemplate().execute((urlFile==null?urlFileUploaded:urlFile), HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", "tmp");
            FileOutputStream fichier=new FileOutputStream(ret);
            StreamUtils.copy(clientHttpResponse.getBody(), fichier);
            System.out.println(clientHttpResponse.getHeaders().getContentType());

            FileItem fileItem = new DiskFileItem("mainFile", ""+clientHttpResponse.getHeaders().getContentType(), false, ret.getName(), (int) ret.length(), ret.getParentFile());

            try {
                InputStream input = new FileInputStream(ret);
                OutputStream os = fileItem.getOutputStream();
                IOUtils.copy(input, os);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

            fichier.close();
            return multipartFile;
        });

        DocumentDto dto = storageService.store(
                d.getBusinessKey(),
                file,
                d.getIdentifiant(),
                ModelMapper.convertCompteDocumentToDocumentDto(d)
        );

        return dto.getDocPath();
    }

    public File getProfilePic(String FILE_URL){
        File file = restTemplate().execute(FILE_URL, HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", "tmp");
            FileOutputStream f=new FileOutputStream(ret);
            StreamUtils.copy(clientHttpResponse.getBody(), f);
            System.out.println(clientHttpResponse.getHeaders().getContentType());
            f.close();
            return ret;
        });
//        System.out.println(file.getName());
//        System.out.println(file.toString());
//        System.out.println(file.getAbsolutePath());
        return file;
    }

    public String callExternalEndPoint (JSONObject params,String url, HttpMethod method){
        System.out.println("==================> url "+url);
        HttpHeaders headers = new HttpHeaders();
//      headers.add("Authorization", "Bearer "+access_token);
        headers.add("authorizations", "DH9QhgopYgZ0VyQNSVj1407RrlAolzMAeQYwVSYLNA==");
        headers.add("Content-Type", "application/json");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(params, headers);
        String result = restTemplate().exchange(url, method, entity, String.class).getBody();
        System.out.println("==================> result "+result);
        return result;
    }

    // +++++++++++ query to take all account +++++++++++
    public String getAllCompte (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getGet_all_file_url(),HttpMethod.GET);
    }

    // +++++++++++ query get all loanFile's docs +++++++++++
    public String getCompteDoc (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getGet_docs_url(),HttpMethod.POST);
    }

//    public String test (JSONObject params){
//        return callExternalEndPoint(params, ExternalEndPointConfig.TEST,HttpMethod.GET);
//    }

    // +++++++++++ query to update businesskey +++++++++++
    public String updateBusinessKey (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getUpdate_businesskey_url(),HttpMethod.PUT);
    }

    // +++++++++++ query to update state of account apply +++++++++++
    public String updateCompteState (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getUpdate_state_file_url(),HttpMethod.PUT);
    }

    // +++++++++++ query to add new docs into list +++++++++++
    public String addNewDocFile (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getAdd_doc_url(),HttpMethod.POST);
    }

    public String addDocFile (JSONObject params){
        return callExternalEndPoint(params, externalEndPointConfig.getAdd_doc_for_sign(),HttpMethod.POST);
    }

    public String callDkbsPost (JSONObject params){
        String url = "http://www.dkbsolutions.com/Api_dkbsign4/v1/Testdkbsign";
        return callExternalEndPoint(params, url,HttpMethod.POST);
    }



//    public String addDocFile(File url, String businesskey) throws IOException {
//        //return callExternalEndPoint(url,businesskey, externalEndPointConfig.getAdd_doc_for_sign());
//         uploadSingleFile(url,businesskey, externalEndPointConfig.getAdd_doc_for_sign());
//         return "ok";
//    }

//    public String callExternalEndPoint (File fichier, String businessKey,String serverUrl){
//        System.out.println("==================> url"+serverUrl);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        //      headers.add("Authorization", "Bearer "+access_token);
//        MultiValueMap<String, Object> body  = new LinkedMultiValueMap<>();
//        body.add("pdf", new FileSystemResource(fichier));
//        body.add("businesskey", businessKey);
//        HttpEntity<MultiValueMap<String, Object>> requestEntity
//                = new HttpEntity<>(body, headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate
//                .postForEntity(serverUrl, requestEntity, String.class);
//        String result ="";
//      if(response.hasBody()){
//          result = response.getBody().toString();
//      }
//        System.out.println("==================> result "+result);
//        return result;
//    }
//

//    private  void uploadSingleFile(File fichier, String businessKey,String serverUrl)throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("pdf", getTestFile());
//        body.add("businesskey", businessKey);
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//        //String serverUrl = "http://localhost:8082/spring-rest/fileserver/singlefileupload/";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);
//        System.out.println("Response code: " + response.getStatusCode());
//    }

    public static Resource getTestFile() throws IOException {
        Path testFile = Files.createTempFile("test-file", ".txt");
        System.out.println("Creating and Uploading Test File: " + testFile);
        Files.write(testFile, "Hello World !!, This is a test file.".getBytes());
        return new FileSystemResource(testFile.toFile());
    }

}
