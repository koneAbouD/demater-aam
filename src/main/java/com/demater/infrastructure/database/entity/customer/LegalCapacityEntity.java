package com.demater.infrastructure.database.entity.customer;

import com.demater.core.domain.common.CodeNameAbstract;
import com.demater.infrastructure.database.entity.CodeNameAbstractEntity;
import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = LegalCapacityEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class LegalCapacityEntity extends CodeNameAbstractEntity {
    public static final String TABLE_NAME = "Legal_capacity";

    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
}