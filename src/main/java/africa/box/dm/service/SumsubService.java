//package africa.box.dm.service;
//import net.minidev.json.JSONObject;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
//@Service
//public class SumsubService {
//
//    private final StorageService storageService;
//
//    public SumsubService(StorageService storageService) {
//        this.storageService = storageService;
//    }
//
//    @Bean
//    public RestTemplate restTemplate1() {
////        return new RestTemplate(getClientHttpRequestFactory());
//        return new RestTemplate();
//    }
//
////    // +++++++++++ query to take all account +++++++++++
////    public String getAllCompte (JSONObject params){
////        return callSumsubEndPoint(params, externalEndPointConfig.URL_GET_ALL_ACCOUNT, HttpMethod.GET);
////    }
//
//    public String callSumsubEndPoint (JSONObject params,String url, HttpMethod method){
//        System.out.println("==================> url"+url);
//        HttpHeaders headers = new HttpHeaders();
////      headers.add("Authorization", "Bearer "+access_token);
//        headers.add("Content-Type", "application/json");
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Object> entity = new HttpEntity<>(params, headers);
//        String result = restTemplate1().exchange(url, method, entity, String.class).getBody();
//        System.out.println("==================> result "+result);
//        return result;
//    }
//
//}
