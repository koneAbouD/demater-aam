package com.demater.core.usecase.param_value;

import com.demater.core.domain.profession.CatProfessional;
import com.demater.core.port.CatProfessionalRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCatProfessionalUseCase {
    private final CatProfessionalRepository catProfessionalRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public CatProfessional execute(CatProfessional catProfessional) {
        if (catProfessionalRepository.existsByNameIgnoreCase(catProfessional.getName())) {
            throw new AccountTypeAlreadyExistsException("category professional [" + catProfessional.getName() + "] already exists");
        }

        CatProfessional catProfessionalToSave = catProfessionalRepository.save(catProfessional);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return catProfessionalToSave;
    }
}
