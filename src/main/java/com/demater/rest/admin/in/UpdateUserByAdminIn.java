package com.demater.rest.admin.in;

import com.demater.rest.common.in.RoleIn;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


public record UpdateUserByAdminIn(
    @NotEmpty(message = "User firstname can't be empty")
    @NotNull(message = "User firstname can't be null")
    String firstName,

    @NotEmpty(message = "User lastname can't be empty")
    @NotNull(message = "User lastname can't be null")
    String lastName,

    @NotNull(message="Roles can't be null")
    @NotEmpty(message = "User roles can't be empty")
    Set<RoleIn> roles,

    @NotNull(message="User activation can't be null")
    boolean valid,

    @NotNull(message="User activation can't be null")
    boolean isActivate
) {}
