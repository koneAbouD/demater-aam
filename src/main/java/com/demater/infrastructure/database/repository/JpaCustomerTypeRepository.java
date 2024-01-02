package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.entity.customer.CustomerTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCustomerTypeRepository extends JpaRepository<CustomerTypeEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM customer_type at WHERE at.id = :id")
    Optional<CustomerTypeEntity> findById(@Param("id") Long id);
    boolean existsByNameIgnoreCase(String name);
}
