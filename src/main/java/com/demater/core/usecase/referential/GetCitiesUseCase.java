package com.demater.core.usecase.referential;

import com.demater.core.domain.referential.City;
import com.demater.core.event.referential.CitiesGettingEvent;
import com.demater.core.port.CityRepository;
import com.demater.core.publisher.CityEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Comparator.comparing;

@RequiredArgsConstructor
public class GetCitiesUseCase {
    private final CityRepository cityRepository;
    private final CityEventPublisher cityEventPublisher;

    public List<City> execute() {
        List<City> cities = cityRepository.findAll()
                .stream()
                .sorted(comparing(City::getDesignation))
                .toList();
        cityEventPublisher.publishCitiesGetting(new CitiesGettingEvent());
        return cities;
    }
}
