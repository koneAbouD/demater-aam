package com.demater.rest.auth.out;

import java.util.Set;
import java.util.UUID;

public record UserAuthenticatedOut(
        String firstName,
        String lastName,
        String token,
        String type,
        UUID id,
        String email,
        Set<String> roles
) { }
