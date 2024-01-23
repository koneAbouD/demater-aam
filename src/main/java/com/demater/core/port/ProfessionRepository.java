package com.demater.core.port;

import com.demater.core.domain.customer.Nationality;
import com.demater.core.domain.profession.Profession;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ProfessionRepository {
    Profession save(Profession profession);
    Optional<Profession> findById(UUID id);
    void delete(Profession profession);
    List<Profession> findAll();
    Set<Profession> findAllByIdsIn(List<UUID> ids);
}
