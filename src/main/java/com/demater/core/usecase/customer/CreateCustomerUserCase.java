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

        Customer customerToSave = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + id + "] don't exists"));

        customerToSave.create(customer.getFirstName(), customer.getLastNames(), customer.getMatherFullNames());
        Customer customerSaved = customerRepository.save(customerToSave);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return customerSaved;
    }
}
