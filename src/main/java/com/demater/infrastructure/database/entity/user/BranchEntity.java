package com.demater.infrastructure.database.entity.user;

import com.demater.infrastructure.database.entity.CodeNameAbstractEntity;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.document.DocumentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = BranchEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class BranchEntity extends CodeNameAbstractEntity {
    public static final String TABLE_NAME = "branch";

    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
}
