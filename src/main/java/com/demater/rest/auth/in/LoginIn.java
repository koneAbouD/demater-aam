package com.demater.rest.auth.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginIn(
        @NotEmpty(message = "Login can't be empty")
        @NotNull(message="Login can't be null")
        String login,
        @NotEmpty(message = "Password can't be empty")
        @NotNull(message="Password can't be null")
        String password

) { }
