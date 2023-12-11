package com.demater.infrastructure.provider;

import com.demater.configuration.security.CustomUserDetails;
import com.demater.core.domain.auth.AuthCredentials;
import com.demater.core.domain.auth.UserCredentials;
import com.demater.core.domain.user.User;
import com.demater.core.port.Authentication;
import com.demater.core.port.Password;
import com.demater.core.port.UserRepository;
import com.demater.core.usecase.common.exception.UserNotActivatedException;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.demater.core.domain.common.Constants.USER_IS_NOT_FOUND;
import static com.demater.core.domain.common.Constants.USER_NOT_ACTIVATE;
import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@Component
public class AuthenticationImpl implements Authentication {
    private static final String TYPE_TOKEN = "Bearer";
    private final UserRepository userRepository;
    private final Password password;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserCredentials authenticate(AuthCredentials user) {
        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.login(), user.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        CustomUserDetails userSaved = checkTokenValidating(userDetails);

        Set<String> roles = userSaved.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toSet());

        return new UserCredentials(userSaved.getId(),
                userSaved.getLogin(),
                userSaved.getFirstName(),
                userSaved.getLastName(),
                userSaved.getEmail(),
                userSaved.getToken(),
                TYPE_TOKEN,
                roles);
    }

    private CustomUserDetails checkTokenValidating(CustomUserDetails userDetails) {
        User user = userRepository.findByEmailOrLogin(userDetails.getLogin())
                .orElseThrow(() -> new UserNotFoundException(USER_IS_NOT_FOUND));

        if (!user.isValid()) {
            throw new UserNotActivatedException(USER_NOT_ACTIVATE);
        }

        if (!password.validateJwtToken(userDetails.getToken())) {
            String token = password.generateJwtToken(userDetails.getLogin());
            user.setAccessToken(token);
            userDetails.setToken(token);
            userRepository.save(user);
        }
        return userDetails;
    }
}
