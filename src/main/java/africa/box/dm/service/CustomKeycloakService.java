package africa.box.dm.service;

import africa.box.dm.config.KeycloakParamConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.representations.account.UserRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class CustomKeycloakService {

    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    @Autowired
    KeycloakParamConfig keycloakParamConfig;

    @Autowired
    private HttpClient httpClient;

    // @Value("${person-service.url}")
//    private String base_url ="http://127.0.0.1:9090/auth/";
// "http://10.80.1.111:9090/auth/";
    private String url = "/admin/realms";
//    private String url = base_url+"admin/realms/BOX.AFRICA";
//    private String keycloakUserListEndpoint=url+"/users";
//    private String keycloakGroupListEndpoint=url+"/groups";
//    private String client_secret="198f450a-28e6-4637-8184-3b4bf7a09fe9";//"b4a49f80-4acc-40d2-b23f-b1935d92732c";


    @Bean
    public RestTemplate restTemplate2() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(25000);
        clientHttpRequestFactory.setReadTimeout(20000);
        return clientHttpRequestFactory;
    }

//    public List<UserRepresentation> getUsers() {
//        ResponseEntity<UserRepresentation[]> response = keycloakRestTemplate.getForEntity(keycloakUserListEndpoint, UserRepresentation[].class);
//        return Arrays.asList(response.getBody());
//    }
//    public List<GroupRepresentation> getGroups() {
//        ResponseEntity<GroupRepresentation[]> response = keycloakRestTemplate.getForEntity(keycloakGroupListEndpoint, GroupRepresentation[].class);
//        return Arrays.asList(response.getBody());
//    }
//    public List<UserRepresentation> getUsersOfGroup(String idGroup) {
//        ResponseEntity<UserRepresentation[]> response = keycloakRestTemplate.getForEntity(keycloakGroupListEndpoint+"/"+idGroup+"/members", UserRepresentation[].class);
//        return Arrays.asList(response.getBody());
//    }
//
//    public UserRepresentation getUserRepresentationByEmail (String email){
//
//        String token = getAccessTokenKeycloak();
//        String url = keycloakUserListEndpoint+"?email="+email;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer "+token);
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//        System.out.println("url ===>"+url);
//        HttpEntity<Object> entity = new HttpEntity<>(null, headers);
//        String result = restTemplate2().exchange(url, HttpMethod.GET, entity, String.class).getBody();
//        System.out.println("==================> result "+result);
//
//        UserRepresentation user = new UserRepresentation();
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            List<UserRepresentation> map = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
//            user = map.get(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    public String getAccessTokenKeycloak (){
//        String url =base_url+"realms/BOX.AFRICA/protocol/openid-connect/token";
////        String params_str="client_id=admin-cli&client_secret=ca95d7d7-c99c-4ed8-a8eb-e89abd0c227f&grant_type=client_credentials";
//        String param = "";
//        param+="client_id=admin-cli";
//        param+="&client_secret="+client_secret;
//        param+="&grant_type=client_credentials";
//
//        System.out.println("=============> param==> "+param);
//
//        HttpHeaders headers = new HttpHeaders();
////      headers.add("Authorization", "Bearer "+access_token);
//        headers.add("Content-Type", "application/x-www-form-urlencoded");
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//        HttpEntity<String> entity = new HttpEntity<String>(param, headers);
//        String result = restTemplate2().exchange(url, HttpMethod.POST, entity, String.class).getBody();
//        System.out.println("==================> result "+result);
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            Map<String, Object> map = oMapper.readValue(result, Map.class);
//            result = (String) map.get("access_token");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("==================> token => "+result);
//        return result;
//    }
//
//
//    public List<UserRepresentation> getUsersKeycloak (){
//        String urlUsers = url+"/users";
////        String urlUsers = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/users";
//        String result = keycloackApiRequest(urlUsers,null,HttpMethod.GET);
//
//        List<UserRepresentation> users  = new ArrayList<>();
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            users = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public List<RoleRepresentation> getRolesKeycloak (){
//        String urlGroups = url+"/roles";
//        String result = keycloackApiRequest(urlGroups,null,HttpMethod.GET);
//
//        List<RoleRepresentation> roles  = new ArrayList<>();
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            roles = oMapper.readValue(result, new TypeReference<List<RoleRepresentation>>(){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return roles;
//    }
//
//    public List<GroupRepresentation> getGroupsKeycloak (){
//        String urlGroups = url+"/groups";
//        String result = keycloackApiRequest(urlGroups,null,HttpMethod.GET);
//
//        List<GroupRepresentation> groups  = new ArrayList<>();
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            groups = oMapper.readValue(result, new TypeReference<List<GroupRepresentation>>(){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return groups;
//    }
//
//    public String keycloackApiRequest (String url, String body, HttpMethod httpMethod){
//        System.out.println(url+" | "+body+" | ");
//        String token = getAccessTokenKeycloak();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer "+token);
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
//        String result = restTemplate2().exchange(url, httpMethod, entity, String.class).getBody();
//        System.out.println("==================> result "+result);
//        return result;
//    }
//
//
//    //--------------------------NEW CUSTOM KEYCLOAK-----------------------
//
//    public List<UserRepresentation> getUsersOfRoleKeycloak (String roleName){
////        String urlUsersOfRole_ = "http://127.0.0.1:9090/auth/admin/realms/BOX.AFRICA/roles/chef_agence/users";
//        String urlUsersOfRole = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/roles/"+roleName+"/users?max="+Integer.MAX_VALUE;
//        System.out.println(urlUsersOfRole);
//        String result = keycloackApiRequest(urlUsersOfRole,null,HttpMethod.GET);
//
//        List<UserRepresentation> users  = new ArrayList<>();
//        try{
//            ObjectMapper oMapper = new ObjectMapper();
//            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            users = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }

    public List<UserRepresentation> getUsers() {
        String urlUsers = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/users?max="+Integer.MAX_VALUE;
        ResponseEntity<UserRepresentation[]> response = keycloakRestTemplate.getForEntity(urlUsers, UserRepresentation[].class);
        return Arrays.asList(response.getBody());
    }
    public List<GroupRepresentation> getGroups() {
        String urlGroups = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/groups";
        ResponseEntity<GroupRepresentation[]> response = keycloakRestTemplate.getForEntity(urlGroups, GroupRepresentation[].class);
        return Arrays.asList(response.getBody());
    }
    public List<UserRepresentation> getUsersOfGroup(String idGroup) {
        String urlGroups = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/groups";
        ResponseEntity<UserRepresentation[]> response = keycloakRestTemplate.getForEntity(urlGroups+"/"+idGroup+"/members", UserRepresentation[].class);
        return Arrays.asList(response.getBody());
    }
    public List<UserRepresentation> getUsersOfRole(String roleName) {
        String urlRole = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/roles/";
        ResponseEntity<UserRepresentation[]> response = keycloakRestTemplate.getForEntity("http://40.40.40.107:8080/auth/admin/realms/BOX.AFRICA/roles/chef_agence/users?max=2147483647", UserRepresentation[].class);
        return Arrays.asList(response.getBody());
    }
    public List<org.keycloak.representations.idm.UserRepresentation> getUsersFullDataOfGroup(String idGroup) {
        String urlGroups = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/groups";
        ResponseEntity<org.keycloak.representations.idm.UserRepresentation[]> response = keycloakRestTemplate.getForEntity(urlGroups+"/"+idGroup+"/members", org.keycloak.representations.idm.UserRepresentation[].class);
        return Arrays.asList(response.getBody());
    }

    public UserRepresentation getUserRepresentationByEmail (String email){
        String urlUsers = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/"+"/users";
        String url = urlUsers+"?email="+email;
//        String token = getAccessTokenKeycloak();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer "+to
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//        System.out.println("url ===>"+url);
//        HttpEntity<Object> entity = new HttpEntity<>(null, headers);
////        String result = restTemplate2().exchange(url, HttpMethod.GET, entity, String.class).getBody();
        String result = keycloackApiRequest(url,null,HttpMethod.GET);
//        System.out.println("==================> result "+result);

        UserRepresentation user = new UserRepresentation();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<UserRepresentation> map = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
            user = map.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<UserRepresentation> getUsersKeycloak (){
        String urlUsers = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/users?max="+Integer.MAX_VALUE;
        String result = keycloackApiRequest(urlUsers,null,HttpMethod.GET);

        List<UserRepresentation> users  = new ArrayList<>();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            users = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    // S'assurer que le client admin-cli (celui dont on utilise le client secret) possède le role manage-realm
    // Pour ce faire on va dans les détails de
    // admin-cli
    // => Service Accounts Roles
    // => Client Roles
    // => realm-management
    // => manage-realm
    public List<UserRepresentation> getUsersOfRoleKeycloak (String roleName){
        //String urlUsersOfRole_ = "http://40.40.40.107:8080/auth/admin/realms/BOX.AFRICA/roles/chef_agence/users";
        String urlUsersOfRole = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/roles/"+roleName+"/users?max="+Integer.MAX_VALUE;
        String result = keycloackApiRequest(urlUsersOfRole,null,HttpMethod.GET);
        List<UserRepresentation> users  = new ArrayList<>();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            users = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<RoleRepresentation> getRolesKeycloak (){
        String urlGroups = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/roles";
        String result = keycloackApiRequest(urlGroups,null,HttpMethod.GET);

        List<RoleRepresentation> roles  = new ArrayList<>();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            roles = oMapper.readValue(result, new TypeReference<List<RoleRepresentation>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public List<GroupRepresentation> getGroupsKeycloak (){
        String urlGroups = keycloakParamConfig.getAuth_server_url()+url+"/"+keycloakParamConfig.getRealm()+"/groups";
        String result = keycloackApiRequest(urlGroups,null,HttpMethod.GET);

        List<GroupRepresentation> groups  = new ArrayList<>();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            groups = oMapper.readValue(result, new TypeReference<List<GroupRepresentation>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groups;
    }

    public String getAccessTokenKeycloak (){
        String url =keycloakParamConfig.getAuth_server_url()+"/realms/"+keycloakParamConfig.getRealm()+"/protocol/openid-connect/token";
//        String params_str="client_id=admin-cli&client_secret=ca95d7d7-c99c-4ed8-a8eb-e89abd0c227f&grant_type=client_credentials";
        String param = "";
        param+="client_id=admin-cli";
        param+="&client_secret="+keycloakParamConfig.getSecret();
        param+="&grant_type=client_credentials";


        HttpHeaders headers = new HttpHeaders();
//      headers.add("Authorization", "Bearer "+access_token);
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.setAccept(Arrays.asList(MediaType.ALL));
        HttpEntity<String> entity = new HttpEntity<String>(param, headers);
        String result = restTemplate2().exchange(url, HttpMethod.POST, entity, String.class).getBody();
        try{
            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> map = oMapper.readValue(result, Map.class);
            result = (String) map.get("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String keycloackApiRequest (String url, String body, HttpMethod httpMethod){
        String token = getAccessTokenKeycloak();
        HttpHeaders headers = new HttpHeaders();
        System.out.println("token___"+token.isEmpty());
        headers.add("Authorization", "Bearer "+token);
        headers.add("Content-Type", "application/json");
        headers.setAccept(Arrays.asList(MediaType.ALL));
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        String result = restTemplate2().exchange(url, httpMethod, entity, String.class).getBody();
        return result;
    }

    public String keycloackApiRequest (String url, HttpMethod httpMethod){
        String token = getAccessTokenKeycloak();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String result = restTemplate2().exchange(url, httpMethod, entity, String.class).getBody();
        return result;
    }

    public List<UserRepresentation> getUsersFromGroup(String groudId){
        String groupUrl = keycloakParamConfig.getAuth_server_url()+"/"+url+"/"+keycloakParamConfig.getRealm()+"/groups/"+groudId+"/members?briefRepresentation=false";
        List<UserRepresentation> users = new ArrayList<>();
        String result = keycloackApiRequest(groupUrl,HttpMethod.GET);

        try{
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            users = oMapper.readValue(result, new TypeReference<List<UserRepresentation>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

}