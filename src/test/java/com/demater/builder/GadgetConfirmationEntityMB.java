package com.demater.builder;

import com.demater.core.domain.gadget.EIntegrationStatus;
import com.demater.infrastructure.database.entity.gadget.GadgetConfirmationEntity;
import com.demater.infrastructure.database.entity.station.StationGadgetEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GadgetConfirmationEntityMB {
    private GadgetConfirmationEntity gadgetConfirmation;

    public GadgetConfirmationEntityMB() {
        gadgetConfirmation = mock(GadgetConfirmationEntity.class);
    }

    public GadgetConfirmationEntityMB withId(UUID id) {
        when(gadgetConfirmation.getId()).thenReturn(id);
        return this;
    }

    public GadgetConfirmationEntityMB withStationGadget(StationGadgetEntity stationGadget) {
        when(gadgetConfirmation.getStationGadget()).thenReturn(stationGadget);
        return this;
    }

    public GadgetConfirmationEntityMB withStatus(EIntegrationStatus status) {
        when(gadgetConfirmation.getStatus()).thenReturn(status);
        return this;
    }

    public GadgetConfirmationEntityMB withIntegrationDate(LocalDateTime date) {
        when(gadgetConfirmation.getIntegrationDate()).thenReturn(date);
        return this;
    }

    public GadgetConfirmationEntity build() {
        return gadgetConfirmation;
    }
}
