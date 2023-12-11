package com.demater.rest.city;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.referential.City;
import com.demater.core.usecase.referential.GetCitiesUseCase;
import com.demater.rest.common.out.CityOut;
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

@Tags(value = {@Tag(name = "City", description = "Stations cities")})
@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityController {
    private final GetCitiesUseCase getCities;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting all cities")
    public ResponseEntity<List<CityOut>> getAllCities() {
        List<City> cities = getCities.execute();
        List<CityOut> results = cities.stream()
                .map(c -> objectMapper.convertValue(c, CityOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
