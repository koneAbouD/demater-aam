package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.customer.NationalityEntity;
import com.demater.infrastructure.database.entity.reference.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaAddressRepository extends JpaRepository<AddressEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM address at WHERE at.id = :id")
    Optional<AddressEntity> findById(@Param("id") UUID id);
}
