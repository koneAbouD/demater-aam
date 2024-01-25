package com.demater.core.usecase.param_value;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.profession.EmployerType;
import com.demater.core.port.CustomerTypeRepository;
import com.demater.core.port.EmployerRepository;
import com.demater.core.port.EmployerTypeRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateEmployerTypeUseCase {
    private final EmployerTypeRepository employerTypeRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public EmployerType execute(EmployerType employerType) {
        if (employerTypeRepository.existsByNameIgnoreCase(employerType.getName())) {
            throw new AccountTypeAlreadyExistsException("Employer type [" + employerType.getName() + "] already exists");
        }

        EmployerType employerTypeToSave = employerTypeRepository.save(employerType);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return employerTypeToSave;
    }
}
