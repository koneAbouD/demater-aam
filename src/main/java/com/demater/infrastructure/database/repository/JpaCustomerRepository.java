package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.account.AccountEntity;
import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
