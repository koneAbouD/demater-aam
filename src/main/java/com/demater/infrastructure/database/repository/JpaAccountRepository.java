package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByBusinessKeyIgnoreCase(String businessKey);
}
