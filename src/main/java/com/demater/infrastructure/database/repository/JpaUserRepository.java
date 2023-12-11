package com.demater.infrastructure.database.repository;

import com.demater.infrastructure.database.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(value = "SELECT * FROM users u WHERE u.login = ?1 or u.email = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmailOrLogin(String value);
    boolean existsByEmailOrLogin(String email, String login);
    Optional<UserEntity> findByConfirmationToken(String token);
    Optional<UserEntity> findByEmailAndConfirmationToken(String email, String token);
    Set<UserEntity> findByLoginIn(Set<String> logins);

    @Modifying
    @Query(value = "UPDATE users SET station_id = :stationId WHERE login IN (:usersLogin)", nativeQuery = true)
    void updateUsersStation(@Param("usersLogin") Set<String> usersLogin, @Param("stationId") UUID stationId);
}
