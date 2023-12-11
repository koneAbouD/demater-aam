package com.demater.core.usecase.station;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetAndNumber;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.domain.station.StationGadgetTuple;
import com.demater.core.event.station.StationGadgetIntegratingEvent;
import com.demater.core.port.GadgetConfirmationRepository;
import com.demater.core.port.GadgetRepository;
import com.demater.core.port.StationGadgetRepository;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import static com.demater.core.domain.gadget.EIntegrationStatus.UNCONFIRMED;
import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class IntegrateGadgetsInStationUseCase {
    private final StationRepository stationRepository;
    private final StationGadgetRepository stationGadgetRepository;
    private final GadgetRepository gadgetRepository;
    private final GadgetConfirmationRepository gadgetConfirmationRepository;
    private final StationEventPublisher stationEventPublisher;

    public Set<StationGadget> execute(UUID stationId, Set<GadgetAndNumber> gadgetAndNumbers) {
        Station station = getStationById(stationId);
        Map<StationGadgetTuple, StationGadget> gadgetsByStation = getGadgetsByStation(stationId, gadgetAndNumbers);
        List<GadgetConfirmation> gadgetConfirmations = new ArrayList<>();
        Set<StationGadget> stationsGadgets = new HashSet<>();

        for (GadgetAndNumber gadgetNumber : gadgetAndNumbers) {
            StationGadget stationGadget = gadgetsByStation.get(new StationGadgetTuple(station.getId(), gadgetNumber.gadgetId()));
            constructGadgetsConfirmations(gadgetConfirmations, stationsGadgets, station, gadgetNumber, stationGadget);
        }

        gadgetConfirmationRepository.saveAll(gadgetConfirmations);
        stationEventPublisher.publishStationGadgetIntegrating(new StationGadgetIntegratingEvent(stationId, gadgetAndNumbers.stream().map(GadgetAndNumber::gadgetName).toList()));
        return stationsGadgets;
    }

    private Station getStationById(UUID id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException("Station avec ID[" + id + "] non trouvée"));
    }

    private Map<StationGadgetTuple, StationGadget> getGadgetsByStation(UUID stationId, Set<GadgetAndNumber> gadgetAndNumbers) {
        Set<UUID> gadgetsIds = gadgetAndNumbers.stream()
                .map(GadgetAndNumber::gadgetId)
                .collect(toSet());

        return stationGadgetRepository.findAllByStationAndGadgetIn(stationId, gadgetsIds).stream()
                .collect(Collectors.toMap(s -> new StationGadgetTuple(s.stationId(), s.gadgetId()), s -> s));
    }

    private void constructGadgetsConfirmations(List<GadgetConfirmation> gadgetConfirmations,
                                               Set<StationGadget> stationsGadgets,
                                               Station station,
                                               GadgetAndNumber gadgetNumber,
                                               StationGadget stationGadgetToSave) {
        StationGadget stationGadget;
        GadgetConfirmation gadgetConfirmation;
        Gadget gadget = getGadgetId(gadgetNumber.gadgetId());

        if (stationGadgetToSave == null) {
            stationGadget = new StationGadget(station, gadget, gadgetNumber.getGadgetNumber());
            gadgetConfirmation = GadgetConfirmation.builder()
                    .stationGadget(stationGadget)
                    .gadgetNumberReceived(gadgetNumber.getGadgetNumber())
                    .status(UNCONFIRMED)
                    .integrationDate(now())
                    .build();
            stationsGadgets.add(stationGadget);
        }
        else {
            stationGadgetToSave.updateGadgetNumber(gadgetNumber.getGadgetNumber());
            gadgetConfirmation = GadgetConfirmation.builder()
                    .stationGadget(stationGadgetToSave)
                    .status(UNCONFIRMED)
                    .gadgetNumberReceived(gadgetNumber.getGadgetNumber())
                    .integrationDate(now())
                    .build();
            stationsGadgets.add(stationGadgetToSave);
        }

        gadget.gadgetToStation(gadgetNumber.getGadgetNumber());
        gadgetConfirmations.add(gadgetConfirmation);
    }

    private Gadget getGadgetId(UUID id) {
        return gadgetRepository.findById(id).orElseThrow(() -> new GadgetNotFoundException("Gadget avec ID[" + id + "] non trouvé"));
    }
}
