package com.demater.rest.auth.in;

import com.demater.rest.common.in.PositionIn;
import com.demater.rest.common.in.RoleIn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


public record UserCreateIn(
    @NotEmpty(message = "User login can't be empty")
    @NotNull(message="User login can't be null")
    String login,

    @NotEmpty(message = "User firstname can't be empty")
    @NotNull(message="User firstname can't be null")
    String firstName,

    @NotEmpty(message = "User lastname can't be empty")
    @NotNull(message="User lastname can't be null")
    String lastName,

    @Email
    @NotEmpty(message = "User email can't be empty")
    @NotNull(message="User email can't be null")
    String email,

    @NotNull(message="Roles can't be null")
    @NotEmpty(message = "User roles can't be empty")
    Set<RoleIn> roles,

    Set<PositionIn> positions
) {}
