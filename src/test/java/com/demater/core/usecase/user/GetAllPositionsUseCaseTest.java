package com.demater.core.usecase.user;

import com.demater.builder.PositionMB;
import com.demater.core.domain.user.Position;
import com.demater.core.port.PositionRepository;
import com.demater.core.publisher.PositionEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetAllPositionsUseCaseTest {
    @Mock
    private PositionRepository positionRepository;
    @Mock
    private PositionEventPublisher positionEventPublisher;
    private GetAllPositionsUseCase getAllPositionsUseCase;

    @BeforeEach
    void setUp() {
        getAllPositionsUseCase = new GetAllPositionsUseCase(positionRepository, positionEventPublisher);
    }

    @Test
    void should_get_all_positions() {
        // Given
        Position position1 = new PositionMB().withId(1L).withCode("001").withDesignation("Gérant de station-service").build();
        Position position2 = new PositionMB().withId(2L).withCode("002").withDesignation("Agent de maintenance").build();
        Position position3 = new PositionMB().withId(3L).withCode("003").withDesignation("Pompiste").build();
        List<Position> positionsExisting = of(position1, position2, position3);
        when(positionRepository.findAll()).thenReturn(positionsExisting);

        // When
        List<Position> results = getAllPositionsUseCase.execute();

        // Then
        assertThat(results).hasSize(3);;
        assertThat(results).extracting(Position::getId, Position::getDesignation)
                .containsOnly(tuple(position2.getId(), position2.getDesignation()),
                        tuple(position1.getId(), position1.getDesignation()),
                        tuple(position3.getId(), position3.getDesignation()));
        verify(positionEventPublisher).publishPositionsGettingEvent(any());
    }
}
