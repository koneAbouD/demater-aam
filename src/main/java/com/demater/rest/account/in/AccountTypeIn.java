package com.demater.rest.account.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AccountTypeIn(
        @NotNull(message = "Account type id can't be null")
        Long id,

        @NotEmpty(message="Designation can't be empty")
        @NotNull(message = "Account type designation can't be null")
        String designation) {}
