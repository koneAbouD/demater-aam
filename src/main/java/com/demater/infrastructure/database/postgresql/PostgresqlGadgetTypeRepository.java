package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.infrastructure.database.entity.gadget.GadgetTypeEntity;
import com.demater.infrastructure.database.repository.JpaGadgetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlGadgetTypeRepository implements GadgetTypeRepository {
    private final JpaGadgetTypeRepository gadgetTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByDesignationIgnoreCase(String name) {
        return gadgetTypeRepository.existsByDesignationIgnoreCase(name);
    }

    @Override
    public GadgetType save(GadgetType gadgetType) {
        GadgetTypeEntity gadgetTypeToSave = objectMapper.convertValue(gadgetType, GadgetTypeEntity.class);
        GadgetTypeEntity gadgetTypeSaved = gadgetTypeRepository.save(gadgetTypeToSave);
        return objectMapper.convertValue(gadgetTypeSaved, GadgetType.class);
    }

    @Override
    public Optional<GadgetType> findById(Long id) {
        Optional<GadgetTypeEntity> gadgetType = gadgetTypeRepository.findById(id);
        return gadgetType.map(g -> objectMapper.convertValue(g, GadgetType.class));
    }

    @Override
    public void delete(GadgetType gadgetType) {
        GadgetTypeEntity gadgetTypeToDelete = objectMapper.convertValue(gadgetType, GadgetTypeEntity.class);
        gadgetTypeRepository.delete(gadgetTypeToDelete);
    }

    @Override
    public List<GadgetType> findAll() {
        return gadgetTypeRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, GadgetType.class))
                .toList();
    }
}
