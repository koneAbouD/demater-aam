package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.customer.Customer;
import com.demater.core.port.CustomerRepository;
import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import com.demater.infrastructure.database.repository.JpaCustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresqlCustomerRepository implements CustomerRepository {
    private final JpaCustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<Customer> findById(UUID id) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        return customer.map(c -> objectMapper.convertValue(c, Customer.class));
    }
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(c -> objectMapper.convertValue(c, Customer.class))
                .toList();
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerToSave = objectMapper.convertValue(customer, CustomerEntity.class);
        CustomerEntity customerSaved = customerRepository.save(customerToSave);
        return objectMapper.convertValue(customerSaved, Customer.class);
    }
}
