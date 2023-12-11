package com.demater.builder;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StationGadgetMB {
    private StationGadget stationGadget;

    public StationGadgetMB() {
        stationGadget = mock(StationGadget.class);
    }

    public StationGadgetMB withStation(Station station) {
        when(stationGadget.getStation()).thenReturn(station);
        return this;
    }

    public StationGadgetMB withGadget(Gadget gadget) {
        when(stationGadget.getGadget()).thenReturn(gadget);
        return this;
    }

    public StationGadgetMB withGadgetNumber(Long gadgetNumber) {
        when(stationGadget.getGadgetNumber()).thenReturn(gadgetNumber);
        return this;
    }

    public StationGadget build() {
        return stationGadget;
    }
}
