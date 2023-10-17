package africa.box.dm.db.domain.filestorage;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.MyAppConfig;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DocumentStatus;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.service.MyAppException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Component
public class FileSystemStorage implements FileStorage {

    @Autowired
    private MyAppConfig appConfig;

    @Autowired
    private CompteDocumentDao compteDocumentDao;

    @Override
    public void save(String businessKey, MultipartFile file, String filename, String docId, DocumentDto documentDto) {
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
                 this.processLocalUpload(businessKey, filename,file, upBasePath,docId);
            case BusinessConstants.UPLOAD_PROVIDERS.S3:
                break;
            case BusinessConstants.UPLOAD_PROVIDERS.AZURE:
                break;
            default: throw new MyAppException("Cannot deal with provider type "+upProvider);
        }
    }

    @Override
    public Optional<Resource> get(String businessKey, String docId) {
        return Optional.of(this.compteDocumentDao.findById(docId))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .map(cd -> {
            return getResource(businessKey, cd.getCreatedAt(),
                    cd.getDocPath());
        });

    }


    private Resource getResource(String businessKey, Date d, String docPath){

        String upProvider = appConfig.getUploadProvider();
//        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upProvider)){
            upProvider = BusinessConstants.UPLOAD_PROVIDERS.LOCAL;
        }

        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String chemin= appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey + File.separator + docPath;

        switch(upProvider){
            case "local":
                return new FileSystemResource(new File(chemin));
            default:
                return  null;
        }
    }


    private void processLocalUpload(String businessKey,String fileName,MultipartFile file,
                                           String upBasePath,String docId) {
        if(file!=null) {
            //String fileName = this.resolveFileName(file, documentDto.getDocCode(), businessKey);
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

        }
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


    @Override
    public void delete(String businessKey, CompteDocument doc) {
        Date d = doc.getCreatedAt();

        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String chemin = appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth() +
                File.separator + businessKey + File.separator + doc.getDocPath();

//            String chemin_=appConfig.getUploadBasePath() + File.separator + doc.getDocPath();
        File f = new File(chemin);
        f.delete();
    }
}
