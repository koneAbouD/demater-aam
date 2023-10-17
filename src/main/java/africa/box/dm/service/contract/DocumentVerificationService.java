package africa.box.dm.service.contract;

import africa.box.dm.consumer.ocr.IdenfyVerificationDTO;
import africa.box.dm.db.entities.Compte;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface DocumentVerificationService {
    Object ocrFilePredication(MultipartFile file) throws IOException;

    Object processDocumentVerification(IdenfyVerificationDTO dto) throws Exception;
    Map<String, String> generateIdenfyAuthToken() throws Exception;
    Optional<Map<String, Object>> getVerficationStatus(String buinessKey) throws Exception;
    Map<String, String> process(IdenfyVerificationDTO dto, Compte compte) throws Exception;
    //Map<String, Object> process(String businessKey);
    Map<String, Object> process(Compte compte);
}
