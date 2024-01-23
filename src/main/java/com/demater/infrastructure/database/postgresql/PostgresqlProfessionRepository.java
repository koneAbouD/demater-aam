package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.profession.Profession;
import com.demater.core.port.ProfessionRepository;
import com.demater.infrastructure.database.entity.profession.ProfessionEntity;
import com.demater.infrastructure.database.repository.JpaProfessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlProfessionRepository implements ProfessionRepository {
    private final JpaProfessionRepository professionRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Profession save(Profession address) {
        ProfessionEntity professionToSave = objectMapper.convertValue(address, ProfessionEntity.class);
        ProfessionEntity professionEntitySaved = professionRepository.save(professionToSave);
        return objectMapper.convertValue(professionEntitySaved, Profession.class);
    }

    @Override
    public Optional<Profession> findById(UUID id) {
        Optional<ProfessionEntity> profession = professionRepository.findById(id);
        return profession.map(g -> objectMapper.convertValue(g, Profession.class));
    }

    @Override
    public void delete(Profession profession) {
        ProfessionEntity professionToDelete = objectMapper.convertValue(profession, ProfessionEntity.class);
        professionRepository.delete(professionToDelete);
    }

    @Override
    public List<Profession> findAll() {
        return professionRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Profession.class))
                .toList();
    }
    @Override
    public Set<Profession> findAllByIdsIn(List<UUID> ids) {
        return professionRepository.findAllByIdsIn(ids).stream()
                .map(s -> objectMapper.convertValue(s, Profession.class))
                .collect(toSet());
    }
}
