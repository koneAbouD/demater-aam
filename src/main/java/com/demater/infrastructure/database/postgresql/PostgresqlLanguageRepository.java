package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.Language;
import com.demater.core.port.LanguageRepository;
import com.demater.infrastructure.database.entity.customer.LanguageEntity;
import com.demater.infrastructure.database.repository.JpaLanguageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlLanguageRepository implements LanguageRepository {
    private final JpaLanguageRepository languageRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return languageRepository.existsByNameIgnoreCase(name);
    }
    @Override
    public Language save(Language language) {
        LanguageEntity languageToSave = objectMapper.convertValue(language, LanguageEntity.class);
        LanguageEntity languageEntitySaved = languageRepository.save(languageToSave);
        return objectMapper.convertValue(languageEntitySaved, Language.class);
    }
    @Override
    public Optional<Language> findById(Long id) {
        Optional<LanguageEntity> language = languageRepository.findById(id);
        return language.map(g -> objectMapper.convertValue(g, Language.class));
    }
    @Override
    public void delete(Language language) {
        LanguageEntity languageToDelete = objectMapper.convertValue(language, LanguageEntity.class);
        languageRepository.delete(languageToDelete);
    }
    @Override
    public List<Language> findAll() {
        return languageRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Language.class))
                .toList();
    }
}
