package com.demater.core.domain.user;


import com.demater.core.domain.station.Station;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean valid;
    private String password;
    private String confirmationToken;
    private String accessToken;
    private String refreshToken;
    private Set<Role> roles = new HashSet<>();
    private Set<Position> positions = new HashSet<>();
    private boolean isActivate;
    private LocalDateTime activationDate;
    private LocalDateTime expirationDate;
    private Date createdTimestamp;
    private String passwordGenerated;
    private String passwordEncoded;
    private String token;
    private Station station;

    public User(UUID id,
                String login,
                String firstName,
                String lastName,
                String email,
                boolean valid,
                String confirmationToken,
                String accessToken,
                String refreshToken,
                Set<Role> roles,
                Set<Position> positions,
                boolean isActivate,
                LocalDateTime activationDate,
                LocalDateTime expirationDate,
                Date createdTimestamp,
                String passwordEncoded,
                String passwordGenerated,
                Station station) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.valid = valid;
        this.confirmationToken = confirmationToken;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.roles = roles;
        this.positions = positions;
        this.isActivate = isActivate;
        this.activationDate = activationDate;
        this.expirationDate = expirationDate;
        this.createdTimestamp = createdTimestamp;
        this.password = passwordEncoded;
        this.passwordEncoded = passwordEncoded;
        this.passwordGenerated = passwordGenerated;
        this.station = station;
    }

    public void updateUserForCreatingWith(Set<Position> positions,
                                          Set<Role> roles,
                                          String password,
                                          String accessOrConfirmationToken,
                                          String passwordGenerated) {
        this.positions = positions;
        this.roles = roles;
        this.password = password;
        this.accessToken = accessOrConfirmationToken;
        this.confirmationToken = accessOrConfirmationToken;
        this.passwordGenerated = passwordGenerated;
    }

    public void updateForResetPasswordWith(String token,
                                           String passwordGenerated,
                                           String passwordEncoded) {
        this.token = token;
        this.passwordGenerated = passwordGenerated;
        this.passwordEncoded = passwordEncoded;
    }

    public void updateProfileWith(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void updateProfileWith(String firstName,
                                  String lastName,
                                  Set<Position> positions,
                                  Set<Role> roles,
                                  boolean valid,
                                  boolean activate) {
        updateProfileWith(firstName, lastName);
        this.positions = positions;
        this.roles = roles;
        this.valid = valid;
        if (this.isActivate != activate) {
            this.activationDate = LocalDateTime.now();
        }
        this.isActivate = activate;

    }

    public Set<String> codesPositions() {
        return getPositions().stream().map(Position::getCode).collect(toSet());
    }

    public Set<ERole> rolesNames() {
        return getRoles().stream().map(Role::getName).collect(toSet());
    }

    public boolean hasRoleSuperAdminOrAdmin() {
        return getRoles().stream().anyMatch(Role::isSuperAdminOrAdmin);
    }

    public boolean hasRoleSuperAdmin() {
        return getRoles().stream().anyMatch(Role::isSuperAdmin);
    }

    public boolean hasRoleAdmin() {
        return getRoles().stream().anyMatch(Role::isAdmin);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
