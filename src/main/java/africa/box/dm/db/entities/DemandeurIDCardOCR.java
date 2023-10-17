package africa.box.dm.db.entities;

import africa.box.dm.consumer.ocr.IdenfyDcumentType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

@Entity
@Table(name = "demandeur_idcard_ocr")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data @NoArgsConstructor
public class DemandeurIDCardOCR implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String businessKey;

    @JsonIgnore
    @Lob
    private byte[] idCardFront;

    @JsonIgnore
    @Lob
    private byte[] idCardBack;

    @JsonIgnore
    @Lob
    private byte[] face;

    @Enumerated(EnumType.STRING)
    private IdenfyDcumentType documentType;

    private String countryCode;

    private String scanRef;

    @Type(type = "jsonb")
    private Map<String, Object> ocrResult;

    @Override
    public String toString() {
        return "DemandeurIDCardOCR{" +
                "id='" + id + '\'' +
                ", idCardFront=" + Arrays.toString(idCardFront) +
                ", idCardBack=" + Arrays.toString(idCardBack) +
                ", face='" + face + '\'' +
                ", ocrResult=" + ocrResult +
                '}';
    }
}
