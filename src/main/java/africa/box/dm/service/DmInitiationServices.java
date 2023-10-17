package africa.box.dm.service;

import africa.box.dm.db.CompteDao;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DmStatus;
import africa.box.dm.dto.User;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import net.minidev.json.JSONObject;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.text.ParseException;
import java.util.*;

@Component
public class DmInitiationServices {
    @Autowired
    CompteDao compteDao;

    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    private Utils utils;

    public CompteDocument getCompteDocument(String identifiant){
        if(identifiant != null && !identifiant.isEmpty()) {
            Optional<CompteDocument> dos = compteDocumentDao.findById(identifiant);
            if (dos.isPresent()) {
                return dos.get();
            } else {
                throw new MyAppException("Ce dossier n'existe pas ou à changer d'etat");
            }
        }
        return null;
    }

    public Compte getDossier(String businessKey){
        if(businessKey!=null && !businessKey.isEmpty() && !businessKey.equals("")) {
            Optional<Compte> dos = compteDao.findByBusinessKey(businessKey);
            if(dos.isPresent()){
                return dos.get();
            } else{
                throw  new MyAppException("Ce dossier n'existe pas ou à changer d'etat");
            }
        }else{
            Compte d=new Compte();
            d.setStatus(DmStatus.BROUILLON);
            // d.setBussinessKey(BusinessKeyGenerator.newKey());
            d.setBusinessKey(utils.generateBusinessKey());
            return  d;
        }
    }

    public User getUser() {
        User user=null;
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken)       SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
            IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
            String tokenString = kPrincipal.getKeycloakSecurityContext().getTokenString();
            user=new User();
            try {
                JWT jwt = JWTParser.parse(tokenString);
                if(token!=null){
//                    System.out.println("token =>>>>> "+token.toString());
                    user.setEmail(token.getEmail());
                    user.setFullName(token.getName());
                    user.setUserName(token.getPreferredUsername());
                    user.setNom(token.getFamilyName());
                    user.setPrenom(token.getGivenName());
                    user.setToken(kPrincipal.getKeycloakSecurityContext().getTokenString());

//                    JSONObject realm_access = (JSONObject) claims.get("realm_access");
//                    System.out.println("realm_access =======> "+realm_access);
//                    user.setRoles((List<String>) realm_access.get("roles"));
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
//                    System.out.println("claims =>>>>> "+claims.toString());
                    user.setEmail((String) claims.get("email"));
                    user.setFullName((String) claims.get("name"));
                    user.setUserName((String) claims.get("preferred_username"));
                    user.setNom((String) claims.get("family_name"));
                    user.setPrenom((String) claims.get("given_name"));
                    JSONObject realm_access = (JSONObject) claims.get("realm_access");
//                    System.out.println("realm_access =======> "+realm_access);
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
}
