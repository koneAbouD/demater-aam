package com.demater.rest.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.customer.MaritalStatus;
import com.demater.core.domain.profession.ProfessionalCat;
import com.demater.core.domain.profession.EmployerType;
import com.demater.core.domain.reference.Country;
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
    private final CreateFamilyStatusUseCase createFamilyStatus;
    private final GetAllFamilyStatusUseCase getAllFamilyStatus;
    private final CreateMaritalStatusUseCase createMaritalStatus;
    private final GetAllMaritalStatusUseCase getAllMaritalStatus;
    private final CreateCountryUseCase createCountry;
    private final GetAllCountryUseCase getAllCountry;
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
        ProfessionalCat professionalCat = objectMapper.convertValue(request, ProfessionalCat.class);
        ProfessionalCat professionalCatSaved = createCatProfessional.execute(professionalCat);
        return new ResponseEntity<>(objectMapper.convertValue(professionalCatSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/category-professionals")
    @Operation(summary = "Getting all category professional")
    public ResponseEntity<List<CodeNameOut>> getAllProfessionalCAt() {
        List<ProfessionalCat> professionalCats = getAllCatProfessional.execute();
        List<CodeNameOut> results = professionalCats.stream()
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
    @PostMapping("/family-status")
    @Operation(summary = "Creating family status")
    public ResponseEntity<CodeNameOut> createFamilyStatus(@Validated @RequestBody CodeNameIn request) {
        FamilyStatus familyStatus = objectMapper.convertValue(request, FamilyStatus.class);
        FamilyStatus familyStatusSaved = createFamilyStatus.execute(familyStatus);
        return new ResponseEntity<>(objectMapper.convertValue(familyStatusSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/family-status")
    @Operation(summary = "Getting all family status")
    public ResponseEntity<List<CodeNameOut>> getAllFamilyStatus() {
        List<FamilyStatus> familyStatuses = getAllFamilyStatus.execute();
        List<CodeNameOut> results = familyStatuses.stream()
                .map(e -> objectMapper.convertValue(e, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
    @PostMapping("/marital-status")
    @Operation(summary = "Creating marital status")
    public ResponseEntity<CodeNameOut> createMaritalStatus(@Validated @RequestBody CodeNameIn request) {
        MaritalStatus maritalStatus = objectMapper.convertValue(request, MaritalStatus.class);
        MaritalStatus maritalStatusSaved = createMaritalStatus.execute(maritalStatus);
        return new ResponseEntity<>(objectMapper.convertValue(maritalStatusSaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/marital-status")
    @Operation(summary = "Getting all marital status")
    public ResponseEntity<List<CodeNameOut>> getAllMaritalStatus() {
        List<MaritalStatus> maritalStatuses = getAllMaritalStatus.execute();
        List<CodeNameOut> results = maritalStatuses.stream()
                .map(e -> objectMapper.convertValue(e, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
    @PostMapping("/country")
    @Operation(summary = "Creating country")
    public ResponseEntity<CodeNameOut> createCountry(@Validated @RequestBody CodeNameIn request) {
        Country country = objectMapper.convertValue(request, Country.class);
        Country countrySaved = createCountry.execute(country);
        return new ResponseEntity<>(objectMapper.convertValue(countrySaved, CodeNameOut.class), CREATED);
    }
    @GetMapping("/country")
    @Operation(summary = "Getting all country")
    public ResponseEntity<List<CodeNameOut>> getAllCountry() {
        List<Country> countries = getAllCountry.execute();
        List<CodeNameOut> results = countries.stream()
                .map(e -> objectMapper.convertValue(e, CodeNameOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }
}