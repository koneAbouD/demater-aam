package com.demater.infrastructure.database.entity.referential;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = CityEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class CityEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "city";
    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotNull(message = "The code can't be null")
    @Column(name="code", nullable = false, unique = true)
    private String code;

    @NotNull(message = "The designation can't be null")
    @Column(name = "designation", nullable = false)
    private String designation;
}
