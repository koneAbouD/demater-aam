package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.profession.ProfessionalCat;
import com.demater.core.port.CatProfessionalRepository;
import com.demater.infrastructure.database.entity.profession.ProfessionalCatEntity;
import com.demater.infrastructure.database.repository.JpaCatProfessionalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlCatProfessionalRepository implements CatProfessionalRepository {
    private final JpaCatProfessionalRepository catProfessionalRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return catProfessionalRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public ProfessionalCat save(ProfessionalCat professionalCat) {
        ProfessionalCatEntity catProfessionalToSave = objectMapper.convertValue(professionalCat, ProfessionalCatEntity.class);
        ProfessionalCatEntity professionalCatEntitySaved = catProfessionalRepository.save(catProfessionalToSave);
        return objectMapper.convertValue(professionalCatEntitySaved, ProfessionalCat.class);
    }

    @Override
    public Optional<ProfessionalCat> findById(Long id) {
        Optional<ProfessionalCatEntity> catProfessional = catProfessionalRepository.findById(id);
        return catProfessional.map(g -> objectMapper.convertValue(g, ProfessionalCat.class));
    }

    @Override
    public void delete(ProfessionalCat professionalCat) {
        ProfessionalCatEntity catProfessionalToDelete = objectMapper.convertValue(professionalCat, ProfessionalCatEntity.class);
        catProfessionalRepository.delete(catProfessionalToDelete);
    }

    @Override
    public List<ProfessionalCat> findAll() {
        return catProfessionalRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, ProfessionalCat.class))
                .toList();
    }
}
