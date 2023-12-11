package com.demater.rest.station.in;

import com.demater.rest.common.in.CityIn;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StationCreateIn(
        @NotNull(message = "Station designation can't be null")
        @NotEmpty(message="Station designation can't be empty")
        String designation,

        @NotNull(message = "Station city can't be null")
        CityIn city,

        @NotNull(message = "Station address can't be null")
        @NotEmpty(message="Station address can't be empty")
        String address,

        @NotNull(message = "Station costCenter can't be null")
        @NotEmpty(message="Station costCenter can't be empty")
        String costCenter) {
}
