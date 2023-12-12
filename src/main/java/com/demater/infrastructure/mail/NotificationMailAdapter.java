package com.demater.infrastructure.mail;

import com.demater.core.exception.NotificationException;
import com.demater.core.domain.user.User;
import com.demater.core.port.Notification;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

import static com.demater.core.domain.common.Constants.*;
import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class NotificationMailAdapter implements Notification {
    private static final Logger LOGGER = getLogger(NotificationMailAdapter.class);
    private static final String PATH_TEMPLATES_MESSAGES = "src/main/resources/templates/";

    @Value("${app.website.url}")
    private String siteUrl;

    @Value("${spring.mail.from}")
    private String from;

    @Value("${spring.mail.sendname}")
    private String senderName;

    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;

    public NotificationMailAdapter(JavaMailSender emailSender,
                                   TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void notifyForAccountCreated(User user) throws NotificationException {
        Map<String, String> templateArgs = new HashMap<>();
        templateArgs.put(LASTNAME, user.getLastName());
        templateArgs.put(FIRSTNAME, user.getFirstName());
        templateArgs.put(LOGIN, user.getLogin());
        templateArgs.put(PASSWORD_GENERATED, user.getPasswordGenerated());
        templateArgs.put(LINK_TO_WEBSITE, siteUrl + "/auth/signin");
        templateArgs.put(LINK_TO_DELETE_ACCOUNT, siteUrl + "/auth/delete/account/non-validated?token=" + user.getConfirmationToken());
        notify(user.getEmail(), SUBSCRIBE_TO_STORE_GAME_PROMO, ACCOUNT_CREATED, templateArgs);
    }

    @Override
    public void notifyForResetPasswordSent(User user) {
        Map<String, String> templateArgs = new HashMap<>();
        templateArgs.put(LASTNAME, user.getLastName());
        templateArgs.put(FIRSTNAME, user.getFirstName());
        templateArgs.put(PASSWORD_GENERATED, user.getPasswordGenerated());
        templateArgs.put(LINK_TO_WEBSITE, siteUrl + "/auth/signin");
        notify(user.getEmail(), RESETTING_PASSWORD, REINITIALIZE_PASSWORD, templateArgs);
    }

    @Override
    public void notifyForResetPassword(User user) {
        Map<String, String> templateArgs = new HashMap<>();
        templateArgs.put(LASTNAME, user.getLastName());
        templateArgs.put(FIRSTNAME, user.getFirstName());
        notify(user.getEmail(), CONFIRMATION_RESET_PASSWORD, PASSWORD_REINITIALIZED, templateArgs);
    }

    @Override
    public void notifyForAccountDeleted(User user) {
        Map<String, String> templateArgs = new HashMap<>();
        templateArgs.put(LASTNAME, user.getLastName());
        templateArgs.put(FIRSTNAME, user.getFirstName());
        notify(user.getEmail(), CONFIRMATION_ACCOUNT_DELETING, DELETE_ACCOUNT_NON_VALIDATED, templateArgs);
    }

    @Override
    public void notifyForUserPasswordUpdating(User user) {
        Map<String, String> templateArgs = new HashMap<>();
        templateArgs.put("lastname", user.getLastName());
        templateArgs.put("firstname", user.getFirstName());
        notify(user.getEmail(), "Confirmation modification mot de passe", "update_password", templateArgs);
    }

    private void notify(String to, String subject, String templateName, Map<String, String> templateArgs) throws NotificationException {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(from, senderName);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);

            Context context = new Context();
            for (Map.Entry<String, String> arg : templateArgs.entrySet()) {
                context.setVariable(arg.getKey(), arg.getValue());
            }

            String content = templateEngine.process(templateName, context);
            messageHelper.setText(content, true);

            // TODO : Add logo in email template
        };

        try {
            emailSender.send(messagePreparator);
        } catch (MailException e) {
            LOGGER.error(e.getMessage());
            throw new NotificationException(
                    format("Erreur lors de l'envoi du mail : To=%s, Subject=%s, TemplatePath=%s, TemplateArgs=%s",
                            to,
                            subject,
                            PATH_TEMPLATES_MESSAGES + templateName,
                            templateArgs), e);
        }
    }
}
