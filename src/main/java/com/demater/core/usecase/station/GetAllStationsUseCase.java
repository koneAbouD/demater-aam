package com.demater.core.usecase.station;

import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationsGettingEvent;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Comparator.comparing;

@RequiredArgsConstructor
public class GetAllStationsUseCase {
    private final StationRepository stationRepository;
    private final StationEventPublisher stationEventPublisher;

    public List<Station> execute() {
        List<Station> stations = stationRepository.findAll()
                .stream()
                .sorted(comparing(Station::getDesignation).thenComparing(Station::cityDesignation))
                .toList();
        stationEventPublisher.publishStationsGetting(new StationsGettingEvent());
        return stations;
    }
}
