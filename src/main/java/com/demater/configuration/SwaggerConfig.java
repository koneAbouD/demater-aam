package com.demater.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI defineAuthBearer() {
        final String securitySchemeName = "authorizationBearer";

        return new OpenAPI().info(getInfo())
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes(
                        securitySchemeName,
                        new SecurityScheme().name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

    private Info getInfo() {
        Contact contact = new Contact();
        contact.setEmail("dkone@box.africa");
        contact.setName("Box Africa");

        License mitLicense = new License().name("MIT License")
                .url("<https://choosealicense.com/licenses/mit/>");
        return new Info()
                .contact(contact)
                .version("0.0.1")
                .title("Agency account manager APIs")
                .description("The role of this application is created a banking account for they customers")
                .license(mitLicense);
    }
}
