package com.demater.core.usecase.station;

import com.demater.core.exception.CityNotFoundException;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationUpdatingEvent;
import com.demater.core.port.CityRepository;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationAlreadyExistsException;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateStationUseCase {
    private final StationRepository stationRepository;
    private final CityRepository cityRepository;
    private final StationEventPublisher stationEventPublisher;

    public Station execute(UUID id, Station station) {
        Station stationToUpdate = stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException("Station avec ID[" + id + "] non trouvée"));

        City city = cityRepository.findById(station.cityId())
                .orElseThrow(() -> new CityNotFoundException("City with id[" + station.cityId() + "] not found"));

        if (isStationExists(stationToUpdate, station)) {
            throw new StationAlreadyExistsException("Station { designation : " + station.getDesignation()
                    + " , ville : " + station.cityDesignation() + " } est déjà existante");
        }

        stationToUpdate.update(
                station.getDesignation(),
                city,
                station.getAddress(),
                station.getCostCenter(),
                station.getStatus(),
                station.isDeleted()
        );
        Station stationSaved = stationRepository.save(stationToUpdate);
        stationEventPublisher.publishStationUpdating(new StationUpdatingEvent(id));
        return stationSaved;
    }

    private boolean isStationExists(Station stationToUpdate, Station station) {
        return !stationToUpdate.getDesignation().equalsIgnoreCase(station.getDesignation()) &&
                stationRepository.existsByDesignationAndCity(station.getDesignation(), station.cityId());
    }
}
