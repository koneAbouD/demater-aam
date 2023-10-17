package africa.box.dm.consumer.peps;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class DataSpikeConsumer {
    private final Logger Log = LoggerFactory.getLogger(DataSpikeConsumer.class.getName());
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String API_HEADER = "ds-api-token";
    //@Value("${dataspike.api-token}")
    //private static String API_TOKEN = "FY0eLVkpyXhMTSXpAhBCDay/76e8XpMYlPwHeMSdAZO3BuxNs2xQeZ9IZu9C0UEz0BVRR09Wpa89FiuXTj/5RA==";
    private final static String BASE_API_URI = "https://api.dataspike.io/api/v2";
    private final static  String SANDBOX_API = "https://sandboxapi.dataspike.io/api/v2";
    private final static String[] linkName = {"DBpedia","Media, Media Crimes", "Interpol Red Notices", "Interpol Yellow Notices",
                "Wikidata", "Social", "Wikipedia", "PACER", "OFAC", "UK HM Treasury", "SECO",
                "DFAT", "OSFI", "RePET", "NZ Police Watchlist", "BIS", "Tracking terrorism", "EU Sanctions Map", "United Nations",
                "EU Financial Sanctions", "Panama Papers", "Paradise Papers", "Offshore Leaks", "Bahamas Leaks",
                "Ari Registry Sanctions", "Ari Registry", "US Trade CSL", "Ukraine NABC", "Ukraine NSDC", "Swiss SECO",
                "Belgian Financial Sanctions", "French Freezing of Assets", "Australian CSL", "Japan Economic CSL", "Kazakh Terror Financing List",
                "Kyrgyz National List", "Ukraine SFMS", "Israel Terrorists List", "US BIS Denied Persons", "South African CSL", "Rosfinmonitoring",
                "Canadian Terrorist Entities", "Polish CSL", "Singapore CSL"};

    private HttpClient httpClient;
    private Gson gson;

    private Environment env;

    DataSpikeConsumer(HttpClient httpClient, Gson gson, Environment env){
        this.httpClient = httpClient;
        this.gson = gson;
        this.env = env;
    }

    public Map<String, Object> searchPerson(String name, LocalDate birthDay, String country){
        String API_TOKEN  = env.getProperty("dataspike.api-token");
        Map<String, Object> responseBody = new HashMap<>();
        try {
            URIBuilder builder = new URIBuilder(BASE_API_URI+ "/sealed/universal/search");
            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);
            request.setHeader(API_HEADER, API_TOKEN);
            Map<String, Object> body = new HashMap<>();
            body.put("name", name);
//            body.put("category", PepsCategory.Person);
//            body.put("tags", PepsTags.values());
//            body.put("sources", linkName);
            StringEntity bodyJson = new StringEntity(gson.toJson(body));

            request.setEntity(bodyJson);
            System.out.println(gson.toJson(body));
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200){
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent())
                );
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;
                while ((line = br.readLine())!=null){
                    stringBuffer.append(line);
                }
                if (stringBuffer.length() > 0){
                    responseBody = gson.fromJson(stringBuffer.toString(), HashMap.class);
                }
            }else if (response.getStatusLine().getStatusCode() == 402){
                Log.warn("PEPS : {} - Not enough money on billing account", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else if (response.getStatusLine().getStatusCode() == 400){
                Log.warn("PEPS : {} - Wrong request body.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else if (response.getStatusLine().getStatusCode() == 403){
                Log.warn("PEPS : {} - Authentication or additional permissions requires for this request.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else{
                Log.warn("PEPS : {} - Some error happened on server side.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            Log.warn("PEPS {}",ex.getMessage());
            throw new RuntimeException("Service Temporairement Indisponible");
        }

        return responseBody;
    }


    public Map<String, Object> searchPersonInSanbox(String name, LocalDate birthDay, String country){
        String API_TOKEN = env.getProperty("dataspike.api-token");
        Map<String, Object> responseBody = new HashMap<>();
        try {
            URIBuilder builder = new URIBuilder(SANDBOX_API+ "/sealed/universal/search");
            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);
            request.setHeader(API_HEADER, API_TOKEN);
            Map<String, Object> body = new HashMap<>();
            body.put("name", name);
//            body.put("category", PepsCategory.Person);
//            body.put("tags", PepsTags.values());
//            body.put("sources", linkName);

            StringEntity bodyJson = new StringEntity(gson.toJson(body));

            request.setEntity(bodyJson);

            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200){
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent())
                );
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;
                while ((line = br.readLine())!=null){
                    stringBuffer.append(line);
                }
                if (stringBuffer.length() > 0){
                    responseBody = gson.fromJson(stringBuffer.toString(), HashMap.class);
                }
            }else if (response.getStatusLine().getStatusCode() == 402){
                Log.warn("PEPS : {} - Not enough money on billing account", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else if (response.getStatusLine().getStatusCode() == 400){
                Log.warn("PEPS : {} - Wrong request body.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else if (response.getStatusLine().getStatusCode() == 403){
                Log.warn("PEPS : {} - Authentication or additional permissions requires for this request.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }else{
                Log.warn("PEPS : {} - Some error happened on server side.", response.getStatusLine().getStatusCode());
                throw new RuntimeException("Service Temporairement Indisponible");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            Log.warn("PEPS {}",ex.getMessage());
            throw new RuntimeException("Service Temporairement Indisponible");
        }

        return responseBody;
    }

}
