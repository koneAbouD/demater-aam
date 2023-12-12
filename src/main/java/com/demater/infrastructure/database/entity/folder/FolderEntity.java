package com.demater.infrastructure.database.entity.folder;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.station.StationEntity;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = FolderEntity.TABLE_NAME)
@Access(AccessType.FIELD)
@DynamicUpdate
public class FolderEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "folder";
    public static final String DESIGNATION_SEPARATOR_FOR_DELETING = "_";

    private UUID id;
    private String businessKey;
    private String designation;
}
