package com.demater.infrastructure.events.listener;

import com.demater.core.event.referential.CitiesGettingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityEventListenerAdapter {
    @EventListener
    public void handle(CitiesGettingEvent event) {
        log.info("Cities getting at " + event.getDate());
    }
}
