package com.demater.rest.common.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RoleIn(
        @NotEmpty(message = "Role id can't be empty")
        @NotNull(message="Role id can't be null")
        Long id,

        @NotEmpty(message = "Role name can't be empty")
        @NotNull(message="Role name can't be null")
        String name

) { }
