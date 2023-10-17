package africa.box.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class CompteSignatureDTO implements Serializable {
    private String businessKey;
    private String signatureBase64;

}
