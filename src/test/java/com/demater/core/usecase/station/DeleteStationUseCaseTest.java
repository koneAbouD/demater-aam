package com.demater.core.usecase.station;

import com.demater.builder.StationMB;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationDeletingEvent;
import com.demater.core.port.StationDeleteTime;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class DeleteStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private StationDeleteTime stationDeleteTime;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private DeleteStationUseCase deleteStation;

    @BeforeEach
    void setUp() {
        deleteStation = new DeleteStationUseCase(stationRepository, stationDeleteTime, stationEventPublisher);
    }

    @Test
    void should_throw_when_delete_station_with_station_deleting() {
        // Given
        UUID id = UUID.randomUUID();
        when(stationRepository.findById(id)).thenReturn(empty());

        // When
        Exception exception = assertThrows(StationNotFoundException.class, () -> deleteStation.execute(id));

        // Then
        assertEquals("Station avec ID[" + id + "] non trouvée", exception.getMessage());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationDeleting(new StationDeletingEvent(id));
    }

    @Test
    void should_delete_station() {
        // Given
        UUID id = UUID.randomUUID();
        String designation = "bbbb";
        Station station = new StationMB().withId(id).withDesignation(designation).build();
        when(stationRepository.findById(id)).thenReturn(of(station));
        Long deleteTime = 23456789L;
        when(stationDeleteTime.get()).thenReturn(deleteTime);

        // When
        deleteStation.execute(id);

        // Then
        verify(stationRepository).findById(id);
        verify(stationDeleteTime).get();
        verify(station).deleteAt(deleteTime);
        verify(stationRepository).save(station);
        verify(stationEventPublisher).publishStationDeleting(any());
    }
}
