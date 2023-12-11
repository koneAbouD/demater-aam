package com.demater.builder;

import com.demater.infrastructure.database.entity.gadget.GadgetEntity;
import com.demater.infrastructure.database.entity.station.StationEntity;
import com.demater.infrastructure.database.entity.station.StationGadgetEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StationGadgetEntityMB {
    private StationGadgetEntity stationGadget;

    public StationGadgetEntityMB() {
        stationGadget = mock(StationGadgetEntity.class);
    }

    public StationGadgetEntityMB withStation(StationEntity station) {
        when(stationGadget.getStation()).thenReturn(station);
        return this;
    }

    public StationGadgetEntityMB withGadget(GadgetEntity gadget) {
        when(stationGadget.getGadget()).thenReturn(gadget);
        return this;
    }

    public StationGadgetEntityMB withGadgetNumber(Long gadgetNumber) {
        when(stationGadget.getGadgetNumber()).thenReturn(gadgetNumber);
        return this;
    }

    public StationGadgetEntity build() {
        return stationGadget;
    }
}
