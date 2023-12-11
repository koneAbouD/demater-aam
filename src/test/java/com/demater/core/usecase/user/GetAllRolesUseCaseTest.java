package com.demater.core.usecase.user;

import com.demater.builder.RoleMB;
import com.demater.core.domain.user.Role;
import com.demater.core.port.RoleRepository;
import com.demater.core.publisher.RoleEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static com.demater.core.domain.user.ERole.ROLE_ADMIN;
import static com.demater.core.domain.user.ERole.ROLE_USER;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetAllRolesUseCaseTest {
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private RoleEventPublisher roleEventPublisher;
    private GetAllRolesUseCase getAllRolesUseCase;

    @BeforeEach
    void setUp() {
        getAllRolesUseCase = new GetAllRolesUseCase(roleRepository, roleEventPublisher);
    }

    @Test
    void should_get_all_roles() {
        // Given
        List<Role> rolesExisting = of(new RoleMB().withId(1L).withName(ROLE_USER).build(),
                new RoleMB().withId(2L).withName(ROLE_ADMIN).build());
        when(roleRepository.findAll()).thenReturn(rolesExisting);

        // When
        List<Role> results = getAllRolesUseCase.execute();

        // Then
        assertThat(results).hasSize(2);
        assertThat(results).extracting(Role::getId, Role::getName)
                .containsOnly(tuple(2L, ROLE_ADMIN), tuple(1L, ROLE_USER));
        verify(roleEventPublisher).publishRolesGettingEvent(any());
    }
}
