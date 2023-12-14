package com.demater.infrastructure.database.entity.document;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.customer.CustomerEntity;
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
@Table(name = DocumentEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class DocumentEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "document";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String businessKey;
    private String designation;
}
