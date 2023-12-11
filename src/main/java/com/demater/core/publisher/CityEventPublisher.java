package com.demater.core.publisher;

import com.demater.core.event.referential.CitiesGettingEvent;

public interface CityEventPublisher {
    void publishCitiesGetting(CitiesGettingEvent citiesGettingEvent);
}
