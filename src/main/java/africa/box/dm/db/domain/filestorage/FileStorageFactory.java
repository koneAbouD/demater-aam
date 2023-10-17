package africa.box.dm.db.domain.filestorage;

import africa.box.dm.utils.SpringContext;

public class FileStorageFactory {

    private FileStorageFactory(){}

    public static FileStorage getInstance(FileStorageType type) {

        if (FileStorageType.DB.equals(type)) {
            return (FileDatabaseStorage) SpringContext.getBean(FileDatabaseStorage.class);
        }else if (FileStorageType.FS.equals(type)) {
            return (FileSystemStorage) SpringContext.getBean(FileSystemStorage.class);
        }else {
            return null;
        }
    }
}
