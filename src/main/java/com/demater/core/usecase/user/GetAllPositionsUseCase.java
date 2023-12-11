package com.demater.core.usecase.user;

import com.demater.core.domain.user.Position;
import com.demater.core.event.user.PositionsGettingEvent;
import com.demater.core.port.PositionRepository;
import com.demater.core.publisher.PositionEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllPositionsUseCase {
    private final PositionRepository positionRepository;
    private final PositionEventPublisher positionEventPublisher;

    public List<Position> execute() {
        List<Position> positions = positionRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Position::getDesignation))
                .toList();
        positionEventPublisher.publishPositionsGettingEvent(new PositionsGettingEvent());
        return positions;
    }
}
