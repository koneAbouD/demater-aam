package com.demater.core.port;

import com.demater.core.domain.profession.CatProfessional;

import java.util.List;
import java.util.Optional;

public interface CatProfessionalRepository {
    boolean existsByNameIgnoreCase(String name);
    CatProfessional save(CatProfessional catProfessional);
    Optional<CatProfessional> findById(Long id);
    void delete(CatProfessional catProfessional);
    List<CatProfessional> findAll();
}
