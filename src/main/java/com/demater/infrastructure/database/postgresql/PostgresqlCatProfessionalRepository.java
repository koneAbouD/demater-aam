package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.profession.CatProfessional;
import com.demater.core.port.CatProfessionalRepository;
import com.demater.infrastructure.database.entity.profession.CatProfessionalEntity;
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
    public CatProfessional save(CatProfessional catProfessional) {
        CatProfessionalEntity catProfessionalToSave = objectMapper.convertValue(catProfessional, CatProfessionalEntity.class);
        CatProfessionalEntity catProfessionalEntitySaved = catProfessionalRepository.save(catProfessionalToSave);
        return objectMapper.convertValue(catProfessionalEntitySaved, CatProfessional.class);
    }

    @Override
    public Optional<CatProfessional> findById(Long id) {
        Optional<CatProfessionalEntity> catProfessional = catProfessionalRepository.findById(id);
        return catProfessional.map(g -> objectMapper.convertValue(g, CatProfessional.class));
    }

    @Override
    public void delete(CatProfessional catProfessional) {
        CatProfessionalEntity catProfessionalToDelete = objectMapper.convertValue(catProfessional, CatProfessionalEntity.class);
        catProfessionalRepository.delete(catProfessionalToDelete);
    }

    @Override
    public List<CatProfessional> findAll() {
        return catProfessionalRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, CatProfessional.class))
                .toList();
    }
}
