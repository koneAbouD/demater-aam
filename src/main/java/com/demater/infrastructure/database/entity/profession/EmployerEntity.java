package com.demater.infrastructure.database.entity.profession;

import com.demater.core.domain.profession.EmployerType;
import com.demater.infrastructure.database.entity.customer.CustomerTypeEntity;
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
@Table(name = EmployerEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class EmployerEntity {
    public static final String TABLE_NAME = "employer";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String name;
    private String numTelephone;
    private String email;
    private String address;
    @ManyToOne(fetch = EAGER, optional = true)
    @JoinColumn(name = "employer_type_id", nullable = true)
    @OnDelete(action = NO_ACTION)
    private EmployerTypeEntity type;
}
