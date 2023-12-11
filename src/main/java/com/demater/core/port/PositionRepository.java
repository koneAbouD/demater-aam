package com.demater.core.port;

import com.demater.core.domain.user.Position;

import java.util.List;
import java.util.Set;

public interface PositionRepository {
    Set<Position> findAllByCodeIn(Set<String> codes);
    List<Position> findAll();
}
