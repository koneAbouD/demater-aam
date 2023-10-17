package africa.box.dm.db.domain.filestorage;

public class FileStorageNotFoundException extends RuntimeException {

    public FileStorageNotFoundException(){
        super("File Storage not found");
    }
}
