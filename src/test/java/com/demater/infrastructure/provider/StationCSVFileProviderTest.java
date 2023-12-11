package com.demater.infrastructure.provider;

import com.demater.core.domain.station.Station;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
public class StationCSVFileProviderTest {
    @InjectMocks
    private StationCSVFileProvider stationCSVFile;

    @Test
    void should_has_not_csv_format() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/text", "designation, commune\naaa, abidjan".getBytes());

        // When
        boolean result = stationCSVFile.hasCSVFormat(file);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void should_has_csv_format() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/csv", "designation, commune\naaa, abidjan".getBytes());

        // When
        boolean result = stationCSVFile.hasCSVFormat(file);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void should_throw_when_csv_to_stations() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/csv", "designation, commune, adresse, centre de coût\naaa, abidjan".getBytes());

        // Then
        assertThrows(RuntimeException.class, () -> stationCSVFile.csvToStations(file));
    }

    @Test
    void should_get_stations_when_csv_to_stations() {
        // Given
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
                "text/csv",
                ("designation, commune, adresse, centre de coût\n" +
                "aaa, abidjan, adress1, centre 1\n" +
                "bbb, yakro, adress2, centre 2").getBytes());

        // When
        List<Station> stations = stationCSVFile.csvToStations(file);

        // Then
        assertThat(stations).hasSize(2)
                .extracting(Station::getDesignation,  Station::cityDesignation, Station::getAddress, Station::getCostCenter)
                .containsExactlyInAnyOrder(
                        tuple("aaa", "abidjan", "adress1", "centre 1"),
                        tuple("bbb", "yakro", "adress2", "centre 2")
                );
    }
}
