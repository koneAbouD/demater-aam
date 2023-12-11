package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.Position;
import com.demater.core.port.PositionRepository;
import com.demater.infrastructure.database.repository.JpaPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlPositionRepository implements PositionRepository {
    private final JpaPositionRepository positionRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Set<Position> findAllByCodeIn(Set<String> codes) {
        return positionRepository.findAllByCodeIn(codes)
                .stream()
                .map(p -> objectMapper.convertValue(p, Position.class))
                .collect(toSet());
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll()
                .stream()
                .map(p -> objectMapper.convertValue(p, Position.class))
                .toList();
    }
}
