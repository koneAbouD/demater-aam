package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.User;
import com.demater.core.port.UserRepository;
import com.demater.infrastructure.database.entity.user.UserEntity;
import com.demater.infrastructure.database.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlUserRepository implements UserRepository {
    private final JpaUserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public User save(User user) {
        UserEntity userToSave = objectMapper.convertValue(user, UserEntity.class);
        UserEntity userSaved = userRepository.save(userToSave);
        return objectMapper.convertValue(userSaved, User.class);
    }

    @Override
    public Optional<User> findByEmailOrLogin(String value) {
        return userRepository.findByEmailOrLogin(value)
                .map(u -> objectMapper.convertValue(u, User.class));
    }

    @Override
    public boolean existsByEmailOrLogin(String email, String login) {
        return userRepository.existsByEmailOrLogin(email, login);
    }

    @Override
    public Optional<User> findByConfirmationToken(String token) {
        return userRepository.findByConfirmationToken(token)
                .map(u -> objectMapper.convertValue(u, User.class));
    }

    @Override
    public Optional<User> findByEmailAndConfirmationToken(String email, String token) {
        return userRepository.findByEmailAndConfirmationToken(email, token)
                .map(u -> objectMapper.convertValue(u, User.class));
    }

    @Override
    public Set<User> findByLoginIn(Set<String> logins) {
        return userRepository.findByLoginIn(logins)
                .stream()
                .map(u -> objectMapper.convertValue(u, User.class))
                .collect(toSet());
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(u -> objectMapper.convertValue(u, User.class))
                .toList();
    }
}
