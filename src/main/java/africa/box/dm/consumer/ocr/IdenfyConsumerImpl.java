package africa.box.dm.consumer.ocr;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IdenfyConsumerImpl implements IdenfyConsumer{
    private final static String API_KEY = "HGjUKeptSy0";
    private final static  String API_SECRET = "x0alkLtioJqiKATeKO8B";
    private final static String API_HEADER_KEY = "Authorization";
    private static String API_BASE_URL = "https://ivs.idenfy.com/api/v2";



    private HttpClient httpClient;

    public IdenfyConsumerImpl(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    @Override
    public Map<String, String> generateToken(String clientId) throws Exception {
        Map<String, String > res = new HashMap<>();

        String encodedCred = generateBasic();
        URIBuilder builder = new URIBuilder(API_BASE_URL+"/token");
        URI uri  = builder.build();

        HttpPost request = new HttpPost(uri);
        request.setHeader(API_HEADER_KEY, "Basic "+encodedCred);
        Map<String, Object> body = new HashMap<>();
        body.put("clientId", clientId);
        Gson gson = new Gson();
        StringEntity bodyJson = new StringEntity(gson.toJson(body));

        System.out.println("##### TOKEN REQUEST  BODY");
        System.out.println(gson.toJson(body));
        System.out.println("##### TOKEN REQUEST  BODY");

        request.setEntity(bodyJson);

        HttpResponse httpResponse = httpClient.execute(request);


        if (httpResponse.getStatusLine().getStatusCode() >=200 &&
                httpResponse.getStatusLine().getStatusCode() < 300){
            HttpEntity responseEntity = httpResponse.getEntity();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(responseEntity.getContent())
            );
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine())!=null ){
                buffer.append(line);
            }
            Type listType = new TypeToken<List<HashMap<String, Object>>>(){}.getType();
            Map<String, Object> responseMap = gson.fromJson(buffer.toString(), HashMap.class);

            System.out.println(buffer.toString());

            res.put("authToken", responseMap.get("authToken").toString());
            res.put("scanRef",responseMap.get("scanRef").toString());


        }else{
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            throw new IdenfyErrorExeption();
        }

        return res;
    }

    @Override
    public Map<String, Object> processVerification(IdenfyVerificationDTO dto) throws  Exception {
        Map<String, Object > res = new HashMap<>();
        String encodedCred = generateBasic();

        URIBuilder builder = new URIBuilder(API_BASE_URL+"/process");
        URI uri  = builder.build();

        HttpPost request = new HttpPost(uri);
        request.setHeader(API_HEADER_KEY, "Basic "+encodedCred);

        Gson gson = new Gson();
        StringEntity bodyJson = new StringEntity(gson.toJson(dto));
        request.setEntity(bodyJson);

        System.out.println(gson.toJson(dto));
        HttpResponse httpResponse = httpClient.execute(request);


        if (httpResponse.getStatusLine().getStatusCode() == 200 ){

            res.put("success",true);

        }else{
            HttpEntity responseEntity = httpResponse.getEntity();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(responseEntity.getContent())
            );
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine())!=null ){
                buffer.append(line);
            }

            System.out.println("## Error Body");
            System.out.println(buffer.toString());

            Map<String, Object> responseMap = gson.fromJson(buffer.toString(), HashMap.class);

            res.put("success", false);
            res.put("message", responseMap.get("message"));
            res.put("identifier", responseMap.get("identifier"));
        }

        return res;
    }

    @Override
    public String getStatus(String scanRef) throws Exception{
        String status;
        Map<String, String > res = new HashMap<>();
        String encodedCred = generateBasic();
        URIBuilder builder = new URIBuilder(API_BASE_URL+"/status");
        URI uri  = builder.build();

        HttpPost request = new HttpPost(uri);
        request.setHeader(API_HEADER_KEY, "Basic "+encodedCred);
        Map<String, Object> body = new HashMap<>();
        body.put("scanRef", scanRef);
        Gson gson = new Gson();
        StringEntity bodyJson = new StringEntity(gson.toJson(body));
        request.setEntity(bodyJson);

        System.out.println(gson.toJson(body));

        HttpResponse httpResponse = httpClient.execute(request);


        if (httpResponse.getStatusLine().getStatusCode() >= 200 &&
                httpResponse.getStatusLine().getStatusCode() < 300){
            HttpEntity responseEntity = httpResponse.getEntity();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(responseEntity.getContent())
            );
            StringBuffer buffer = new StringBuffer();

            String line = null;
            while ((line = br.readLine())!=null ){
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            Map<String, Object> responseMap = gson.fromJson(buffer.toString(), HashMap.class);


            status =  responseMap.get("status").toString();

        }else{
            throw new IdenfyErrorExeption();
        }

        return status;
    }

    @Override
    public Map<String, Object> getVerification(String scanRef) throws Exception{
        Map<String, Object > data = new HashMap<>();
        String encodedCred = generateBasic();

        URIBuilder builder = new URIBuilder(API_BASE_URL+ "/jdd");
        URI uri  = builder.build();

        HttpPost request = new HttpPost(uri);
        request.setHeader(API_HEADER_KEY, "Basic "+encodedCred);
        Map<String, Object> body = new HashMap<>();
        body.put("scanRef", scanRef);
        Gson gson = new Gson();
        StringEntity bodyJson = new StringEntity(gson.toJson(body));
        request.setEntity(bodyJson);

        HttpResponse httpResponse = httpClient.execute(request);


        if (httpResponse.getStatusLine().getStatusCode() >= 200 &&
                httpResponse.getStatusLine().getStatusCode() < 300){
            HttpEntity responseEntity = httpResponse.getEntity();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(responseEntity.getContent())
            );
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine())!=null ){
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            data = gson.fromJson(buffer.toString(), HashMap.class);



        }else{
            throw new IdenfyErrorExeption();
        }
        return data;
    }

    @Override
    public Map<String, Object> getFullStatus(String scanRef) throws Exception {
        Map<String, Object > data = new HashMap<>();
        String encodedCred = generateBasic();

        URIBuilder builder = new URIBuilder(API_BASE_URL+"/full-status");
        URI uri  = builder.build();

        HttpPost request = new HttpPost(uri);
        request.setHeader(API_HEADER_KEY, "Basic "+encodedCred);
        Map<String, Object> body = new HashMap<>();
        body.put("scanRef", scanRef);
        Gson gson = new Gson();
        StringEntity bodyJson = new StringEntity(gson.toJson(body));
        request.setEntity(bodyJson);

        HttpResponse httpResponse = httpClient.execute(request);


        if (httpResponse.getStatusLine().getStatusCode() >= 200 &&
                httpResponse.getStatusLine().getStatusCode() < 300){
            HttpEntity responseEntity = httpResponse.getEntity();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(responseEntity.getContent())
            );
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine())!=null ){
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            data = gson.fromJson(buffer.toString(), HashMap.class);



        }else{
            throw new IdenfyErrorExeption();
        }
        return data;
    }

    private String generateBasic(){
        String cred = API_KEY + ":"+API_SECRET;
        return Base64.getEncoder().encodeToString(cred.getBytes());
    }
}
