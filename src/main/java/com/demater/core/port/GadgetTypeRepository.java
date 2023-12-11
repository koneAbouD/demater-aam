package com.demater.core.port;

import com.demater.core.domain.gadget.GadgetType;

import java.util.List;
import java.util.Optional;

public interface GadgetTypeRepository {
    boolean existsByDesignationIgnoreCase(String name);
    GadgetType save(GadgetType gadgetType);
    Optional<GadgetType> findById(Long id);
    void delete(GadgetType gadgetType);
    List<GadgetType> findAll();
}
