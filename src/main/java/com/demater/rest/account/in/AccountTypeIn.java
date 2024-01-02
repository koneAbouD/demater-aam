package com.demater.rest.account.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AccountTypeIn(
        Long id,
        @NotEmpty(message="Code can't be empty")
        @NotNull(message = "Account type code can't be null")
        String code,
        @NotEmpty(message="Name can't be empty")
        @NotNull(message = "Account type name can't be null")
        String name
        ) {}
