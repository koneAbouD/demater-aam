package com.demater.infrastructure.database.entity.customer;

import com.demater.core.domain.customer.ELevelStudent;
import com.demater.core.domain.customer.Language;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.customer.Nationality;
import com.demater.core.domain.profession.Profession;
import com.demater.core.domain.reference.Address;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import com.demater.infrastructure.database.entity.profession.ProfessionEntity;
import com.demater.infrastructure.database.entity.reference.AddressEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
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
@Table(name = CustomerEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class CustomerEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "customer";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String firstName;
    private String lastNames;
    private String matherFullNames;
    private String numTelephone;
    private String email;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "nationality_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private NationalityEntity nationality;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "language_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private LanguageEntity language;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private AddressEntity address;

    @Enumerated(EnumType.STRING)
    private ELevelStudent levelStudent;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "legal_capacity_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private LegalCapacityEntity legalCapacity;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "customer_type_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private CustomerTypeEntity type;

    @ManyToMany(fetch = EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "customer_profession",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<ProfessionEntity> profession;
    private String customerCode;
}
