package com.demater.rest.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.folder.Folder;
import com.demater.core.usecase.account.GetAllAccountsUseCase;
import com.demater.rest.account.out.AccountOut;
import com.demater.rest.folder.out.FolderOut;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        @Tag(name = "Account", description = "")
})
@RestController
@RequestMapping("Account")
@RequiredArgsConstructor
public class AccountController {
    private final GetAllAccountsUseCase getAllAccountsUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting all accounts")
    public ResponseEntity<List<AccountOut>> getAccounts() {
        List<Account> accounts = getAllAccountsUseCase.execute();
        List<AccountOut> results = accounts.stream()
                .map(r -> objectMapper.convertValue(r, AccountOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
