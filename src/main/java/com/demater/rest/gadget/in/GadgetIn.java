package com.demater.rest.gadget.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GadgetIn(
        @NotNull(message = "Gadget id can't be null")
        UUID id,

        @NotEmpty(message="Designation can't be empty")
        @NotNull(message = "Gadget designation can't be null")
        @Schema(name = "designation", example = "Emergency road kit")
        String designation
) {}
