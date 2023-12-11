package com.demater.core.domain.auth;


import java.util.Set;
import java.util.UUID;

public record UserCredentials (
        UUID id,
        String login,
        String firstName,
        String lastName,
        String email,
        String token,
        String type,
        Set<String> roles
){
    @Override
    public String toString() {
        return email + " - [" + roles + "]";
    }
}
