package com.demater.rest.customer;

import com.demater.core.domain.customer.Customer;
import com.demater.core.usecase.customer.CreateCustomerUserCase;
import com.demater.core.usecase.customer.UpdateCustomerOfCoordinatedUserCase;
import com.demater.core.usecase.customer.UpdateCustomerOfGeneralAttributUserCase;
import com.demater.rest.customer.in.CustomerCoordinatedIn;
import com.demater.rest.customer.in.CustomerGeneralAttributesIn;
import com.demater.rest.customer.in.CustomerCreateIn;
import com.demater.rest.customer.out.CustomerOut;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Tags(value = {
        @Tag(name = "Customer", description = "Provides customer operations API's")
})
@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerUserCase createCustomerUserCase;
    private final UpdateCustomerOfCoordinatedUserCase updateCustomerOfCoordinatedUserCase;
    private final UpdateCustomerOfGeneralAttributUserCase updateCustomerOfGeneralAttributUserCase;
    private final ObjectMapper objectMapper;

    @PutMapping("/{id}")
    @Operation(summary = "Create customer")
    public ResponseEntity<CustomerOut> createCustomer(@PathVariable UUID id, @Validated @RequestBody CustomerCreateIn request) {
        Customer customer = objectMapper.convertValue(request, Customer.class);
        Customer customerSaved = createCustomerUserCase.execute(id, customer);
        return new ResponseEntity<>(objectMapper.convertValue(customerSaved, CustomerOut.class), OK);
    }

    @PutMapping("/coordinated")
    @Operation(summary = "Update customer of coordinated")
    public ResponseEntity<CustomerOut> updateCustomerOfCoordinated(@PathVariable UUID id, @Validated @RequestBody CustomerCoordinatedIn request) {
        Customer customer = objectMapper.convertValue(request, Customer.class);
        Customer customerSaved = updateCustomerOfCoordinatedUserCase.execute(id, customer);
        return new ResponseEntity<>(objectMapper.convertValue(customerSaved, CustomerOut.class), OK);
    }

    @PutMapping("/general_attributes")
    @Operation(summary = "Update customer of general attributes")
    public ResponseEntity<CustomerOut> updateCustomerOfGeneralAttributes(@PathVariable UUID id, @Validated @RequestBody CustomerGeneralAttributesIn request) {
        Customer customer = objectMapper.convertValue(request, Customer.class);
        Customer customerSaved = updateCustomerOfGeneralAttributUserCase.execute(id, customer);
        return new ResponseEntity<>(objectMapper.convertValue(customerSaved, CustomerOut.class), OK);
    }
}
