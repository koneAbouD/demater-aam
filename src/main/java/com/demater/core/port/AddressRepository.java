package com.demater.core.port;

import com.demater.core.domain.customer.Nationality;
import com.demater.core.domain.reference.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepository {
    Address save(Address address);
    Optional<Address> findById(UUID id);
    void delete(Address address);
    List<Address> findAll();
}
