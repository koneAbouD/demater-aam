package com.demater.core.port;

import com.demater.core.domain.profession.ProfessionalCat;

import java.util.List;
import java.util.Optional;

public interface CatProfessionalRepository {
    boolean existsByNameIgnoreCase(String name);
    ProfessionalCat save(ProfessionalCat professionalCat);
    Optional<ProfessionalCat> findById(Long id);
    void delete(ProfessionalCat professionalCat);
    List<ProfessionalCat> findAll();
}
