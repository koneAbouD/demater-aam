package com.demater.infrastructure.database.entity.gadget;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = GadgetTypeEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class GadgetTypeEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "gadget_type";
    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotNull(message = "The designation can't be null")
    @Column(name = "designation", nullable = false)
    private String designation;

    public void update(String designation) {
        this.designation = designation;
    }
}
