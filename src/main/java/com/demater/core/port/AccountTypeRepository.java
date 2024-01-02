package com.demater.core.port;

import com.demater.core.domain.account.AccountType;

import java.util.List;
import java.util.Optional;

public interface AccountTypeRepository {
    boolean existsByNameIgnoreCase(String name);
    AccountType save(AccountType accountType);
    Optional<AccountType> findById(Long id);
    void delete(AccountType gadgetType);
    List<AccountType> findAll();
}
