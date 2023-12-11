package com.demater.core.usecase.station;

import com.demater.builder.StationMB;
import com.demater.core.domain.station.Station;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetAllStationsUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private GetAllStationsUseCase getAllStations;

    @BeforeEach
    void setUp() {
        getAllStations = new GetAllStationsUseCase(stationRepository, stationEventPublisher);
    }

    @Test
    void should_get_all_stations() {
        // Given
        Station station1 = new StationMB().withId(UUID.randomUUID()).withDesignation("B").build();
        Station station2 = new StationMB().withId(UUID.randomUUID()).withDesignation("A").build();
        when(stationRepository.findAll()).thenReturn(List.of(station1, station2));

        // When
        List<Station> results = getAllStations.execute();

        // Then
        assertThat(results).hasSize(2)
                .extracting(Station::getId, Station::getDesignation)
                .containsOnly(tuple(station2.getId(), station2.getDesignation()),
                        tuple(station1.getId(), station1.getDesignation()));
        verify(stationEventPublisher).publishStationsGetting(any());
    }
}
