package africa.box.dm.consumer.ocr;

import com.google.gson.Gson;
import lombok.Builder;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class RegularRequestBuilder {

    private String tag;
    String[] base64Images;
    String lisenceKey;

    public String request;

    private RegularRequestBuilder(){}

    public String getRequest() {
        return request;
    }

    @Builder
    public  RegularRequestBuilder(String[] base64Images, String licenseKey, String tag) {
        Map<String, Object> data = new HashMap<>();
        data.put("tag", tag);

        Map<String, Object> processParam = new HashMap<>();
        processParam.put("scenario","FullProcess");
        processParam.put("doublePageSpread",true);
        processParam.put("dateFormat","dd/MM/yyyy");
        processParam.put("measureSystem",0);
        data.put("processParam",processParam);

        List<Map<String, Object>>  listImage = new ArrayList<>();
        for (int index=0; index<base64Images.length; index++){
            HashMap<String, Object> imageItem = new HashMap<>();
            imageItem.put("light", 6);
            imageItem.put("page_idx", 0);
            imageItem.put("light", 6);
            Map<String, Object> imageData = new HashMap<>();
            imageData.put("image", base64Images[index]);
            imageItem.put("ImageData", imageData);
            listImage.add(imageItem);
        }
        data.put("List", listImage);

        Map<String, Object> systemInfo = new HashMap<>();
       data.put("systemInfo", systemInfo);

        request = new Gson().toJson(data);
    }

    private void addImage(List<Map<String, Object>> list, String base64Image){
        if(base64Image != null && !base64Image.isEmpty()){
            HashMap<String, Object> imageItem = new HashMap<>();
            imageItem.put("light", 6);
            imageItem.put("page_idx", 0);
            imageItem.put("light", 6);
            Map<String, Object> imageData = new HashMap<>();
            imageData.put("image", base64Image);
            imageItem.put("ImageData", imageData);
            list.add(imageData);
        }
    }


}
