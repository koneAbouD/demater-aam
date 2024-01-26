package com.demater.core.port;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.reference.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    boolean existsByNameIgnoreCase(String name);
    Country save(Country country);
    Optional<Country> findById(Long id);
    void delete(Country country);
    List<Country> findAll();
}
