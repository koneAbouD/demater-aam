package com.demater.infrastructure.database.postgresql;

import com.demater.core.domain.reference.Address;
import com.demater.core.port.AddressRepository;
import com.demater.infrastructure.database.entity.reference.AddressEntity;
import com.demater.infrastructure.database.repository.JpaAddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresqlAddressRepository implements AddressRepository {
    private final JpaAddressRepository addressRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Address save(Address address) {
        AddressEntity addressToSave = objectMapper.convertValue(address, AddressEntity.class);
        AddressEntity addressEntitySaved = addressRepository.save(addressToSave);
        return objectMapper.convertValue(addressEntitySaved, Address.class);
    }

    @Override
    public Optional<Address> findById(UUID id) {
        Optional<AddressEntity> address = addressRepository.findById(id);
        return address.map(g -> objectMapper.convertValue(g, Address.class));
    }

    @Override
    public void delete(Address address) {
        AddressEntity addressToDelete = objectMapper.convertValue(address, AddressEntity.class);
        addressRepository.delete(addressToDelete);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(g -> objectMapper.convertValue(g, Address.class))
                .toList();
    }
}
