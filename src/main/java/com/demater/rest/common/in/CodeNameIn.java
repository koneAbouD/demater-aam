package com.demater.rest.common.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CodeNameIn(
        @NotEmpty(message="Code can't be empty")
        @NotNull(message = "Code can't be null")
        String code,
        @NotEmpty(message="Name can't be empty")
        @NotNull(message = "Name can't be null")
        String name
        ) {}
