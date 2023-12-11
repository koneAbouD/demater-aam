package com.demater.rest.user.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record UpdateUserProfileIn(
    @NotEmpty(message = "User firstname can't be empty")
    @NotNull(message = "User firstname can't be null")
    String firstName,

    @NotEmpty(message = "User lastname can't be empty")
    @NotNull(message = "User lastname can't be null")
    String lastName,

    @NotEmpty(message = "User email can't be empty")
    @NotNull(message = "User email can't be null")
    String email
) {}
