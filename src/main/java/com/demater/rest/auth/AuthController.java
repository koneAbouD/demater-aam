package com.demater.rest.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.auth.AuthCredentials;
import com.demater.core.domain.auth.CredentialsForResetPassword;
import com.demater.core.domain.auth.UserCredentials;
import com.demater.core.domain.user.User;
import com.demater.core.usecase.admin.CreateUserUseCase;
import com.demater.core.usecase.auth.*;
import com.demater.rest.auth.in.LoginIn;
import com.demater.rest.auth.in.PasswordResetIn;
import com.demater.rest.auth.out.UserAuthenticatedOut;
import com.demater.rest.auth.out.UserCheckedOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "Authentication", description = "Provides authentication operations API's")})
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final CreateUserUseCase createUser;
    private final AuthenticateUserUseCase authenticateUser;
    private final CheckUserUseCase checkUser;
    private final SendResetPasswordUseCase sendResetPassword;
    private final ResetPasswordUseCase resetPassword;
    private final DeleteANonValidatedAccountUseCase deleteANonValidatedAccount;
    private final ObjectMapper objectMapper;

    @PostMapping("/signin")
    @Operation(summary = "User authentication")
    public ResponseEntity<UserAuthenticatedOut> authenticateUser(@RequestBody @Validated LoginIn loginIn) {
        AuthCredentials user = objectMapper.convertValue(loginIn, AuthCredentials.class);
        UserCredentials userCredentials = authenticateUser.execute(user);
        return new ResponseEntity<>(objectMapper.convertValue(userCredentials, UserAuthenticatedOut.class), OK);
    }

    @GetMapping("/verify/token/{token}")
    @Operation(summary = "Check if user is valid")
    public ResponseEntity<UserCheckedOut> checkUser(@NotNull @PathVariable String token) {
        User user = checkUser.execute(token);
        return new ResponseEntity<>(objectMapper.convertValue(user, UserCheckedOut.class), OK);
    }

    @PutMapping("/send-reset-password/{email}")
    @Operation(summary = "Send user reset password to email")
    public ResponseEntity<Void> sendResetPassword(@NotNull @PathVariable String email) {
        sendResetPassword.execute(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    @Operation(summary = "Update user password")
    public ResponseEntity<Void> resetPassword(@Validated @RequestBody PasswordResetIn passwordResetIn) {
        CredentialsForResetPassword userCredentials = objectMapper.convertValue(passwordResetIn, CredentialsForResetPassword.class);
        resetPassword.execute(userCredentials);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{token}/unvalidated")
    @Operation(summary = "Delete user that not account validated")
    public ResponseEntity<Void> deleteANonValidateAccount(@PathVariable String token) {
        deleteANonValidatedAccount.execute(token);
        return ResponseEntity.ok().build();
    }
}
