package com.demater.core.port;

public interface Password {

    String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%&*_+]).{12,}$";
    String REGEX_MESSAGE = "Must be at least 12 characters long, Must contain at least one uppercase letter, " +
            "Must contain at least one lowercase letter, Must contain at least one number, " +
            "Must contain at least one special character";

    String generatePassword();
    String encode(String password);
    String generateJwtToken(String username);
    boolean validateJwtToken(String token);
}
