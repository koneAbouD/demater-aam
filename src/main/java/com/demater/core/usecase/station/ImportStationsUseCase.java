package com.demater.core.usecase.station;

import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationsAlreadyImportedEvent;
import com.demater.core.event.station.StationsImportingEvent;
import com.demater.core.port.CityRepository;
import com.demater.core.port.StationCSVFile;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.common.exception.CSVFormatErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class ImportStationsUseCase {
    private final StationRepository stationRepository;
    private final CityRepository cityRepository;
    private final StationCSVFile stationCSVFile;
    private final StationEventPublisher stationEventPublisher;

    public List<Station> execute(MultipartFile file) {
        if (!stationCSVFile.hasCSVFormat(file)) {
            throw new CSVFormatErrorException("Error CSV format");
        }

        List<Station> stations = stationCSVFile.csvToStations(file);
        Set<String> cityNames = stations.stream().map(Station::cityDesignation).collect(toSet());
        Map<String, City> stationsCityFromCSV = cityRepository.findByDesignationIgnoreCaseIn(cityNames)
                .stream().collect(Collectors.toMap(c -> c.getDesignation().toLowerCase(), c -> c));

        List<Station> stationsToSave = getFinalStationsToSave(stations);
        stationsToSave.forEach(s -> s.setCity(stationsCityFromCSV.get(s.cityDesignation())));

        List<Station> stationsSaved = emptyList();

        if (!stationsToSave.isEmpty()) {
            stationsSaved = stationRepository.saveAll(stationsToSave);
        }

        stationEventPublisher.publishStationsImporting(new StationsImportingEvent());
        return stationsSaved;
    }

    private List<Station> getFinalStationsToSave(List<Station> stations) {
        Set<String> stationsNames = stations.stream().map(Station::getDesignation).collect(toSet());
        Set<Station> existingStations = stationRepository.findByDesignationIgnoreCaseIn(stationsNames);

        stationEventPublisher.publishStationsAlreadyImported(new StationsAlreadyImportedEvent(
                existingStations.stream().map(Station::getDesignation).toList()
        ));

        return stations.stream()
                .filter(s -> existingStations.stream()
                        .noneMatch(e -> e.getDesignation().equalsIgnoreCase(s.getDesignation()) &&
                                e.cityDesignation().equalsIgnoreCase(s.cityDesignation())))
                .toList();
    }
}
