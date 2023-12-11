package com.demater.configuration.security;

import com.demater.infrastructure.database.entity.user.UserEntity;
import com.demater.infrastructure.database.repository.JpaUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final JpaUserRepository jpaUserRepository;

    public UserDetailsServiceImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = jpaUserRepository.findByEmailOrLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));
        return CustomUserDetails.build(user);
    }
}
