package com.demater.core.domain.auth;

public record CredentialsForResetPassword(String email, String token, String password) {
}
