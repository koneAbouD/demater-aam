package africa.box.dm.db.entities;

import africa.box.dm.dto.User;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import net.minidev.json.JSONObject;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public static User getUser() {
        User user=null;
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
            IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
            String tokenString = kPrincipal.getKeycloakSecurityContext().getTokenString();
            user=new User();
            try {
                JWT jwt = JWTParser.parse(tokenString);
                if(token!=null){
                    user.setEmail(token.getEmail());
                    user.setFullName(token.getName());
                    user.setUserName(token.getPreferredUsername());
                    user.setNom(token.getFamilyName());
                    user.setPrenom(token.getGivenName());
                    user.setToken(kPrincipal.getKeycloakSecurityContext().getTokenString());

                    List<String> list=new ArrayList<>();
                    list.add("");
                    user.setRoles((List<String> ) list);

                    Map<String, Object> customClaims = token.getOtherClaims();
                    if (customClaims!=null) {
                        List<String> group = (List<String>) customClaims.get("group_name");
                        for (String elt: group) {
                            user.setAgence(elt);
                        }
                    }
                } else{
                    Map<String, Object> claims = jwt.getJWTClaimsSet().getClaims();
                    user.setEmail((String) claims.get("email"));
                    user.setFullName((String) claims.get("name"));
                    user.setUserName((String) claims.get("preferred_username"));
                    user.setNom((String) claims.get("family_name"));
                    user.setPrenom((String) claims.get("given_name"));
                    JSONObject realm_access = (JSONObject) claims.get("realm_access");
                    user.setRoles((List<String>) realm_access.get("roles"));
                    user.setToken(tokenString);
                    List<String> group = (List<String>) claims.get("group_name");
                    if(group!=null && !group.isEmpty()){
                        for (String elt: group) {
                            user.setAgence(elt);
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(user);
        return user;
    }

    public static User getConnectedUser(){
        User user = new User();
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if (authentication instanceof KeycloakAuthenticationToken){
             KeycloakAuthenticationToken keycloakAuthentication = (KeycloakAuthenticationToken) authentication;
             Principal principal = (Principal) keycloakAuthentication.getPrincipal();
            KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            AccessToken idToken = keycloakPrincipal.getKeycloakSecurityContext().getToken();

             user.setEmail(idToken.getEmail());
             user.setFullName(idToken.getName());
             user.setUserName(idToken.getPreferredUsername());
             user.setNom(idToken.getFamilyName());
             user.setPrenom(idToken.getGivenName());
             ArrayList<String> groups = (ArrayList<String>) idToken.getOtherClaims().get("group_name");
             if (groups.size() > 0){
                 user.setAgence(groups.get(0));
             }
             //user.setAgence(idToken.getOtherClaims().);
             // user.setToken(keycloakPrincipal.getKeycloakSecurityContext().);


         }else if(authentication instanceof AnonymousAuthenticationToken){
             AnonymousAuthenticationToken anonymousAuthenticationToken = (AnonymousAuthenticationToken) authentication;
             user.setFullName(anonymousAuthenticationToken.getPrincipal().toString());
         }

         return user;
    }
}
