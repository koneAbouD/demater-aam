package com.demater.infrastructure.database.entity.reference;

import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = AddressEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class AddressEntity {
    public static final String TABLE_NAME = "address";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private EAddressType type;
    private String city;
    private String county;
    private CountryEntity country;
    private String description;
    private String postalCode;
}
