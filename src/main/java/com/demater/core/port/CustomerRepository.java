package com.demater.core.port;

import com.demater.core.domain.customer.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);

    List<Customer> findAll();
}
