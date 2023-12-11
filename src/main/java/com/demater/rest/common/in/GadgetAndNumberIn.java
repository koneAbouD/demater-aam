package com.demater.rest.common.in;

import com.demater.rest.gadget.in.GadgetIn;
import jakarta.validation.constraints.NotNull;

public record GadgetAndNumberIn(
        @NotNull(message = "Station can't be null")
        GadgetIn gadget,

        @NotNull(message = "gadgetNumber can't be null")
        Long gadgetNumber
) {}
