package com.demater.core.port;

import com.demater.core.domain.gadget.Gadget;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GadgetRepository {
    boolean existsByDesignationIgnoreCase(String designation);
    Gadget save(Gadget gadget);
    Optional<Gadget> findById(UUID id);
    List<Gadget> findAll();
}
