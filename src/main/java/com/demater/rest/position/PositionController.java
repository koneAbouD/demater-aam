package com.demater.rest.position;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.Position;
import com.demater.core.usecase.user.GetAllPositionsUseCase;
import com.demater.rest.common.out.PositionOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "Position", description = "User position in store of station")})
@RestController
@RequestMapping("positions")
@RequiredArgsConstructor
public class PositionController {
    private final GetAllPositionsUseCase getAllPositions;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting user positions")
    public ResponseEntity<List<PositionOut>> getPositions() {
        List<Position> positions = getAllPositions.execute();
        List<PositionOut> results = positions.stream()
                .map(p -> objectMapper.convertValue(p, PositionOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
