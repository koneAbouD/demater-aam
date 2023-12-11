package com.demater.core.usecase.user;

import com.demater.core.domain.user.Role;
import com.demater.core.event.user.RolesGettingEvent;
import com.demater.core.port.RoleRepository;
import com.demater.core.publisher.RoleEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllRolesUseCase {
    private final RoleRepository roleRepository;
    private final RoleEventPublisher roleEventPublisher;

    public List<Role> execute() {
        List<Role> roles = roleRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(r -> r.getName().name()))
            .toList();
        roleEventPublisher.publishRolesGettingEvent(new RolesGettingEvent());
        return roles;
    }
}
