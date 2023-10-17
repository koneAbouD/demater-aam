package africa.box.dm.controllers;

import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.DocFileDao;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DocumentStatus;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.service.*;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/docs/{businessKey}")
@CrossOrigin(value = "*", origins = "*")
public class DocUploadController {
    private static final Logger logger = LoggerFactory.getLogger(DocUploadController.class);

    private final StorageService storageService;

    public DocUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    CompteDocumentDao documentDao;

    @Autowired
    PdfDocService pdfDocService;

    @Autowired
    private DocFileDao docFileDao;

    @Autowired
    Utils utils;

    @Autowired
    private LogInfoService logInfoService;




    @GetMapping()
    @ResponseBody
    public List<DocumentDto> listUploadedFiles(@PathVariable("businessKey") String businessKey) {
        return storageService.findFiles(businessKey);
    }

    @GetMapping("/test")
    @ResponseBody
    public String  testService(@PathVariable("businessKey") String businessKey) {

        return "Information bien notée "+businessKey ;
    }


    @GetMapping("/{docId}/serve")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("businessKey") String businessKey,
                                              @PathVariable("docId") String docId,
                                              HttpServletRequest request,
                                              HttpServletResponse response)throws Exception {
//        DocFile docFile = storageService.getDocument(docId, businessKey).orElseThrow(
//                ()->{return new RuntimeException("Document introvable");}
//        );

        Resource resource = storageService.getDocument(businessKey, docId)
                .orElseThrow(()->{return new RuntimeException("Fichier introuvable");});

//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(docFile.getContentType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + docFile.getOriginalFilename() + "\"")
//                .body(docFile.getBytes());
        try {
//            MultipartFile mprt = storageService
//                    .getDocument(businessKey, docId)
//                    .orElseThrow(()->{return new RuntimeException("Document introuvable");});
//
//            //Resource file = storageService.loadAsResource(businessKey, docId);
//            // file, type,if this is a jpeg, png, pdf,
//            //String extn = FilenameUtils.getExtension(file.getFilename());
            String extn = FilenameUtils.getExtension(resource.getFilename());
            ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();
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
                            //.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + file.getFilename() + "\"");

            }
            return respEnt
                    //dynamically set the content-type.
                    /*.header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"")*/
                    .body(resource);
                    //.body(file);
        } catch(Exception e){
            e.printStackTrace();
            logger.error("Erreur de récupération du fichier, inexistant ou code inexistant");
            throw new MyAppException("Erreur de récupération du fichier, inexistant ou code inexistant");
        }

//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        response.setContentType(contentType);
//
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + docFile.getOriginalFilename() + "\""));
//
//
//        response.setContentLength((int) docFile.getSize());
//
//        InputStream inputStream = new ByteArrayInputStream(docFile.getBytes());
//
//        FileCopyUtils.copy(inputStream, response.getOutputStream());
        //throw new MyAppException("Erreur de récupération du fichier, inexistant ou code inexistant");
    }

    @PostMapping("/{docId}/serve")
    @ResponseBody
    public DocumentDto handleFileUpload(@PathVariable("businessKey") String businessKey,
                                        @PathVariable("docId")String docId,
                                        //@RequestParam(value = "file",required = false) MultipartFile file
                                        @RequestBody MultipartFile file
    ) {
//        pdfDocService.setImageInPDF(businessKey, docId);
        Optional<CompteDocument> doc=documentDao.findById(docId);
        DocumentDto documentDto;
        if(doc.isPresent()){
            CompteDocument document=doc.get();
            document.setDocumentstatus(DocumentStatus.EN_TRAITEMENT);
            documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc.get());
            logger.info("Uploading doc for : "+businessKey+", "+documentDto+",");

            //DocumentDto uploadDocDto = storageService.store(businessKey, file, docId, documentDto);
            DocumentDto uploadDocDto = storageService.storeDocument(businessKey, file, docId, documentDto);

            try {
                utils.compteCanBeInTraitement(businessKey);

            }catch (Exception e){
                e.printStackTrace();
            }
            // Ajout de log: document chargé
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.DOCUMENT_CHARGE+" ("+document.getName()+")",
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.ETAPE_CHARGER_LES_DOCUMENTS);
            return uploadDocDto;
        }
        throw new MyAppException("Le document "+docId+" n'existe pas");
    }


    @PostMapping("/signature")
    @ResponseBody
    public StatusDto handleSignatureUpload(@PathVariable("businessKey") String businessKey,
                                           @RequestParam(value = "file",required = false) MultipartFile file )
    {

        StatusDto statusReponse = storageService.storeSignature(businessKey,file);
        return statusReponse;
    }

    @GetMapping("/{docId}")
    @ResponseBody
    public DocumentDto getDocByCodeForBk(@PathVariable("businessKey") String businessKey,
                                         @PathVariable("docId")String docId){

        pdfDocService.contratPdfConverter(businessKey,docId);

        return storageService.findById(docId);
    }

    @PutMapping("/{docId}")
    @ResponseBody
    public DocumentDto updateDocByIdForBk(@PathVariable("businessKey") String businessKey,
                                          @PathVariable("docId")String docId,
                                          @ModelAttribute DocumentDto dossierDocumentDto){

        DocumentDto resultats = storageService.store(businessKey,null, docId,dossierDocumentDto);


        return resultats;
    }

    @DeleteMapping("/{docId}")
    @ResponseBody
    public StatusDto deleteDocByCodeForBk(@PathVariable("businessKey") String businessKey,
                                          @PathVariable("docId")String docId){
        return storageService.deleteDocId(businessKey, docId);
    }

    @PostMapping("/missingDocs")
    @ResponseBody
    public DocumentDto requestMissingDocument(@PathVariable("businessKey") String businessKey,
                                              @RequestBody DocumentDto doc){
        doc.setBusinessKey(businessKey);
        doc.setDocumentstatus(DocumentStatus.MANQUANT);
        CompteDocument document = ModelMapper.convertDocumentDtoToCompteDocument(doc);
        document=documentDao.save(document);
        return ModelMapper.convertCompteDocumentToDocumentDto(document);
    }

    //------------------------------------------------------------------------------------------------
    @PostMapping("/{docId}")
    @ResponseBody
    public DocumentDto updateDocMetaData(@PathVariable("businessKey") String businessKey,
                                         @PathVariable("docId")String docId,
                                         @RequestBody(required = true) DocumentDto document ){
        if(document.getBusinessKey()==null) document.setBusinessKey(businessKey);
        CompteDocument doc= ModelMapper.convertDocumentDtoToCompteDocument(document);
        doc= documentDao.save(doc);

        // Ajout de log: Document traité
        logInfoService.addLog(
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_ENREGISTREMENT_DES_DONNEES.DOCUMENT_TRAITE+" ("+document.getName()+")",
                businessKey,
                LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_ENREGISTREMENT_DES_DONNEES.ETAPE_ENREGISTREMENT_DES_DONNEES);

        if(doc.getDescription()=="Document de la CIP"){
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.TRAITEMENT_DU_DOCUMENT,
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP);

        }
        if(doc.getDescription()=="Document de la CIP du conjoint"){
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.TRAITEMENT_DU_DOCUMENT_CONJOINT,
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_VERIFICATION_CIP.ETAPE_VERIFICATION_CIP_CONJOINT);

        }

        return ModelMapper.convertCompteDocumentToDocumentDto(doc);
    }

    @GetMapping("/missing/{docId}")
    @ResponseBody
    public DocumentDto updateDocMetaData(@PathVariable("businessKey") String businessKey,
                                         @PathVariable("docId")String docId) {
        Optional<CompteDocument> document=   documentDao.findById(docId);
        if(document.isPresent()){
            return  ModelMapper.convertCompteDocumentToDocumentDto(document.get());
        }
        return null;
    }

//    @GetMapping("/{docId}/{businessKey}")
//    @ResponseBody
//    public String conertToPdf(@PathVariable("businessKey") String businessKey,
//                                        @PathVariable("docId")String docId
//
//    ) {
//        storageService.
//        Optional<CompteDocument> doc=documentDao.findById(docId);
//        DocumentDto documentDto;
//        if(doc.isPresent()){
//
////            DocumentDto uploadDocDto = storageService.store(businessKey, file, docId, documentDto);
//
//         pdfDocService.contratPdfConverter(businessKey,docId);
//
//        }
//        throw new MyAppException("Le document "+docId+" n'existe pas");
//    }

    @GetMapping("/{docId}/convert")
    @ResponseBody
    public void convert(@PathVariable("businessKey") String businessKey, @PathVariable("docId")String docId){
                    try{
                        pdfDocService.contratPdfConverter(businessKey,docId);

                    }catch (Exception e){

                    }

//     return "fait";
    }

    @PostMapping("/essai")
    @ResponseBody
    public void postVersServeur(@PathVariable("businessKey") String businessKey){
        try{
//            System.out.println("debut  postDocForServer  ");
//                    Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("http://13.80.245.219/index.php/api/upload/sign/files")
//                .field("pdf", new File("C:\\DEMATER\\AppDM\\2021\\JULY\\AA059\\CONFIRMATION_AA059_Nipre4_signatureClient.pdf"))
//                .field("businesskey", businessKey)
//                .asString();
//
//
//        System.out.println("fin  postDocForServer  "+response.getBody());
//            pdfDocService.contratPdfConverter(businessKey,docId);
            pdfDocService.postDocForServer();

        }catch (Exception e){

        }

//     return "fait";
    }

}
