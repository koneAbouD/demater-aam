package africa.box.dm.service;

import africa.box.dm.config.RolesConfig;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.UserService;
import org.keycloak.representations.account.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MailService {

    private static String FROM ="dkouakou@box.africa";
    private static String DOSSIER_URL = "http://104.40.182.52/account/accounts/edit/";
    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender javaMailSender;
    private final MessageSource messageSource;
    private final SpringTemplateEngine templateEngine;
    private CustomKeycloakService keycloakService;


    public MailService(JavaMailSender javaMailSender, MessageSource messageSource, SpringTemplateEngine templateEngine,
                       CustomKeycloakService keycloakService){
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
        this.keycloakService = keycloakService;
    }

    public void sendMail(String to, String subject, String content, boolean isMultipart, boolean isHtml){
        log.debug("Send mail[multipart '{}' and html '{}'] to {}", isMultipart, isHtml, to);

        //Prepare Mail Using Spring helpper
       try{
           MimeMessage mimeMessage = javaMailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
           message.setTo(to);
           message.setFrom(FROM);
           message.setSubject(subject);
           message.setText(content, isHtml);
           javaMailSender.send(mimeMessage);
           log.debug("Email sent to '{}'", to);
       }catch (Exception ex){
            log.warn("Email Could not be sent to '{}'", to, ex);
           ex.printStackTrace();
       }
    }

    @Async
    public void sendEmailFormValidateDossierTemplate(String dossierNumber, String customerCharge, String templateName, String langKey){
        Locale locale = Locale.forLanguageTag(langKey);
        final Context context = new Context(locale);
        context.setVariable("dossierNumber", dossierNumber );
        context.setVariable("customerCharge", UserService.getConnectedUser().getFullName());

        List<UserRepresentation> usersInGroup = keycloakService.getGroupsKeycloak().stream()
                .filter(grp->{return grp.getName().equalsIgnoreCase(UserService.getConnectedUser().getAgence().trim().replace("/", ""));})
                .findFirst()
                .map(grp->{return keycloakService.getUsersFromGroup(grp.getId());})
                .orElse(new ArrayList<>());

        List<UserRepresentation> usersInrole = keycloakService.getUsersOfRoleKeycloak(RolesConfig.Roles_comite_validation);
        List<String> emails = usersInrole.stream()
                .filter(user->{
                    boolean found = false;
                    for(UserRepresentation u:usersInGroup){
                        if (u.getId().equals(user.getId())) {
                            found = true;
                            break;
                        }
                    }

                    return found;
                })
                .map(UserRepresentation::getEmail)
                .collect(Collectors.toList());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        context.setVariable("completedDate", sdf.format(new Date()));
        context.setVariable("url",DOSSIER_URL+dossierNumber);
        //String subject = messageSource.getMessage("email.dossier.title", new Object[]{dossierNumber}, locale);
        String subject = "Dossier d'Ouverture de Compte N°"+ dossierNumber+" en attente de validation";
        String htmlContext = templateEngine.process(templateName, context);
        for (String to:emails){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   sendMail(to, subject, htmlContext, false, true);
               }
           }).start();
        }
    }


    public static void main(String... args){
        String path = new  ClassPathResource("regula.license").getPath();
       try{
          byte[] bytes = Files.readAllBytes(Paths.get(path));
       }catch(Exception ex){
            ex.printStackTrace();
       }
    }
}
