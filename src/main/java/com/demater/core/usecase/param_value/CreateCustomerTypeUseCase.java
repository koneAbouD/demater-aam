package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CustomerTypeRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCustomerTypeUseCase {
    private final CustomerTypeRepository customerTypeRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public CustomerType execute(CustomerType customerType) {
        if (customerTypeRepository.existsByNameIgnoreCase(customerType.getName())) {
            throw new AccountTypeAlreadyExistsException("Customer type [" + customerType.getName() + "] already exists");
        }

        CustomerType customerTypeToSave = customerTypeRepository.save(new CustomerType());
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return customerTypeToSave;
    }
}
