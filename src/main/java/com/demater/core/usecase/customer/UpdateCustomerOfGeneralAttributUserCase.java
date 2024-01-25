package com.demater.core.usecase.customer;

import com.demater.core.domain.customer.*;
import com.demater.core.domain.profession.Profession;
import com.demater.core.port.CustomerRepository;
import com.demater.core.port.FamilyStatusRepository;
import com.demater.core.port.MaritalStatusRepository;
import com.demater.core.port.ProfessionRepository;
import com.demater.core.usecase.account.exception.AccountNotFoundException;
import com.demater.core.usecase.account.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
public class UpdateCustomerOfGeneralAttributUserCase {
    private final CustomerRepository customerRepository;
    private final ProfessionRepository professionRepository;
    private final MaritalStatusRepository maritalStatusRepository;
    private final FamilyStatusRepository familyStatusRepository;

    public Customer execute(UUID id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer ID=[" + id + "] don't exists"));

        loadCustomerNewElements(customerToUpdate, customer);
        Customer customerUpdated = customerRepository.save(customerToUpdate);
        return customerUpdated;
    }
    private void loadCustomerNewElements(Customer customerToUpdate, Customer customer) {
        MaritalStatus maritalStatus = maritalStatusRepository.findById(customer.maritalStatusId())
                .orElseThrow(() -> new AccountNotFoundException("Marital status ID=[" + customer.maritalStatusId() + "] don't exists"));

        FamilyStatus familyStatus = familyStatusRepository.findById(customer.familyStatusId())
                .orElseThrow(() -> new AccountNotFoundException("Family status ID=[" + customer.familyStatusId() + "] don't exists"));
        Set<Profession> professions = professionRepository.findAllByIdsIn(customer.profetionIds());
        customerToUpdate.update(professions, customerToUpdate.getLevelStudent(), maritalStatus, familyStatus, customerToUpdate.getNumbChildrens());
    }
}
