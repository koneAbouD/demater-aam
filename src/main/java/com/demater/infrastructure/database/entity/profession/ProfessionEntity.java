package com.demater.infrastructure.database.entity.profession;

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
@Table(name = ProfessionEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class ProfessionEntity {
    public static final String TABLE_NAME = "profession";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String businessKey;
    private String designation;
}
