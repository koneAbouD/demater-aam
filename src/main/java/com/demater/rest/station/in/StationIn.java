package com.demater.rest.station.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record StationIn(
        @NotNull(message = "Station id can't be null")
        UUID id,

        @NotNull(message = "Station designation can't be null")
        @NotEmpty(message="Station designation can't be empty")
        String designation) {
}
