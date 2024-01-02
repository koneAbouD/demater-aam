package com.demater.core.port;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;

import java.util.List;
import java.util.Optional;

public interface CustomerTypeRepository {
    boolean existsByNameIgnoreCase(String name);
    CustomerType save(CustomerType customerType);
    Optional<CustomerType> findById(Long id);
    void delete(CustomerType gadgetType);
    List<CustomerType> findAll();
}
