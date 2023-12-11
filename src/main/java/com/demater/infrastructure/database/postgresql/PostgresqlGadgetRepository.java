package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.port.GadgetRepository;
import com.demater.infrastructure.database.entity.gadget.GadgetEntity;
import com.demater.infrastructure.database.repository.JpaGadgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresqlGadgetRepository implements GadgetRepository {
    private final JpaGadgetRepository gadgetRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByDesignationIgnoreCase(String designation) {
        return gadgetRepository.existsByDesignationIgnoreCase(designation);
    }

    @Override
    public Gadget save(Gadget gadget) {
        GadgetEntity gadgetToSave = objectMapper.convertValue(gadget, GadgetEntity.class);
        GadgetEntity gadgetSaved = gadgetRepository.save(gadgetToSave);
        return objectMapper.convertValue(gadgetSaved, Gadget.class);
    }

    @Override
    public Optional<Gadget> findById(UUID id) {
        Optional<GadgetEntity> gadget = gadgetRepository.findById(id);
        return gadget.map(g -> objectMapper.convertValue(g, Gadget.class));
    }

    @Override
    public List<Gadget> findAll() {
        return gadgetRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Gadget.class))
                .toList();
    }
}
