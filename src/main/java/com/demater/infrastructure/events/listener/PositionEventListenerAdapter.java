package com.demater.infrastructure.events.listener;

import com.demater.core.event.user.PositionsGettingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PositionEventListenerAdapter {
    @EventListener
    public void handle(PositionsGettingEvent event) {
        log.info("Positions retrieved at " + event.getDate());
    }
}
