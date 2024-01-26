package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.MaritalStatus;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.MaritalStatusRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMaritalStatusUseCase {
    private final MaritalStatusRepository maritalStatusRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public MaritalStatus execute(MaritalStatus maritalStatus) {
        if (maritalStatusRepository.existsByNameIgnoreCase(maritalStatus.getName())) {
            throw new AccountTypeAlreadyExistsException("Marital status [" + maritalStatus.getName() + "] already exists");
        }

        MaritalStatus maritalStatusToSave = maritalStatusRepository.save(maritalStatus);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return maritalStatusToSave;
    }
}
