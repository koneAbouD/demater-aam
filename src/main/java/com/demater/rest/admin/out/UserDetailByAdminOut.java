package com.demater.rest.admin.out;

import com.demater.rest.common.out.PositionOut;
import com.demater.rest.common.out.RoleOut;
import com.demater.rest.station.out.StationOut;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record UserDetailByAdminOut(
    UUID id,
    String login,
    String firstName,
    String lastName,
    String email,
    Set<RoleOut> roles,
    Set<PositionOut> positions,
    boolean valid,
    boolean isActivate,
    LocalDateTime activationDate,
    LocalDateTime expirationDate,
    Date createdTimestamp,
    StationOut station
    )
{}
