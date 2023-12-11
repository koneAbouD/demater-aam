package com.demater.configuration.security.jwt;

import io.jsonwebtoken.*;
import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;


@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${dsoumaila.app.jwtSecret}")
    private String jwtSecret;

    @Value("${dsoumaila.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    public String generateJwtToken(String username) {
        return getJWT(username);
    }

    private String getJWT(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(signatureAlgorithm, getSigningKey())
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret))
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    private Key getSigningKey() {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
        return new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }
}
