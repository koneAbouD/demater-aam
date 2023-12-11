package com.demater.core.port;

import com.demater.core.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmailOrLogin(String value);
    boolean existsByEmailOrLogin(String email, String login);
    Optional<User> findByConfirmationToken(String token);
    Optional<User> findByEmailAndConfirmationToken(String email, String token);
    Set<User> findByLoginIn(Set<String> logins);
    void delete(UUID uuid);
    List<User> findAll();
    void updateUsersStation(Set<String> usersLogin, UUID stationId);
}
