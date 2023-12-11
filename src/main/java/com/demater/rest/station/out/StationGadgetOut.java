package com.demater.rest.station.out;

import com.demater.rest.gadget.out.GadgetOut;

public record StationGadgetOut(
        StationOut station,
        GadgetOut gadget,
        Long gadgetNumber
) {}
