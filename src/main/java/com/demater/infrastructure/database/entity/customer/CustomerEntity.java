package com.demater.infrastructure.database.entity.customer;

import com.demater.core.domain.profession.Profession;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.profession.ProfessionEntity;
import jakarta.persistence.*;
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

    @ManyToMany(fetch = EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "customer_profession",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<ProfessionEntity> profession;
    private String customerCode;
}
