package com.demater.rest.gadget.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record GadgetTypeIn(
        @NotNull(message = "Gadget type id can't be null")
        Long id,

        @NotEmpty(message="Designation can't be empty")
        @NotNull(message = "Gadget type designation can't be null")
        String designation) {}
