package com.demater.rest.account;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.usecase.account.CreateAccountUseCase;
import com.demater.core.usecase.param_value.GetAllAccountTypeUseCase;
import com.demater.core.usecase.account.GetAllAccountsUseCase;
import com.demater.rest.account.in.AccountCreateIn;
import com.demater.rest.account.out.AccountOut;
import com.demater.rest.account.out.AccountTypeOut;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tags(value = {
        @Tag(name = "Account", description = "Provides account operations APIs")
})
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final GetAllAccountsUseCase getAllAccounts;
    private final CreateAccountUseCase createAccount;
    private final ObjectMapper objectMapper;

    @GetMapping
    @Operation(summary = "Getting all accounts")
    public ResponseEntity<List<AccountOut>> getAccounts() {
        List<Account> accounts = getAllAccounts.execute();
        List<AccountOut> results = accounts.stream()
                .map(r -> objectMapper.convertValue(r, AccountOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
    @PostMapping
    @Operation(summary = "Creating account with account information")
    public ResponseEntity<AccountOut> createAccount(@Validated @RequestBody AccountCreateIn request) {
        Account account = objectMapper.convertValue(request, Account.class);
        Account accountSaved = createAccount.execute(account);
        return new ResponseEntity<>(objectMapper.convertValue(accountSaved, AccountOut.class), CREATED);
    }
}
