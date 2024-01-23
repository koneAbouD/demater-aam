package com.demater.core.usecase.customer;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.customer.Language;
import com.demater.core.domain.customer.Nationality;
import com.demater.core.domain.reference.Address;
import com.demater.core.port.AddressRepository;
import com.demater.core.port.CustomerRepository;
import com.demater.core.port.LanguageRepository;
import com.demater.core.port.NationalityRepository;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateCustomerOfCoordinatedUserCase {
    private final CustomerRepository customerRepository;
    private final NationalityRepository nationalityRepository;
    private final LanguageRepository languageRepository;
    public final AddressRepository addressRepository;
    //private final GadgetEventPublisher gadgetEventPublisher;

    public Customer execute(UUID id, Customer customer) {

        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + id + "] don't exists"));

        Nationality nationality = nationalityRepository.findById(customer.nationalityId())
                .orElseThrow(() -> new AccountNotFoundException("Nationality ID=[" + customer.nationalityId() + "] don't exists"));

        Language language = languageRepository.findById(customer.languageId())
                .orElseThrow(() -> new AccountNotFoundException("Language ID=[" + customer.languageId() + "] don't exists"));

        Address address = addressRepository.findById(customer.addressId())
                .orElseThrow(() -> new AccountNotFoundException("Address ID=[" + customer.addressId() + "] don't exists"));

        customerToUpdate.update(customer.getNumTelephone(),
                customer.getEmail(),
                address,
                nationality,
                language);

        Customer customerUpdated = customerRepository.save(customerToUpdate);
        //gadgetEventPublisher.publishGadgetUpdatingEvent(new GadgetUpdatingEvent(id));
        return customerUpdated;
    }
}
