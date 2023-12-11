package com.demater.core.usecase.station;

import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationDeletingEvent;
import com.demater.core.port.StationDeleteTime;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteStationUseCase {
    private final StationRepository stationRepository;
    private final StationDeleteTime stationDeleteTime;
    private final StationEventPublisher stationEventPublisher;

    public void execute(UUID id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException("Station avec ID[" + id + "] non trouvée"));
        station.deleteAt(stationDeleteTime.get());
        stationRepository.save(station);
        stationEventPublisher.publishStationDeleting(new StationDeletingEvent(id));
    }
}
