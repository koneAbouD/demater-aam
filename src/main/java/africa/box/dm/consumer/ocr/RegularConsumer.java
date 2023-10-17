package africa.box.dm.consumer.ocr;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface RegularConsumer {
    Map<String, Object> process(String[] base64Images, String tag);
}
