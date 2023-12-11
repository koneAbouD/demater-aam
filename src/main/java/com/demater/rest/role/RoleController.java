package com.demater.rest.role;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.user.Role;
import com.demater.core.usecase.user.GetAllRolesUseCase;
import com.demater.rest.common.out.RoleOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {
        @Tag(name = "Role", description = "User role in store or station")
})
@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {
    private final GetAllRolesUseCase getAllRoles;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting user roles")
    public ResponseEntity<List<RoleOut>> getRoles() {
        List<Role> roles = getAllRoles.execute();
        List<RoleOut> results = roles.stream()
                .map(r -> objectMapper.convertValue(r, RoleOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
