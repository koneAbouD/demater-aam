package africa.box.dm.controllers;

import africa.box.dm.config.RolesConfig;
import africa.box.dm.db.entities.UserService;
import africa.box.dm.dto.CountryDTO;
import africa.box.dm.dto.User;
import africa.box.dm.service.CustomKeycloakService;
import africa.box.dm.service.MailService;
import africa.box.dm.service.Utils;
import lombok.AllArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.account.UserRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CountryResource {
    private MailService mailService;
    private CustomKeycloakService keycloakService;

    @GetMapping(path = "/countries")
    public List<CountryDTO> getCountries(@RequestParam(required = false, defaultValue = "Fr") String langKey){
        return Utils.listCountries(langKey);
    }

    @PostMapping(path = "/test/mail")
    public String testMail(){
        mailService.sendEmailFormValidateDossierTemplate("AAAAAA", "KOUAKOU", "html/validateDossier", "Fr");
        return "SUCCESS";
    }
}
