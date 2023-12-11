package com.demater.core.usecase.admin;

import com.demater.builder.RoleMB;
import com.demater.builder.UserMB;
import com.demater.core.domain.user.Role;
import com.demater.core.domain.user.User;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.UserEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.Set;

import static com.demater.core.domain.user.ERole.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetAllUserDetailsUseCaseTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserEventPublisher userEventPublisher;
    private GetAllUserDetailsUseCase getAllUserDetailsUseCase;

    @BeforeEach
    void setUp() {
        getAllUserDetailsUseCase = new GetAllUserDetailsUseCase(userRepository, userEventPublisher);
    }

    @Test
    void should_get_all_users_details() {
        // Given
        Role role1 = new RoleMB().withName(ROLE_USER).build();
        Role role2 = new RoleMB().withName(ROLE_MANAGER).build();
        Role role3 = new RoleMB().withName(ROLE_ADMIN).build();
        User user1 = new UserMB().withFirstName("c").withLastName("sqdsq")
                .withLogin("ccon").withEmail("ss1@gmail.com")
                .withRoles(Set.of(role1)).build();
        User user2 = new UserMB().withFirstName("b").withLastName("sqdsq")
                .withLogin("bcon").withEmail("ss2@gmail.com")
                .withRoles(Set.of(role2)).build();
        User user3 = new UserMB().withFirstName("a").withLastName("sqdsq")
                .withLogin("acon").withEmail("ss3@gmail.com")
                .withRoles(Set.of(role3)).build();
        when(user1.hasRoleSuperAdmin()).thenReturn(false);
        when(user2.hasRoleSuperAdmin()).thenReturn(false);
        when(user3.hasRoleSuperAdmin()).thenReturn(true);
        List<User> users = List.of(user1, user2, user3);
        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> results = getAllUserDetailsUseCase.execute();

        // Then
        assertEquals(2, results.size());
        List<String> UsersNames = results.stream().map(User::getFirstName).toList();
        assertThat(UsersNames).containsExactlyInAnyOrderElementsOf(List.of(user2.getFirstName(), user1.getFirstName()));
        verify(userEventPublisher).publishUsersGetting(any());
    }
}
