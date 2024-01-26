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

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_names")
    private String lastNames;

    @Column(name="mather_full_names")
    private String matherFullNames;

    @Column(name="num_telephone")
    private String numTelephone;

    @Column(name="email")
    private String email;

    @Column(name="code")
    private String code;

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
    @Column(name = "level_student", length = 20, nullable = false)
    private ELevelStudent levelStudent;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "legal_capacity_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private LegalCapacityEntity legalCapacity;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "customer_type_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private CustomerTypeEntity type;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "family_status_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private FamilyStatusEntity familyStatus;

    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "marital_status_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private MaritalStatusEntity maritalStatus;

    @ManyToMany(fetch = EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "customer_profession",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<ProfessionEntity> profession;
}
