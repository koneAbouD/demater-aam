package africa.box.dm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "keycloak")
@Component
public class KeycloakParamConfig {

    @Value("${keycloak.auth-server-url}")
    private String auth_server_url;

    @Value("${keycloak.credentials.secret}")
    private String secret;

    @Value("${keycloak.realm}")
    private String realm;

    public String getAuth_server_url() {
        return auth_server_url;
    }

    public void setAuth_server_url(String auth_server_url) {
        this.auth_server_url = auth_server_url;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
