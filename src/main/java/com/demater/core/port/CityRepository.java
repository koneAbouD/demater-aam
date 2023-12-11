package com.demater.core.port;

import com.demater.core.domain.referential.City;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CityRepository {
    List<City> findByDesignationIgnoreCaseIn(Set<String> designations);
    List<City> findAll();
    Optional<City> findById(Long id);
}
