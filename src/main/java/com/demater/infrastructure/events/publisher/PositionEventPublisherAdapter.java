package com.demater.infrastructure.events.publisher;

import com.demater.core.event.user.PositionsGettingEvent;
import com.demater.core.publisher.PositionEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class PositionEventPublisherAdapter implements PositionEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishPositionsGettingEvent(PositionsGettingEvent event) {
        eventPublisher.publishEvent(event);
    }
}
