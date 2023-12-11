package com.demater.infrastructure.database.entity.gadget;


import com.demater.core.domain.gadget.EIntegrationStatus;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.station.StationEntity;
import com.demater.infrastructure.database.entity.station.StationGadgetEntity;
import com.demater.infrastructure.database.entity.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.demater.core.domain.gadget.EIntegrationStatus.UNCONFIRMED;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = GadgetConfirmationEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class GadgetConfirmationEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "gadget_confirmation";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @NotNull(message = "The station gadget can't be null")
    @ManyToOne(fetch = EAGER, cascade = MERGE, optional = false)
    @JoinColumn(name = "station_gadget_id", nullable = false)
    private StationGadgetEntity stationGadget;

    @NotNull(message = "Gadget number received can't be null")
    @Column(name = "gadget_number_received", nullable = false)
    @Positive
    private Long gadgetNumberReceived;

    @NotNull(message = "Gadget integration date can't be null")
    @Column(name = "integration_date", nullable = false)
    private LocalDateTime integrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    @NotNull(message = "The status can't be null")
    private EIntegrationStatus status = UNCONFIRMED;

    @Column(name = "confirmation_date")
    private LocalDateTime confirmationDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = NO_ACTION)
    private UserEntity user;

    public StationEntity station() {
        return getStationGadget().getStation();
    }

    public GadgetEntity gadget() {
        return getStationGadget().getGadget();
    }

    public String gadgetName() {
        return getStationGadget().gadgetName();
    }
}
