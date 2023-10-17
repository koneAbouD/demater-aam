package africa.box.dm.db.domain.filestorage;

import africa.box.dm.db.DocFileDao;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.utils.MultipartFileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Component
@Transactional
public class FileDatabaseStorage implements FileStorage {

    @Autowired
    private DocFileDao docFileDao;

//    public FileDatabaseStorage(DocFileDao docFileDao) {
//        this.docFileDao = docFileDao;
//    }

    @Override
    public void save(String businessKey, MultipartFile file, String filename, String docId, DocumentDto documentDto) {
        Optional<DocFile> mayBeDocFile = docFileDao.findOneByDocIdAndBusinessKey(docId, businessKey);
        DocFile docFile = null;

        try {
            if (mayBeDocFile.isPresent()) {

                docFile = mayBeDocFile.get();
                docFile.setName(documentDto.getName());
                docFile.setFilename(filename);
                docFile.setType(file.getContentType());
                docFile.setContent(file.getBytes());

            }else {

                docFile = DocFile.create(file, filename,
                        documentDto.getBusinessKey(),docId, documentDto.getName());

            }

            docFileDao.save(docFile);

        }catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Resource> get(String businessKey, String docId) {
       return Optional.of(docFileDao.findOneByDocIdAndBusinessKey(docId, businessKey))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .map(docFile -> {
                    return MultipartFileConverter.fromBytes(
                            docFile.getContent(), docFile.getFilename(),
                            docFile.getExtension(), docFile.getType()
                    ).getResource();
        });

    }

    @Override
    public void delete(String businessKey, CompteDocument doc) {
        Optional<DocFile> mayBeDocFile = docFileDao.findOneByDocIdAndBusinessKey(doc.getIdentifiant(), businessKey);

        if (mayBeDocFile.isPresent()){
            DocFile docFile = mayBeDocFile.get();
            docFileDao.delete(docFile);
        }
    }
}
