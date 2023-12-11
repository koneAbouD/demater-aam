package com.demater.rest.user.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static com.demater.core.port.Password.REGEX_MESSAGE;
import static com.demater.core.port.Password.REGEX_PASSWORD;

public record PasswordUpdateIn(
        @NotEmpty(message = "Login can't be empty")
        @NotNull(message = "Login can't be null")
        String email,

        @NotEmpty(message = "Password can't be empty")
        @NotNull(message="Password can't be null")
        @Pattern(regexp = REGEX_PASSWORD, message = REGEX_MESSAGE)
        String password
) { }
