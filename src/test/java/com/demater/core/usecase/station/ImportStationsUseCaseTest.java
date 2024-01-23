package com.demater.core.usecase.station;

import com.demater.builder.CityMB;
import com.demater.builder.StationMB;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationsImportingEvent;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.common.exception.CSVFormatErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class ImportStationsUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private StationCSVFile stationCSVFile;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private ImportStationsUseCase importStations;

    @BeforeEach
    void setUp() {
        importStations = new ImportStationsUseCase(stationRepository,
                cityRepository,
                stationCSVFile,
                stationEventPublisher);
    }

    @Test
    void should_throw_when_import_stations_with_file_format_error() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/plain", "designation commune".getBytes());
        when(stationCSVFile.hasCSVFormat(file)).thenReturn(false);

        // When
        Exception exception = assertThrows(CSVFormatErrorException.class, () -> importStations.execute(file));

        // Then
        assertEquals("Error CSV format", exception.getMessage());
        verify(stationRepository, never()).saveAll(any());
        verify(stationEventPublisher, never()).publishStationsImporting(new StationsImportingEvent());
    }

    @Test
    void should_import_stations_with_station_already_imported() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/csv", "designation, commune\nd1, c1".getBytes());
        City city = new CityMB().withCode("001").withDesignation("bbbaez").build();
        Station station = new StationMB().withDesignation("aaa").withCity(city).build();
        List<Station> stations = List.of(station);
        when(stationCSVFile.hasCSVFormat(file)).thenReturn(true);
        when(stationCSVFile.csvToStations(file)).thenReturn(stations);
        doCallRealMethod().when(station).cityDesignation();
        when(cityRepository.findByDesignationIgnoreCaseIn(Set.of(city.getDesignation()))).thenReturn(List.of(city));
        when(stationRepository.findByDesignationIgnoreCaseIn(Set.of(station.getDesignation()))).thenReturn(Set.of(station));

        // When
        List<Station> results = importStations.execute(file);

        // Then
        verify(cityRepository).findByDesignationIgnoreCaseIn(Set.of(city.getDesignation()));
        verify(stationRepository).findByDesignationIgnoreCaseIn(Set.of(station.getDesignation()));
        verify(stationRepository, never()).saveAll(any());
        assertThat(results).isEmpty();
        verify(stationEventPublisher).publishStationsImporting(any());
    }

    @Test
    void should_import_stations() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/csv", "designation, commune\naaa, abidjan".getBytes());
        City city = new CityMB().withCode("001").withDesignation("abidjan").build();
        Station station = new StationMB().withDesignation("aaa").withCity(city).build();
        List<Station> stations = List.of(station);
        when(stationCSVFile.hasCSVFormat(file)).thenReturn(true);
        when(stationCSVFile.csvToStations(file)).thenReturn(stations);
        doCallRealMethod().when(station).cityDesignation();
        when(cityRepository.findByDesignationIgnoreCaseIn(Set.of(city.getDesignation()))).thenReturn(List.of(city));
        when(stationRepository.findByDesignationIgnoreCaseIn(Set.of(station.getDesignation()))).thenReturn(Set.of());

        // When
        importStations.execute(file);

        // Then
        verify(cityRepository).findByDesignationIgnoreCaseIn(Set.of(city.getDesignation()));
        verify(stationRepository).findByDesignationIgnoreCaseIn(Set.of(station.getDesignation()));
        verify(stationRepository).saveAll(any());
        verify(stationEventPublisher).publishStationsImporting(any());
    }
}
