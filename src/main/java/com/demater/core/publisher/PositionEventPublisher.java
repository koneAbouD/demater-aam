package com.demater.core.publisher;

import com.demater.core.event.user.PositionsGettingEvent;

public interface PositionEventPublisher {
    void publishPositionsGettingEvent(PositionsGettingEvent event);
}
