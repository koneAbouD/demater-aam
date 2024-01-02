package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CustomerTypeRepository;
import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.entity.customer.CustomerTypeEntity;
import com.demater.infrastructure.database.repository.JpaAccountTypeRepository;
import com.demater.infrastructure.database.repository.JpaCustomerTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresqlCustomerTypeRepository implements CustomerTypeRepository {
    private final JpaCustomerTypeRepository customerTypeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return customerTypeRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        CustomerTypeEntity customerTypeToSave = objectMapper.convertValue(customerType, CustomerTypeEntity.class);
        CustomerTypeEntity customerTypeEntitySaved = customerTypeRepository.save(customerTypeToSave);
        return objectMapper.convertValue(customerTypeEntitySaved, CustomerType.class);
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        Optional<CustomerTypeEntity> customerType = customerTypeRepository.findById(id);
        return customerType.map(g -> objectMapper.convertValue(g, CustomerType.class));
    }

    @Override
    public void delete(CustomerType customerType) {
        CustomerTypeEntity customerTypeToDelete = objectMapper.convertValue(customerType, CustomerTypeEntity.class);
        customerTypeRepository.delete(customerTypeToDelete);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll()
                .stream()
                .map(c -> objectMapper.convertValue(c, CustomerType.class))
                .toList();
    }
}
