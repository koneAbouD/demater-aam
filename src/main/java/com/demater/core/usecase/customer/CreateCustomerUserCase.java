package com.demater.core.usecase.customer;

import com.demater.core.domain.customer.Customer;
import com.demater.core.port.CustomerRepository;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreateCustomerUserCase {
    private final CustomerRepository customerRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Customer execute(UUID id, Customer customer) {

        Customer customerToUpdate = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + customer.getId() + "] don't exists"));

        customerToUpdate = Customer.builder()
                .firstName(customer.getFirstName())
                .lastNames(customer.getLastNames())
                .matherFullNames(customer.getMatherFullNames())
                .build();
        Customer customerUpdated = customerRepository.save(customerToUpdate);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return customerUpdated;
    }
}
