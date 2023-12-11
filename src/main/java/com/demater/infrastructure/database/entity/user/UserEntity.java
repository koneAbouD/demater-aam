package com.demater.infrastructure.database.entity.user;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.station.StationEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static com.demater.core.port.Password.REGEX_MESSAGE;
import static com.demater.core.port.Password.REGEX_PASSWORD;
import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = UserEntity.TABLE_NAME)
@Access(AccessType.FIELD)
@DynamicUpdate
public class UserEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "users";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @Column(name="login", unique = true)
    @NotNull(message = "The login can't be null")
    private String login;

    @NotNull(message = "The firstName can't be null")
    @Column(name="first_name", nullable = false)
    private String firstName;

    @NotNull(message = "The lastName can't be null")
    @Column(name="last_name", nullable = false)
    private String lastName;

    @NotNull(message = "The email can't be null")
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_valid")
    private boolean valid;

    @NotNull(message = "Password can't be null")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "confirmation_token", nullable = false, unique = true)
    private String confirmationToken;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "user_position",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<PositionEntity> positions = new HashSet<>();

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "station_id")
    @OnDelete(action = NO_ACTION)
    private StationEntity station;

    @Column(name = "is_activate")
    private boolean isActivate;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Transient
    @Pattern(regexp = REGEX_PASSWORD, message = REGEX_MESSAGE)
    private String passwordGenerated;
}
