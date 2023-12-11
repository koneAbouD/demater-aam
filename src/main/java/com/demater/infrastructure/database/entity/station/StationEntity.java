package com.demater.infrastructure.database.entity.station;

import com.demater.core.domain.referential.EStatus;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.referential.CityEntity;
import com.demater.infrastructure.database.entity.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = StationEntity.TABLE_NAME)
@Access(AccessType.FIELD)
@DynamicUpdate
public class StationEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "station";
    public static final String DESIGNATION_SEPARATOR_FOR_DELETING = "_";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @NotNull(message = "The designation can't be null")
    @Column(name = "designation", nullable = false)
    private String designation;

    @NotNull(message = "The city can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private CityEntity city;

    @NotNull(message = "The address can't be null")
    @Column(name="address", nullable = false, unique = true)
    private String address;

    @NotNull(message = "The costCenter can't be null")
    @Column(name="cost_center", nullable = false, unique = true)
    private String costCenter;

    @OneToMany(mappedBy = "station", fetch = EAGER)
    @OnDelete(action = NO_ACTION)
    private Set<UserEntity> users = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    @NotNull(message = "The status can't be null")
    private EStatus status;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
