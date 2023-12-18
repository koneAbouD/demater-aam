package com.demater.core.port;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.folder.Folder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    boolean existsByBusinessKeyIgnoreCase(String businessKey);
    Optional<Account> findById(UUID id);
    List<Account> findAll();
    Account save(Account account);
}
