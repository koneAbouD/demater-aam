package com.demater.core.usecase.station;

import com.demater.builder.*;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.publisher.StationEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.demater.core.domain.gadget.EIntegrationStatus.CONFIRMED;
import static com.demater.core.domain.gadget.EIntegrationStatus.UNCONFIRMED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class RecoveringGadgetsSentUseCaseTest {
    @Mock
    private GadgetConfirmationRepository gadgetConfirmationRepository;
    @Mock
    private StationEventPublisher stationEventPublisher;
    private RecoveringGadgetsSentUseCase recoveringSentGadgets;

    @BeforeEach
    void setUp() {
        recoveringSentGadgets = new RecoveringGadgetsSentUseCase(gadgetConfirmationRepository, stationEventPublisher);
    }

    @Test
    void should_recover_sent_gadgets() {
        // Given
        City city1 = new CityMB().withId(1L).withCode("001").withDesignation("city 1").build();
        Station station1 = new StationMB().withId(UUID.randomUUID()).withDesignation("Station Abidjan")
                .withCity(city1).build();
        GadgetType gadgetType1 = new GadgetTypeMB().withId(1L).withDesignation("Type 1").build();
        Gadget gadget1 = new GadgetMB().withId(UUID.randomUUID())
                .withDesignation("Chargeur de voiture USB multifonction").withGadgetType(gadgetType1).build();
        StationGadget stationGadget1 = new StationGadgetMB().withGadget(gadget1)
                .withStation(station1).build();
        GadgetConfirmation gadgetConfirmation1 = new GadgetConfirmationMB().withId(UUID.randomUUID())
                .withStationGadget(stationGadget1).withStatus(CONFIRMED)
                .withIntegrationDate(LocalDateTime.of(2023, 9, 1, 12, 0, 50)).build();
        doCallRealMethod().when(gadgetConfirmation1).stationName();
        doCallRealMethod().when(gadgetConfirmation1).gadgetName();
        doCallRealMethod().when(gadgetConfirmation1).station();
        doCallRealMethod().when(gadgetConfirmation1).gadget();

        City city2 = new CityMB().withId(1L).withCode("002").withDesignation("city 2").build();
        Station station2 = new StationMB().withId(UUID.randomUUID()).withDesignation("Station Divo")
                .withCity(city2).build();
        GadgetType gadgetType2 = new GadgetTypeMB().withId(2L).withDesignation("Type 2").build();
        Gadget gadget2 = new GadgetMB().withId(UUID.randomUUID())
                .withDesignation("Kit d'urgence routière").withGadgetType(gadgetType2).build();
        StationGadget stationGadget2 = new StationGadgetMB().withGadget(gadget2)
                .withStation(station2).build();
        GadgetConfirmation gadgetConfirmation2= new GadgetConfirmationMB().withId(UUID.randomUUID())
                .withStationGadget(stationGadget2).withStatus(CONFIRMED)
                .withIntegrationDate(LocalDateTime.of(2023, 9, 5, 12, 0, 50)).build();
        doCallRealMethod().when(gadgetConfirmation2).stationName();
        doCallRealMethod().when(gadgetConfirmation2).gadgetName();
        doCallRealMethod().when(gadgetConfirmation2).station();
        doCallRealMethod().when(gadgetConfirmation2).gadget();
        when(gadgetConfirmationRepository.findAll()).thenReturn(List.of(gadgetConfirmation1, gadgetConfirmation2));

        // When
        List<GadgetConfirmation> results = recoveringSentGadgets.execute(Map.of());

        // Then
        verify(gadgetConfirmationRepository).findAll();
        assertThat(results).hasSize(2)
                .extracting(GadgetConfirmation::getId)
                .containsOnly(gadgetConfirmation1.getId(), gadgetConfirmation2.getId());
        verify(stationEventPublisher).publishRecoveringSentGadgets(any());
    }

    @Test
    void should_recover_sent_gadgets_with_queries() {
        // Given
        City city1 = new CityMB().withId(1L).withCode("001").withDesignation("city 1").build();
        Station station1 = new StationMB().withId(UUID.randomUUID()).withDesignation("Station Abidjan")
                .withCity(city1).build();
        GadgetType gadgetType1 = new GadgetTypeMB().withId(1L).withDesignation("Type 1").build();
        Gadget gadget1 = new GadgetMB().withId(UUID.randomUUID())
                .withDesignation("Chargeur de voiture USB multifonction").withGadgetType(gadgetType1).build();
        StationGadget stationGadget1 = new StationGadgetMB().withGadget(gadget1).withStation(station1).build();
        GadgetConfirmation gadgetConfirmation1 = new GadgetConfirmationMB().withId(UUID.randomUUID())
                .withStationGadget(stationGadget1).withStatus(CONFIRMED)
                .withIntegrationDate(LocalDateTime.of(2023, 9, 1, 12, 0, 50)).build();
        when(gadgetConfirmation1.stationName()).thenReturn("Station Abidjan");
        when(gadgetConfirmation1.gadgetName()).thenReturn("Chargeur de voiture USB multifonction");
        when(gadgetConfirmation1.station()).thenReturn(station1);
        when(gadgetConfirmation1.gadget()).thenReturn(gadget1);

        City city2 = new CityMB().withId(1L).withCode("002").withDesignation("city 2").build();
        Station station2 = new StationMB().withId(UUID.randomUUID()).withDesignation("Station Divo")
                .withCity(city2).build();
        GadgetType gadgetType2 = new GadgetTypeMB().withId(2L).withDesignation("Type 2").build();
        Gadget gadget2 = new GadgetMB().withId(UUID.randomUUID())
                .withDesignation("Kit d'urgence routière").withGadgetType(gadgetType2).build();
        StationGadget stationGadget2 = new StationGadgetMB().withGadget(gadget2)
                .withStation(station2).build();
        GadgetConfirmation gadgetConfirmation2= new GadgetConfirmationMB().withId(UUID.randomUUID())
                .withStationGadget(stationGadget2).withStatus(UNCONFIRMED)
                .withIntegrationDate(LocalDateTime.of(2023, 9, 5, 12, 0, 50)).build();
        when(gadgetConfirmation2.stationName()).thenReturn("Station Divo");
        when(gadgetConfirmation2.gadgetName()).thenReturn("Kit d'urgence routière");
        when(gadgetConfirmation2.station()).thenReturn(station2);
        when(gadgetConfirmation2.gadget()).thenReturn(gadget2);

        when(gadgetConfirmationRepository.findAll()).thenReturn(List.of(gadgetConfirmation1, gadgetConfirmation2));

        // When
        List<GadgetConfirmation> resultsForStations = recoveringSentGadgets.execute(Map.of("station", "Abidjan"));
        List<GadgetConfirmation> resultsForGadgets = recoveringSentGadgets.execute(Map.of("gadget", "urgence"));
        List<GadgetConfirmation> resultsForStatus = recoveringSentGadgets.execute(Map.of("status", "CONFIRMED"));
        List<GadgetConfirmation> resultsForDates = recoveringSentGadgets.execute(Map.of("dates", "2023-09-04;2023-09-05"));
        List<GadgetConfirmation> resultsForAll = recoveringSentGadgets.execute(Map.of(
                "station", "Abidjan",
                "gadget", "urgence",
                "date", "2023-09-04;2023-09-05")
        );

        // Then
        assertThat(resultsForStations).hasSize(1)
                .extracting(GadgetConfirmation::getId)
                .containsOnly(gadgetConfirmation1.getId());
        assertThat(resultsForGadgets).hasSize(1)
                .extracting(GadgetConfirmation::getId)
                .containsOnly(gadgetConfirmation2.getId());
        assertThat(resultsForDates).hasSize(1)
                .extracting(GadgetConfirmation::getId)
                .containsOnly(gadgetConfirmation2.getId());
        assertThat(resultsForStatus).hasSize(1)
                .extracting(GadgetConfirmation::getId)
                .containsOnly(gadgetConfirmation1.getId());
        assertThat(resultsForAll).hasSize(0);
        verify(stationEventPublisher, times(5)).publishRecoveringSentGadgets(any());
    }
}
