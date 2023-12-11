package com.demater.rest.auth.out;

import java.util.UUID;

public record UserCheckedOut(UUID id, String email, boolean valid) {
}
