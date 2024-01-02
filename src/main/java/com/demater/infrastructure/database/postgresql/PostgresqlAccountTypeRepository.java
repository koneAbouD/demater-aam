package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.repository.JpaAccountTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlAccountTypeRepository implements AccountTypeRepository {
    private final JpaAccountTypeRepository accountTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return accountTypeRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public AccountType save(AccountType accountType) {
        AccountTypeEntity accountTypeToSave = objectMapper.convertValue(accountType, AccountTypeEntity.class);
        AccountTypeEntity AccountTypeEntitySaved = accountTypeRepository.save(accountTypeToSave);
        return objectMapper.convertValue(AccountTypeEntitySaved, AccountType.class);
    }

    @Override
    public Optional<AccountType> findById(Long id) {
        Optional<AccountTypeEntity> accountType = accountTypeRepository.findById(id);
        return accountType.map(g -> objectMapper.convertValue(g, AccountType.class));
    }

    @Override
    public void delete(AccountType accountType) {
        AccountTypeEntity AccountTypeToDelete = objectMapper.convertValue(accountType, AccountTypeEntity.class);
        accountTypeRepository.delete(AccountTypeToDelete);
    }

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, AccountType.class))
                .toList();
    }
}
