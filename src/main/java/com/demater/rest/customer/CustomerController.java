package com.demater.rest.customer;

import com.demater.core.domain.customer.Customer;
import com.demater.core.usecase.customer.CreateCustomerUserCase;
import com.demater.rest.customer.in.CustomerUpdateIn;
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
@RequestMapping("Customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerUserCase createCustomerUserCase;
    private final ObjectMapper objectMapper;

    @PutMapping
    @Operation(summary = "Update customer informations")
    public ResponseEntity<CustomerOut> updateCustomer(@PathVariable UUID id, @Validated @RequestBody CustomerUpdateIn request) {
        Customer customer = objectMapper.convertValue(request, Customer.class);
        Customer customerSaved = createCustomerUserCase.execute(id, customer);
        return new ResponseEntity<>(objectMapper.convertValue(customerSaved, CustomerOut.class), OK);
    }

}
