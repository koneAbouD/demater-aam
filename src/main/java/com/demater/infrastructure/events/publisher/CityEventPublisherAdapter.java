package com.demater.infrastructure.events.publisher;

import com.demater.core.event.referential.CitiesGettingEvent;
import com.demater.core.publisher.CityEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class CityEventPublisherAdapter implements CityEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishCitiesGetting(CitiesGettingEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
