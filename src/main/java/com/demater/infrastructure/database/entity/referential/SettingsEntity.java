package com.demater.infrastructure.database.entity.referential;


import com.demater.core.domain.referential.ESetting;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SettingsEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class SettingsEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "settings";
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
    @NotNull(message = "The name can't be null")
    private ESetting name;

    @NotNull(message = "Value can't be null")
    @Column(name = "value", nullable = false)
    private String value;
}
