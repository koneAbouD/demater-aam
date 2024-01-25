package com.demater.rest.common.out;

import java.util.Set;
import java.util.UUID;

public record UserDetailsOut(
    UUID id,
    String login,
    String firstName,
    String lastName,
    String email,
    Set<RoleOut> roles)
{}
