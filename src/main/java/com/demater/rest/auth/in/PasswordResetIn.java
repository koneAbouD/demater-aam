package com.demater.rest.auth.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PasswordResetIn(
        @NotEmpty(message = "Email can't be empty")
        @NotNull(message="Email can't be null")
        String email,
        @NotEmpty(message = "Token can't be empty")
        @NotNull(message="Token can't be null")
        String token,
        @NotEmpty(message = "Password can't be empty")
        @NotNull(message="Password can't be null")
        String password
) { }
