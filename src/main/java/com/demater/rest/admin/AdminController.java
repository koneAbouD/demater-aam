package com.demater.rest.admin;

import com.demater.core.domain.account.AccountType;
import com.demater.core.usecase.param_value.CreateAccountTypeUseCase;
import com.demater.core.usecase.admin.*;
import com.demater.rest.admin.in.AccountTypeCreateIn;
import com.demater.rest.admin.out.AccountTypeDetailOut;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.User;
import com.demater.rest.auth.in.UserCreateIn;
import com.demater.rest.common.out.UserOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Tags(value = {
        @Tag(name = "Administration", description = "Provides Admin operations API's")
})
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    private final CreateUserUseCase createUser;
    private final DeleteUserUseCase deleteUser;
    private final CreateAccountTypeUseCase createAccountType;
    private final ObjectMapper objectMapper;

    @PostMapping("/users")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Create new user")
    public ResponseEntity<UserOut> createUser(@RequestBody @Validated UserCreateIn userCreateIn) {
        User user = objectMapper.convertValue(userCreateIn, User.class);
        user = createUser.execute(user);
        return new ResponseEntity<>(objectMapper.convertValue(user, UserOut.class), CREATED);
    }

    @DeleteMapping("/users/{login}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "User deleting by the admin or super admin")
    public ResponseEntity<Void> deleteUserByAdmin(@PathVariable String login) {
        deleteUser.execute(login);
        return ResponseEntity.noContent().build();
    }
}
