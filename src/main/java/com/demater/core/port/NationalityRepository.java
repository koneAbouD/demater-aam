package com.demater.core.port;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.Nationality;

import java.util.List;
import java.util.Optional;

public interface NationalityRepository {
    boolean existsByNameIgnoreCase(String name);
    Nationality save(Nationality nationality);
    Optional<Nationality> findById(Long id);
    void delete(Nationality nationality);
    List<Nationality> findAll();
}
