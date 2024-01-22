package com.demater.core.usecase.customer;

import com.demater.core.domain.customer.Customer;
import com.demater.core.port.CustomerRepository;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateCustomerOfCoordinatedUserCase {
    private final CustomerRepository customerRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Customer execute(UUID id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + id + "] don't exists"));

        customerToUpdate.updateCustomerOfCoordinated(customer.getNumTelephone(), customer.getEmail(), customer.getAddress(), customer.getNationality(), customer.getLanguage());

        Customer customerUpdated = customerRepository.save(customerToUpdate);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return customerUpdated;
    }
}
