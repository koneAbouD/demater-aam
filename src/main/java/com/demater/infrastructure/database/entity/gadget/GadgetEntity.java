package com.demater.infrastructure.database.entity.gadget;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

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
@Table(name = GadgetEntity.TABLE_NAME)
@Access(AccessType.FIELD)
@DynamicUpdate
public class GadgetEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "gadget";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @NotNull(message = "The designation can't be null")
    @Column(name = "designation", nullable = false, unique = true)
    private String designation;

    @NotNull(message = "The gadget type can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "gadget_type_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private GadgetTypeEntity type;

    @Column(name = "description")
    private String description;

    @Column(name = "details")
    private String details;

    @Positive
    @Column(name = "total_number")
    private Long totalNumber;

    @Positive
    @Column(name = "remaining_number")
    private Long remainingNumber;

    @Column(name = "is_available")
    private boolean isAvailable;
}
