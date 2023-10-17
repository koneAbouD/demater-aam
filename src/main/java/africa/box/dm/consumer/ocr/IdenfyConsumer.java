package africa.box.dm.consumer.ocr;

import java.io.IOException;
import java.util.Map;

public interface IdenfyConsumer {

    Map<String, String> generateToken(String clientId) throws IOException, Exception;
    Map<String, Object> processVerification(IdenfyVerificationDTO dto) throws Exception;
    String getStatus(String scanRef) throws Exception;
    Map<String,Object> getFullStatus(String scanRef) throws Exception;
    Map<String, Object> getVerification(String scanRef) throws Exception;
}
