package com.demater.builder;

import com.demater.core.domain.gadget.EIntegrationStatus;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.station.StationGadget;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetConfirmationMB {
    private GadgetConfirmation gadgetConfirmation;

    public GadgetConfirmationMB() {
        gadgetConfirmation = mock(GadgetConfirmation.class);
    }

    public GadgetConfirmationMB withId(UUID id) {
        when(gadgetConfirmation.getId()).thenReturn(id);
        return this;
    }

    public GadgetConfirmationMB withStationGadget(StationGadget stationGadget) {
        when(gadgetConfirmation.getStationGadget()).thenReturn(stationGadget);
        return this;
    }

    public GadgetConfirmationMB withStatus(EIntegrationStatus status) {
        when(gadgetConfirmation.getStatus()).thenReturn(status);
        return this;
    }

    public GadgetConfirmationMB withIntegrationDate(LocalDateTime date) {
        when(gadgetConfirmation.getIntegrationDate()).thenReturn(date);
        return this;
    }

    public GadgetConfirmation build() {
        return gadgetConfirmation;
    }
}
