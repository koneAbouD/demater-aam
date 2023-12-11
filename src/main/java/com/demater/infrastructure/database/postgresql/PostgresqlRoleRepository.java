package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.ERole;
import com.demater.core.domain.user.Role;
import com.demater.core.port.RoleRepository;
import com.demater.infrastructure.database.repository.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlRoleRepository implements RoleRepository {
    private final JpaRoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Set<Role> findAllByNameIn(Set<ERole> names) {
        return roleRepository.findAllByNameIn(names)
                .stream()
                .map(r -> objectMapper.convertValue(r, Role.class))
                .collect(toSet());
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(r -> objectMapper.convertValue(r, Role.class))
                .toList();
    }
}
