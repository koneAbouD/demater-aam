package com.demater.infrastructure.database.entity.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = PositionEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class PositionEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "position";
    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="code", length = 10, nullable = false, unique = true)
    @NotNull(message = "The code can't be null")
    private String code;
    @Column(name="designation", nullable = false, unique = true)
    @NotNull(message = "The designation can't be null")
    private String designation;

    @Column(name="description")
    private String description;

    @JsonBackReference
    @ManyToMany(mappedBy = "positions")
    private Set<UserEntity> users;
}
