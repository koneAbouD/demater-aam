package com.demater.core.usecase.station;

import com.demater.builder.CityMB;
import com.demater.builder.StationMB;
import com.demater.core.domain.exception.CityNotFoundException;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationUpdatingEvent;
import com.demater.core.port.CityRepository;
import com.demater.core.port.StationRepository;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationAlreadyExistsException;
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
class UpdateStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private UpdateStationUseCase updateStation;

    @BeforeEach
    void setUp() {
        updateStation = new UpdateStationUseCase(stationRepository, cityRepository, stationEventPublisher);
    }

    @Test
    void should_throw_when_update_station_with_station_to_update_dont_exists() {
        // Given
        UUID id = UUID.randomUUID();
        Station station = new StationMB().withId(id).withDesignation("aaa").build();
        when(stationRepository.findById(station.getId())).thenReturn(empty());

        // When
        Exception exception = assertThrows(StationNotFoundException.class, () -> updateStation.execute(id, station));

        // Then
        assertEquals("Station avec ID[" + station.getId() + "] non trouvée", exception.getMessage());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationUpdating(new StationUpdatingEvent(station.getId()));
    }

    @Test
    void should_throw_when_update_station_with_station_city_dont_exists() {
        // Given
        UUID stationId = UUID.randomUUID();
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        Station station = new StationMB().withId(stationId).withDesignation("aaa").withCity(city).build();
        doCallRealMethod().when(station).cityId();
        when(stationRepository.findById(station.getId())).thenReturn(of(station));
        when(cityRepository.findById(city.getId())).thenReturn(empty());

        // When
        Exception exception = assertThrows(CityNotFoundException.class, () -> updateStation.execute(stationId, station));

        // Then
        assertEquals("City with id[" + city.getId() + "] not found", exception.getMessage());
        verify(stationRepository).findById(stationId);
        verify(cityRepository).findById(city.getId());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationUpdating(new StationUpdatingEvent(station.getId()));
    }

    @Test
    void should_throw_when_update_station_with_station_name_already_exists() {
        // Given
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        UUID id = UUID.randomUUID();
        Station stationToUpdate = new StationMB().withId(id).withDesignation("aaabbb").withCity(city).build();
        Station station = new StationMB().withId(id).withDesignation("aaa").withCity(city).build();
        doCallRealMethod().when(station).cityDesignation();
        doCallRealMethod().when(station).cityId();
        when(stationRepository.findById(station.getId())).thenReturn(of(stationToUpdate));
        when(cityRepository.findById(city.getId())).thenReturn(of(city));
        when(stationRepository.existsByDesignationAndCity(station.getDesignation(), city.getId())).thenReturn(true);

        // When
        Exception exception = assertThrows(StationAlreadyExistsException.class, () -> updateStation.execute(id, station));

        // Then
        assertEquals("Station { designation : " + station.getDesignation()
                + " , ville : " + station.cityDesignation() + " } est déjà existante", exception.getMessage());
        verify(stationRepository).findById(id);
        verify(cityRepository).findById(city.getId());
        verify(stationRepository).existsByDesignationAndCity(station.getDesignation(), city.getId());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationUpdating(new StationUpdatingEvent(station.getId()));
    }

    @Test
    void should_update_station() {
        // Given
        UUID id = UUID.randomUUID();
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        String designation = "aaa";
        Station stationToUpdate = new StationMB().withId(id).withDesignation(designation).withCity(city).build();
        String newDesignation = "aaabbb";
        Station station = new StationMB().withId(id).withDesignation(newDesignation).withCity(city).build();
        doCallRealMethod().when(station).cityId();
        when(stationRepository.findById(station.getId())).thenReturn(of(stationToUpdate));
        when(cityRepository.findById(city.getId())).thenReturn(of(city));
        when(stationRepository.existsByDesignationAndCity(station.getDesignation(), city.getId())).thenReturn(false);

        // When
        updateStation.execute(id, station);

        // Then
        verify(stationRepository).findById(station.getId());
        verify(cityRepository).findById(city.getId());
        verify(stationRepository).existsByDesignationAndCity(newDesignation, city.getId());
        verify(stationToUpdate).update(newDesignation, city, station.getAddress(),
                station.getCostCenter(), station.getStatus(), station.isDeleted());
        verify(stationRepository).save(stationToUpdate);
        verify(stationEventPublisher).publishStationUpdating(any());
    }
}
