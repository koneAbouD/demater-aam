package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.entity.gadget.GadgetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaAccountTypeRepository extends JpaRepository<AccountTypeEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM account_type at WHERE at.id = :id")
    Optional<AccountTypeEntity> findById(@Param("id") Long id);
    boolean existsByDesignationIgnoreCase(String name);
}
