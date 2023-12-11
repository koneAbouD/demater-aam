package com.demater.rest.common.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CityIn(
        @NotNull(message = "City id can't be null")
        Long id,

        @NotEmpty(message="Code can't be empty")
        @NotNull(message = "City code can't be null")
        String code,

        @NotEmpty(message="Designation can't be empty")
        @NotNull(message = "City name can't be null")
        String designation) {}
