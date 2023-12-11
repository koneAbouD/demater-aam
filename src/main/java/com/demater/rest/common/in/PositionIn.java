package com.demater.rest.common.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PositionIn(
        @NotEmpty(message = "Code can't be empty")
        @NotNull(message="Code can't be null")
        String code,
        @NotEmpty(message = "Designation can't be empty")
        @NotNull(message="Designation can't be null")
        String designation,
        String description

) { }
