package com.demater.core.usecase.station;

import com.demater.builder.CityMB;
import com.demater.builder.StationMB;
import com.demater.core.exception.CityNotFoundException;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.event.station.StationCreatingEvent;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.usecase.station.exception.StationAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateStationUseCaseTest {
    @Mock
    private StationRepository stationRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private CreateStationUseCase createStation;

    @BeforeEach
    void setUp() {
        createStation = new CreateStationUseCase(stationRepository, cityRepository, stationEventPublisher);
    }
    @Test
    void should_throw_when_create_station_with_station_city_not_exists() {
        // Given
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        Station station = new StationMB().withDesignation("aaa").withCity(city).build();
        doCallRealMethod().when(station).cityId();
        when(cityRepository.findById(city.getId())).thenReturn(empty());

        // When
        Exception exception = assertThrows(CityNotFoundException.class, () -> createStation.execute(station));

        // Then
        assertEquals("City with id[" + city.getId() + "] not found", exception.getMessage());
        verify(cityRepository).findById(city.getId());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationCreating(new StationCreatingEvent(station.getDesignation()));
    }


    @Test
    void should_throw_when_create_station_with_station_already_station() {
        // Given
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        Station station = new StationMB().withDesignation("aaa").withCity(city).build();
        doCallRealMethod().when(station).cityDesignation();
        doCallRealMethod().when(station).cityId();
        when(cityRepository.findById(city.getId())).thenReturn(of(city));
        when(stationRepository.existsByDesignationAndCity(station.getDesignation(), city.getId())).thenReturn(true);

        // When
        Exception exception = assertThrows(StationAlreadyExistsException.class, () -> createStation.execute(station));

        // Then
        assertEquals("Station { designation : " + station.getDesignation()
                + " , ville : " + station.cityDesignation() + " } est déjà existante", exception.getMessage());
        verify(cityRepository).findById(city.getId());
        verify(stationRepository, never()).save(any(Station.class));
        verify(stationEventPublisher, never()).publishStationCreating(new StationCreatingEvent(station.getDesignation()));
    }

    @Test
    void should_create_station() {
        // Given
        City city = new CityMB().withId(1L).withCode("001").withDesignation("bbbaez").build();
        Station station = new StationMB().withDesignation("aaa").withCity(city).build();
        doCallRealMethod().when(station).cityDesignation();
        doCallRealMethod().when(station).cityId();
        when(cityRepository.findById(city.getId())).thenReturn(of(city));
        when(stationRepository.existsByDesignationAndCity(station.getDesignation(), city.getId())).thenReturn(false);
        when(stationRepository.save(station)).thenReturn(station);

        // When
        createStation.execute(station);

        // Then
        verify(stationRepository).existsByDesignationAndCity(station.getDesignation(), city.getId());
        verify(stationRepository).save(any(Station.class));
        verify(stationEventPublisher).publishStationCreating(any());
    }
}
