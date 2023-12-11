package com.demater.infrastructure.database.entity.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.demater.core.domain.user.ERole;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

import static com.demater.core.domain.user.ERole.ROLE_ADMIN;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = RoleEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class RoleEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "roles";
    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20, nullable = false)
    @NotNull(message = "The role can't be null")
    private ERole name;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    public boolean isAdmin() {
        return ROLE_ADMIN.equals(name);
    }
}
