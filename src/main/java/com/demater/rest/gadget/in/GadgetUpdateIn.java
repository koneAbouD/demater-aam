package com.demater.rest.gadget.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GadgetUpdateIn(
        @NotNull(message = "Gadget designation can't be null")
        @Schema(name = "designation", example = "Emergency road kit")
        String designation,

        @NotNull(message = "Gadget type can't be null")
        @Schema(name = "type")
        GadgetTypeIn type,

        @Schema(name = "description", nullable = true)
        String description,

        @Schema(name = "details", nullable = true)
        String details,

        @Schema(name = "totalNumber", nullable = true)
        @Positive(message = "The number must be integer greater than or equal to 0")
        Long totalNumber,

        @Schema(name = "remainingNumber", nullable = true)
        @Positive(message = "The number must be integer greater than or equal to 0")
        Long remainingNumber,

        @Schema(name = "isAvailable")
        boolean isAvailable
) {}
