package com.demater.core.usecase.station;

import com.demater.core.domain.exception.CityNotFoundException;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationCreatingEvent;
import com.demater.core.port.CityRepository;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateStationUseCase {
    private final StationRepository stationRepository;
    private final CityRepository cityRepository;
    private final StationEventPublisher stationEventPublisher;

    public Station execute(Station station) {
        City city = cityRepository.findById(station.cityId())
                .orElseThrow(() -> new CityNotFoundException("City with id[" + station.cityId() + "] not found"));
        if (stationRepository.existsByDesignationAndCity(station.getDesignation(), station.cityId())) {
            throw new StationAlreadyExistsException("Station { designation : " +
                    station.getDesignation() + " , ville : " + station.cityDesignation() + " } est déjà existante");
        }
        station.updateForCreating(city);
        Station stationSaved = stationRepository.save(station);
        stationEventPublisher.publishStationCreating(new StationCreatingEvent(station.getDesignation()));
        return stationSaved;
    }
}
