package com.demater.infrastructure.database.entity.station;


import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.gadget.GadgetEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = StationGadgetEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class StationGadgetEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "station_gadget";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @NotNull(message = "The station can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "station_id", nullable = false)
    @OnDelete(action = CASCADE)
    private StationEntity station;

    @NotNull(message = "The gadget can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "gadget_id", nullable = false)
    @OnDelete(action = CASCADE)
    private GadgetEntity gadget;

    @NotNull(message = "Gadget number can't be null")
    @Column(name = "gadget_number", nullable = false)
    @Positive
    private Long gadgetNumber;

    public String gadgetName() {
        return getGadget().getDesignation();
    }
}
