package com.demater.core.port;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    boolean existsByDesignationIgnoreCase(String name);
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    void delete(Customer customer);
    List<Customer> findAll();
}
