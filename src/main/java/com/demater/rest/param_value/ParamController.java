package com.demater.rest.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.profession.CatProfessional;
import com.demater.core.domain.profession.EmployerType;
import com.demater.core.usecase.param_value.*;
import com.demater.rest.account.out.AccountTypeOut;
import com.demater.rest.common.in.CodeNameIn;
import com.demater.rest.common.out.CodeNameOut;
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
        @Tag(name = "Parameter", description = "Provides parameter operations APIs")
})
@RestController
@RequestMapping("param")
@RequiredArgsConstructor
public class ParamController {
    private final GetAllAccountTypeUseCase getAllAccountType;
    private final CreateAccountTypeUseCase createAccountType;
    private final GetAllCustomerTypeUseCase getAllCustomerType;
    private final CreateCustomerTypeUseCase createCustomerType;
    private final GetAllLegalCapacityUseCase getAllLegalCapacity;
    private final CreateLegalCapacityUseCase createLegalCapacity;
    private final GetAllCatProfessionalUseCase getAllCatProfessional;
    private final CreateCatProfessionalUseCase createCatProfessional;
    private final GetAllEmployerTypeUseCase getAllEmployerType;
    private final CreateEmployerTypeUseCase createEmployerType;
    private final ObjectMapper objectMapper;

    @PostMapping("/account-type")
    @Operation(summary = "Creating account type")
    public ResponseEntity<AccountTypeOut> createAccountType(@Validated @RequestBody CodeNameIn request) {
        AccountType accountType = objectMapper.convertValue(request, AccountType.class);
        AccountType accountTypeSaved = createAccountType.execute(accountType);
        return new ResponseEntity<>(objectMapper.convertValue(accountTypeSaved, AccountTypeOut.class), CREATED);
    }
    @GetMapping("/account-types")
    @Operation(summary = "Getting all account types")
    public ResponseEntity<List<AccountTypeOut>> getAccountTypes() {
        List<AccountType> accountTypes = getAllAccountType.execute();
        List<AccountTypeOut> results = accountTypes.stream()
                .map(a -> objectMapper.convertValue(a, AccountTypeOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping("/customer-type")
    @Operation(summary = "Creating customer type")
    public ResponseEntity<CodeNameOut> createCustomerType(@Validated @RequestBody CodeNameIn request) {
        CustomerType customerType = objectMapper.convertValue(request, CustomerType.class);
        CustomerType customerTypeSaved = createCustomerType.execute(customerType);
        return new ResponseEntity<>(objectMapper.convertValue(customerTypeSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/customer-types")
    @Operation(summary = "Getting all customer types")
    public ResponseEntity<List<CodeNameOut>> getCustomerTypes() {
        List<CustomerType> customerTypes = getAllCustomerType.execute();
        List<CodeNameOut> results = customerTypes.stream()
                .map(c -> objectMapper.convertValue(c, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping("/legal-capacity")
    @Operation(summary = "Creating legal capacity")
    public ResponseEntity<CodeNameOut> createLegalCapacity(@Validated @RequestBody CodeNameIn request) {
        LegalCapacity legalCapacity = objectMapper.convertValue(request, LegalCapacity.class);
        LegalCapacity legalCapacitySaved = createLegalCapacity.execute(legalCapacity);
        return new ResponseEntity<>(objectMapper.convertValue(legalCapacitySaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/legal-capacitys")
    @Operation(summary = "Getting all legal capacity")
    public ResponseEntity<List<CodeNameOut>> getAllLegalCapacity() {
        List<LegalCapacity> legalCapacities = getAllLegalCapacity.execute();
        List<CodeNameOut> results = legalCapacities.stream()
                .map(lc -> objectMapper.convertValue(lc, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping("/category-professional")
    @Operation(summary = "Creating category professional")
    public ResponseEntity<CodeNameOut> createCatProfessional(@Validated @RequestBody CodeNameIn request) {
        CatProfessional catProfessional = objectMapper.convertValue(request, CatProfessional.class);
        CatProfessional catProfessionalSaved = createCatProfessional.execute(catProfessional);
        return new ResponseEntity<>(objectMapper.convertValue(catProfessionalSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/category-professionals")
    @Operation(summary = "Getting all category professional")
    public ResponseEntity<List<CodeNameOut>> getAllCatProfessional() {
        List<CatProfessional> catProfessionals = getAllCatProfessional.execute();
        List<CodeNameOut> results = catProfessionals.stream()
                .map(cp -> objectMapper.convertValue(cp, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping("/employer-type")
    @Operation(summary = "Creating employer type")
    public ResponseEntity<CodeNameOut> createEmployerType(@Validated @RequestBody CodeNameIn request) {
        EmployerType employerType = objectMapper.convertValue(request, EmployerType.class);
        EmployerType employerTypeSaved = createEmployerType.execute(employerType);
        return new ResponseEntity<>(objectMapper.convertValue(employerTypeSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/employer-types")
    @Operation(summary = "Getting all employer type")
    public ResponseEntity<List<CodeNameOut>> getAllEmployerType() {
        List<EmployerType> employerTypes = getAllEmployerType.execute();
        List<CodeNameOut> results = employerTypes.stream()
                .map(e -> objectMapper.convertValue(e, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}
