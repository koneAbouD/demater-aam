package africa.box.dm.consumer.ocr;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegularConsumerImpl implements RegularConsumer{

    private Logger LOG = LoggerFactory.getLogger(RegularConsumerImpl.class.getName());

    private final static String REGULAR_LICENSE = "regula.license";
    private static final String REGULA_BASE_API ="https://test-api.regulaforensics.com/api";
    private HttpClient httpClient;

    private Gson gson;
    private Environment env;

    public RegularConsumerImpl(HttpClient httpClient, Gson gson, Environment env){
        this.httpClient = httpClient;
        this.gson = gson;
        this.env = env;
    }

    @Override
    public Map<String, Object> process(String[] base64Images, String tag) {
        Map<String, Object> result = new HashMap<>();
       try{
           URIBuilder builder = new URIBuilder(REGULA_BASE_API + "/process");
           URI uri = builder.build();

           HttpPost request = new HttpPost(uri);
           request.setHeader("Content-Type", "application/json");
           String requestBody = RegularRequestBuilder.builder()
                   .base64Images(base64Images)
                   .licenseKey(env.getProperty("regular.license"))
                   .tag(tag)
                   .build()
                   .getRequest();
           StringEntity entity = new StringEntity(requestBody);
           request.setEntity(entity);
           HttpResponse response = httpClient.execute(request);

           int httpStatus = response.getStatusLine().getStatusCode();
           if( httpStatus== 200){
               BufferedReader br = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent())
               );
               StringBuffer buffer = new StringBuffer();
               String line = null;

               while ((line = br.readLine() )!= null){
                    buffer.append(line);
               }

               if (buffer.length() > 0){
                   result = gson.fromJson(buffer.toString(), HashMap.class);
               }
           }else if (httpStatus == 400){
               LOG.warn("[Regula] Status: {} - {}", httpStatus, "bad request check your input data");
               throw new IdenfyBadRequestException("bad request check your input data");

           }else{
               LOG.warn("[Regula] Status: {} - {}", httpStatus, "Bad License key");
               throw  new RegulaLicenseNotFoundException();
           }
       return result;
       }catch (Exception ex){
           ex.printStackTrace();
            throw new RuntimeException("Service temporairement indisponible");
       }
    }


    private static String getLicenseBase64(){
       try{
           Path licensePath = Paths.get(new ClassPathResource(REGULAR_LICENSE).getPath());
           byte[] bytes =  Files.readAllBytes(licensePath);
           return Base64.getEncoder().encodeToString(bytes);
       }catch (Exception ex){
            throw new RegulaLicenseNotFoundException();
       }
    }


}
