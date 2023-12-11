package com.demater.rest.common.out;

import java.util.Set;
import java.util.UUID;


public record UserOut(
    UUID id,
    String login,
    String firstName,
    String lastName,
    String email,
    Set<PositionOut> positions,
    Set<RoleOut> roles,
    boolean isActivate
){}
