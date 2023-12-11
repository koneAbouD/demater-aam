package com.demater.core.domain.auth;

import com.demater.core.port.Password;
import jakarta.validation.constraints.Pattern;

public record CredentialsForUpdatePassword(String email,
                                           @Pattern(regexp = Password.REGEX_PASSWORD, message = Password.REGEX_MESSAGE) String password) {
}
