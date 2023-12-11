package com.demater.core.port;

import com.demater.core.domain.user.ERole;
import com.demater.core.domain.user.Role;

import java.util.List;
import java.util.Set;

public interface RoleRepository {
    Set<Role> findAllByNameIn(Set<ERole> names);
    List<Role> findAll();
}
