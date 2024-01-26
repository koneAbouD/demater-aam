package com.demater.infrastructure.database.entity.reference;

import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 20, nullable = false)
    @NotNull(message = "The type can't be null")
    private EAddressType type;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private CountryEntity country;

    @Column(name = "description")
    private String description;

    @Column(name = "postal_code")
    private String postalCode;
}
