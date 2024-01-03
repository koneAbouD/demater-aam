package com.demater.infrastructure.database.entity.profession;

import com.demater.infrastructure.database.entity.CodeNameAbstract;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = CatProfessionnelleEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class CatProfessionnelleEntity extends CodeNameAbstract {
    public static final String TABLE_NAME = "categorie_professionnelle";

    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    public CatProfessionnelleEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void update(String code,String name) {
        this.code = code;
        this.name = name;
    }
}
