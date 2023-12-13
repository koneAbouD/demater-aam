package com.demater.infrastructure.database.entity.folder;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.user.RoleEntity;
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
@Table(name = RoleEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class FolderEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "folder";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String businessKey;
    private String designation;
}
