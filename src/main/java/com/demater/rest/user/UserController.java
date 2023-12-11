package com.demater.rest.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.auth.CredentialsForUpdatePassword;
import com.demater.core.domain.user.User;
import com.demater.core.usecase.user.GetUserDetailsUseCase;
import com.demater.core.usecase.user.UpdateUserPasswordUseCase;
import com.demater.core.usecase.user.UpdateUserProfileUseCase;
import com.demater.rest.common.out.UserDetailsOut;
import com.demater.rest.user.in.PasswordUpdateIn;
import com.demater.rest.user.in.UpdateUserProfileIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "User", description = "Provides user operations API's")})
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UpdateUserPasswordUseCase updateUserPassword;
    private final GetUserDetailsUseCase getUserDetails;
    private final UpdateUserProfileUseCase updateUserProfile;
    private final ObjectMapper objectMapper;

    @PutMapping("/update-password")
    @Operation(summary = "Update user password by user already connected")
    public ResponseEntity<Void> updatePassword(@Validated @RequestBody PasswordUpdateIn request) {
        updateUserPassword.execute(objectMapper.convertValue(request, CredentialsForUpdatePassword.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user-retrieve")
    @Operation(summary = "Retrieve user connected")
    public ResponseEntity<UserDetailsOut> getUserDetails(Principal principal) {
        User user = getUserDetails.execute(principal.getName());
        return new ResponseEntity<>(objectMapper.convertValue(user, UserDetailsOut.class), OK);
    }

    @PutMapping("/update-profile")
    @Operation(summary = "Update user connected")
    public ResponseEntity<UserDetailsOut> updateUser(@Validated @RequestBody UpdateUserProfileIn request) {
        User user = objectMapper.convertValue(request, User.class);
        User userUpdated = updateUserProfile.execute(user);
        return new ResponseEntity<>(objectMapper.convertValue(userUpdated, UserDetailsOut.class), OK);
    }
}
