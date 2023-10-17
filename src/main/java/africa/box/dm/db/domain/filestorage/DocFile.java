package africa.box.dm.db.domain.filestorage;

import com.itextpdf.styledxmlparser.jsoup.helper.Validate;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "doc_file")
@Data
public class DocFile implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String businessKey;

    @NotNull
    private String docId;

    private String name;

    @NotNull
    private String filename;

    @NotNull
    private String type;

    @NotNull
    @Lob
    private byte[] content;

    private Instant createdDate;

    public DocFile(){}

    private DocFile(byte[] content, String filename, String type, String businessKey, String docId,
                    String name){
        this.businessKey = businessKey;
        this.content = content;
        this.docId = docId;
        this.filename = filename;
        this.type = type;
        this.name = name;
        createdDate = Instant.now();
    }

    public static DocFile create(MultipartFile file, String filename, String businessKey, String docId,
                                 String name) throws Exception{
        Validate.notNull(businessKey, "businessKey is required");
        Validate.notNull(docId, "docId is required");
        return new DocFile(file.getBytes(), filename,
                file.getContentType() ,businessKey, docId, name);
    }


    public String getExtension() {
        String[] array = filename.split("\\.");
        return array[array.length -1];
    }

    @Override
    public String toString() {
        return "DocFile{" +
                "businessKey='" + businessKey + '\'' +
                ", docId='" + docId + '\'' +
                ", filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
