package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.LegalCapacityRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateLegalCapacityUseCase {
    private final LegalCapacityRepository legalCapacityRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public LegalCapacity execute(LegalCapacity legalCapacity) {
        if (legalCapacityRepository.existsByNameIgnoreCase(legalCapacity.getName())) {
            throw new AccountTypeAlreadyExistsException("Legal capacity [" + legalCapacity.getName() + "] already exists");
        }

        LegalCapacity legalCapacityToSave = legalCapacityRepository.save(legalCapacity);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return legalCapacityToSave;
    }
}
