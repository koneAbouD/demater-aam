package com.demater.core.usecase.referential;

import com.demater.core.domain.referential.City;
import com.demater.core.publisher.CityEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetCitiesUseCaseTest {
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CityEventPublisher cityEventPublisher;
    private GetCitiesUseCase getCitiesUseCase;

    @BeforeEach
    void setUp() {
        getCitiesUseCase = new GetCitiesUseCase(cityRepository, cityEventPublisher);
    }

    @Test
    void should_get_all_city() {
        // Given
        List<City> citiesExisting = of(new City(1L, "001", "Bouaké"),
                new City(2L, "002", "Abidjan"));
        List<City> cities = of(new City(2L, "002", "Abidjan"),
                new City(1L, "001", "Bouaké"));
        when(cityRepository.findAll()).thenReturn(citiesExisting);

        // When
        List<City> results = getCitiesUseCase.execute();

        // Then
        assertEquals(2, results.size());
        assertThat(results).containsExactlyInAnyOrderElementsOf(cities);
        verify(cityEventPublisher).publishCitiesGetting(any());
    }
}
