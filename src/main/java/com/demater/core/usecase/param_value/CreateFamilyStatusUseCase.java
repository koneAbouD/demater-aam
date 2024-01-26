package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.FamilyStatusRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateFamilyStatusUseCase {
    private final FamilyStatusRepository familyStatusRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public FamilyStatus execute(FamilyStatus familyStatus) {
        if (familyStatusRepository.existsByNameIgnoreCase(familyStatus.getName())) {
            throw new AccountTypeAlreadyExistsException("Family status [" + familyStatus.getName() + "] already exists");
        }

        FamilyStatus accountTypeToSave = familyStatusRepository.save(familyStatus);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return accountTypeToSave;
    }
}
