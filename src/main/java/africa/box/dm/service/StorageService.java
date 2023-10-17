package africa.box.dm.service;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.config.MyAppConfig;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.DocFileDao;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.domain.filestorage.DocFile;
import africa.box.dm.db.entities.DocumentStatus;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.db.domain.filestorage.FileStorage;
import africa.box.dm.db.domain.filestorage.FileStorageFactory;
import africa.box.dm.db.domain.filestorage.FileStorageType;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    final CompteDocumentDao dao;

    final
    MyAppConfig appConfig;

    @Autowired
    LogInfoService logInfoService;

    @Autowired
    private DocFileDao docFileDao;

    public StorageService(CompteDocumentDao dao, MyAppConfig appConfig) {
        this.dao = dao;
        this.appConfig = appConfig;
    }

    public StatusDto storeSignature(String businessKey,MultipartFile file){
        String upProvider = appConfig.getUploadProvider();
        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upProvider)){
            upProvider = BusinessConstants.UPLOAD_PROVIDERS.LOCAL;
        }
        switch(upProvider){
            case BusinessConstants.UPLOAD_PROVIDERS.LOCAL:
                if(StringUtils.isEmpty(upBasePath)){
                    upBasePath = System.getProperty("java.io.tmpdir");
                }
                System.out.println(upBasePath);
                return this.processUploadForSignature(businessKey,upBasePath,file );


            default: throw new MyAppException("Cannot deal with provider type "+upProvider);
        }

//        return StatusDto.ofSuccess("Mise à jour bien effectué");
    }

    public DocumentDto store(String businessKey, MultipartFile file, String docId, DocumentDto documentDto) {
         String upProvider = appConfig.getUploadProvider();
         String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upProvider)){
            upProvider = BusinessConstants.UPLOAD_PROVIDERS.LOCAL;
        }

        switch(upProvider){
            case BusinessConstants.UPLOAD_PROVIDERS.LOCAL:
                if(StringUtils.isEmpty(upBasePath)){
                    upBasePath = System.getProperty("java.io.tmpdir");
                }
                return this.processLocalUpload(businessKey, documentDto,file, upBasePath,docId);
            case BusinessConstants.UPLOAD_PROVIDERS.S3:

                return this.processS3Upload(businessKey, documentDto.getDocCode(), file);
            case BusinessConstants.UPLOAD_PROVIDERS.AZURE:

                return this.processAzureUpload(businessKey, documentDto.getDocCode(), file);

            default: throw new MyAppException("Cannot deal with provider type "+upProvider);
        }

    }


    /**
     * Function that save new file
     * @param businessKey
     * @param file
     * @param docId
     * @param documentDto
     * @return
     */
    public DocumentDto storeDocument(String businessKey, MultipartFile file, String docId, DocumentDto documentDto){
        FileStorage storage = FileStorageFactory.getInstance(FileStorageType.valueOf("DB"));
        String fileName = this.resolveFileName(file, documentDto.getDocCode(), businessKey);
        storage.save(businessKey, file,fileName, docId, documentDto);
        return this.saveLoanFileDoc(businessKey, documentDto,
                fileName, docId, file.getContentType());
    }

    public Optional<Resource> getDocument(String businessKey, String docId) {
        FileStorage storage = FileStorageFactory.getInstance(FileStorageType.valueOf("DB"));

        return storage.get(businessKey, docId);
       // return docFileDao.findOneByDocIdAndBusinessKey(docId, businessKey);
        //DocFile docFile = null;
//        if (mayBeDocFile.isPresent()) {
//            docFile = mayBeDocFile.get();
//            MultipartFileConverter mConv =
//                    MultipartFileConverter.fromBytes(
//                            docFile.getContent(), null,docFile.getType()
//                    );
//        }
    }


    @Transactional
    public DocumentDto storeInDatabase(String businessKey, MultipartFile file, String docId, DocumentDto documentDto) {
        Optional<DocFile> mayBeDocFile = docFileDao.findOneByDocIdAndBusinessKey(docId, businessKey);
        DocFile docFile = null;

        try {
            if (mayBeDocFile.isPresent()) {

                docFile = mayBeDocFile.get();
                docFile.setFilename(documentDto.getDocPath());
                docFile.setType(file.getContentType());
                docFile.setContent(file.getBytes());

            }else {

                docFile = DocFile.create(file, documentDto.getDocPath(),documentDto.getBusinessKey(),docId, documentDto.getName());

            }

            docFileDao.save(docFile);
            return this.saveLoanFileDoc(businessKey, documentDto,
                    file.getOriginalFilename(), docId, file.getContentType());

        }catch (Exception ex) {
            throw new RuntimeException("Erreur de tratement du fochier");
        }


    }



    @Transactional
    public Optional<DocFile> loadFileFromDatabase(String businessKey, String docId) {
        return docFileDao.findOneByDocIdAndBusinessKey(docId, businessKey);
        //DocFile docFile = null;
//        if (mayBeDocFile.isPresent()) {
//            docFile = mayBeDocFile.get();
//            MultipartFileConverter mConv =
//                    MultipartFileConverter.fromBytes(
//                            docFile.getContent(), null,docFile.getType()
//                    );
//        }
    }


    private DocumentDto processAzureUpload(String businessKey, String docCode, MultipartFile file) {
        //TODO implement s3 upload and get path,
        // call newLoanFileDoc
        //return null;

        throw new MyAppException("Azure Not impl yet.");
    }


    //Signature image upload
    private StatusDto processUploadForSignature(String businessKey, String upBasePath, MultipartFile file) {
        if(file!=null){
            String fileName = "signature_client" + businessKey + ".png";
            String contentType = file.getContentType();
            LocalDate localDate = LocalDate.now() ;
            try {
                String path = upBasePath + File.separator + localDate.getYear() +
                        File.separator + localDate.getMonth()+
                        File.separator + businessKey;
                File dir = new File(path);

                //Create dir if not exist
                boolean bool = dir.mkdirs();
                if(bool){
                    System.out.println("Directory created successfully");
                }else{
                    //System.out.println("Sorry couldnt create specified directory");
                }
                // Save File
                file.transferTo(new File( path + File.separator + fileName));

            } catch (IOException e) {
                e.printStackTrace();
                throw new MyAppException(e);
            }
            return StatusDto.ofSuccess("Mise à jour bien effectué");


        }

        throw new MyAppException("erreur uploading signature.");
    }


    private DocumentDto processS3Upload(String businessKey, String docCode, MultipartFile file) {


        throw new MyAppException("S3 Not impl yet.");
    }



    private DocumentDto processLocalUpload(String businessKey,DocumentDto documentDto,MultipartFile file,
                                                  String upBasePath,String docId) {
        if(file!=null) {
            String fileName = this.resolveFileName(file, documentDto.getDocCode(), businessKey);
            String contentType = file.getContentType();
            LocalDate localDate = LocalDate.now() ;
            try {
                String path = upBasePath + File.separator + localDate.getYear() +
                        File.separator + localDate.getMonth()+
                        File.separator + businessKey;
                File dir = new File(path);

                //Create dir if not exist
                boolean bool = dir.mkdirs();
                if(bool){
                    System.out.println("Directory created successfully");
                }else{
                    //System.out.println("Sorry couldnt create specified directory");
                }

                // Save File
                file.transferTo(new File( path + File.separator + fileName));

            } catch (IOException e) {
                e.printStackTrace();
                throw new MyAppException(e);
            }
            return this.saveLoanFileDoc(businessKey, documentDto, fileName, docId, contentType);

//            String fileName = this.resolveFileName(file, documentDto.getDocCode(), businessKey);
//            String contentType = file.getContentType();
//            try {
//                file.transferTo(new File(upBasePath + File.separator + fileName));
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new MyAppException(e);
//            }
//            return this.saveLoanFileDoc(businessKey, documentDto, fileName, docId, contentType);
        } else {
            // no file, could be an update.
            if(StringUtils.isNotEmpty(docId)){
                this.updateMetadata(docId, documentDto);
                return  this.findById(docId);
            } else {
                throw new MyAppException("No file and no doc id. unable to determine changes.");
            }
        }
    }

    public DocumentDto updateMetadata(String docId, DocumentDto dossierDocumentDto) {
        CompteDocument doc=ModelMapper.convertDocumentDtoToCompteDocument(dossierDocumentDto);
        doc.setUpdatedAt(new Date());
        CompteDocument newDoc = this.dao.save(doc);
        return ModelMapper.convertCompteDocumentToDocumentDto(newDoc);
    }

    private DocumentDto saveLoanFileDoc(String businessKey, DocumentDto documentDto,
                                               String fileName, String docId,
                                               String contentType) {
        CompteDocument newDoc = ModelMapper.convertDocumentDtoToCompteDocument(documentDto);
        if(!StringUtils.isEmpty(docId)){
            logger.info("Newloanfile: "+businessKey+", "+documentDto.getDocCode()+", "+fileName+", "+documentDto.getDocMeta()+", "+docId);
            newDoc.setCreatedAt(new Date());
            newDoc.setDocPath(fileName);
            newDoc.setContentType(contentType);
            newDoc = this.dao.save(newDoc);
        } else {
            throw  new MyAppException("Ce fichier est inexista nt");
        }
        return  ModelMapper.convertCompteDocumentToDocumentDto(newDoc);
    }


    private String resolveFileName(MultipartFile file, String docCode, String businessKey) {
        String suffix = RandomStringUtils.random(6, true, true);
        String ext = appConfig.getDefaultUploadExtension();
        if(StringUtils.isNotEmpty(file.getOriginalFilename())) {
            ext = FilenameUtils.getExtension(file.getOriginalFilename());
        }else if(StringUtils.isEmpty(file.getName())) {
            ext = FilenameUtils.getExtension(file.getName());
        } else {
            ext = "pdf";
        }

        if (ext.equals("")){
            if (file.getContentType()!=null){
                String contentType =file.getContentType();
                String[] parts = contentType.split("/");
                ext = parts[1];
            }
        }
        return docCode+"_"+businessKey+"_"+suffix+ "."+ext;
    }

    public Resource loadAsResource(String businessKey, String fileId) {
        Optional<CompteDocument> compteDocumentOptional = this.dao.findById(fileId);
        if(!compteDocumentOptional.isPresent()){
            throw new MyAppException("Cannot find file id.");
        }
        String upProvider = appConfig.getUploadProvider();
//        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upProvider)){
            upProvider = BusinessConstants.UPLOAD_PROVIDERS.LOCAL;
        }
        CompteDocument doc= compteDocumentOptional.get();
        Date d = doc.getCreatedAt();

        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String chemin= appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey + File.separator + doc.getDocPath();

        switch(upProvider){
            case "local":
                return new FileSystemResource(new File(chemin));
            default: throw new MyAppException("NO impleted yet: "+upProvider);
        }
    }

    public List<DocumentDto> findFiles(String businessKey) {
        List<CompteDocument> compteDocuments = dao.findByBusinessKey(businessKey);
        List<DocumentDto> dtoList = new ArrayList<>();
        if(compteDocuments!=null && !compteDocuments.isEmpty()){
            dtoList = compteDocuments.stream().map(compteDocument ->
                    ModelMapper.convertCompteDocumentToDocumentDto(compteDocument)).collect(Collectors.toList());
        }
        return dtoList;
    }

    public DocumentDto findByBkAndDocCode(String businessKey, String docCode) {
        List<CompteDocument> docs = this.dao.findByBusinessKeyAndDocCode(businessKey, docCode);
        DocumentDto dto = null;
        if(docs!=null && !docs.isEmpty()){
            CompteDocument extDoc = docs.get(0);
            dto =  ModelMapper.convertCompteDocumentToDocumentDto(extDoc);
        }
        return dto;
    }

    public StatusDto deleteDocId(String businessKey, String docId) {
        Optional<CompteDocument> docOpt = this.dao.findById(docId);
        if(docOpt.isPresent()){
            CompteDocument doc= docOpt.get();


            if (doc.getName().trim().equalsIgnoreCase("Attestation de travail")){

                List<CompteDocument> bulletin = dao.findByName("derniers bulletin de salaire");
                bulletin.get(0).setDocumentstatus(DocumentStatus.MANQUANT);
                CompteDocument bulle = dao.save(bulletin.get(0));
                System.out.println("bulletin___"+bulle.getName()+" "+bulle.getDocumentstatus());

            } else if (doc.getName().trim().equalsIgnoreCase("derniers bulletin de salaire")) {
                List<CompteDocument> attestation = dao.findByName("Attestation de travail");
                attestation.get(0).setDocumentstatus(DocumentStatus.MANQUANT);
                CompteDocument attest = dao.save(attestation.get(0));
                System.out.println("attestation___"+attest.getName()+" "+attest.getDocumentstatus());

            }

            doc.setDocumentstatus(DocumentStatus.MANQUANT);
            FileStorage storage = FileStorageFactory.getInstance(FileStorageType.DB);
            storage.delete(businessKey, doc);
           // Date d = doc.getCreatedAt();

//            // Convert java.util.Date to java.time.LocalDate
//            LocalDate localDate = d.toInstant()
//                    .atZone(ZoneId.systemDefault())
//                    .toLocalDate();
//
//            String chemin = appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
//                    File.separator + localDate.getMonth()+
//                    File.separator + businessKey + File.separator + doc.getDocPath();
//
////            String chemin_=appConfig.getUploadBasePath() + File.separator + doc.getDocPath();
//            File  f=new File(chemin);
//            Boolean delete=f.delete();
            doc.setDocPath(null);
            doc.setDocMeta(null);
            dao.save(doc);

            // Ajout de log: Document supprimé
            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.DOCUMENT_SUPPRIMER+" ("+doc.getName()+")",
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_CHARGER_LES_DOCUMENTS.ETAPE_CHARGER_LES_DOCUMENTS);

        } else {
            throw new MyAppException("Cannot find doc to delete.");
        }
        return StatusDto.ofSuccess("Doc Id: "+docId+", deleted.");
    }

    public DocumentDto findById(String docId) {
        Optional<CompteDocument> docOpt = this.dao.findById(docId);
        if(docOpt.isPresent()){
            CompteDocument doc = docOpt.get();
            return  ModelMapper.convertCompteDocumentToDocumentDto(doc);
        } else {
            throw new MyAppException("Doc with id: "+docId+", not found");
        }
    }

}
