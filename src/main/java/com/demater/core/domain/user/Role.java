package com.demater.core.domain.user;

import lombok.*;

import static com.demater.core.domain.user.ERole.ROLE_ADMIN;
import static com.demater.core.domain.user.ERole.ROLE_SUPER_ADMIN;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Role {
    private Long id;
    private ERole name;

    public boolean isSuperAdminOrAdmin() {
        return ROLE_SUPER_ADMIN.equals(name) || ERole.ROLE_ADMIN.equals(name);
    }

    public boolean isSuperAdmin() {
        return ROLE_SUPER_ADMIN.equals(name);
    }

    public boolean isAdmin() {
        return ROLE_ADMIN.equals(name);
    }
}
