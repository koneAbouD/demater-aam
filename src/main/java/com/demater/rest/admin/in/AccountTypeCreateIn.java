package com.demater.rest.admin.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AccountTypeCreateIn(
        @NotEmpty(message="Designation can't be empty")
        @NotNull(message = "Account type designation can't be null")
        String designation) {}
