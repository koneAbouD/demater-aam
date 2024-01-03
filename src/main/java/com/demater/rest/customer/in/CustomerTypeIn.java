package com.demater.rest.customer.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerTypeIn(
        Long id,
        @NotEmpty(message="Code can't be empty")
        @NotNull(message = "Customer type code can't be null")
        String code,
        @NotEmpty(message="Name can't be empty")
        @NotNull(message = "Customer type name can't be null")
        String name
        ) {}
