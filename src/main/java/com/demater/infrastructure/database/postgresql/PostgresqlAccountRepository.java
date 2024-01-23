package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.account.Account;
import com.demater.core.port.AccountRepository;
import com.demater.infrastructure.database.entity.account.AccountEntity;
import com.demater.infrastructure.database.repository.JpaAccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresqlAccountRepository implements AccountRepository {
    private final JpaAccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByBusinessKeyIgnoreCase(String businessKey) {
        return accountRepository.existsByBusinessKeyIgnoreCase(businessKey);
    }
    @Override
    public Optional<Account> findById(UUID id) {
        Optional<AccountEntity> account = accountRepository.findById(id);
        return account.map(a -> objectMapper.convertValue(a, Account.class));
    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(r -> objectMapper.convertValue(r, Account.class))
                .toList();
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountToSave = objectMapper.convertValue(account, AccountEntity.class);
        AccountEntity accountSaved = accountRepository.save(accountToSave);
        return objectMapper.convertValue(accountSaved, Account.class);
    }
}
