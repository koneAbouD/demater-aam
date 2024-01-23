package com.demater.core.port;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {
    boolean existsByNameIgnoreCase(String name);
    Language save(Language language);
    Optional<Language> findById(Long id);
    void delete(Language language);
    List<Language> findAll();
}
