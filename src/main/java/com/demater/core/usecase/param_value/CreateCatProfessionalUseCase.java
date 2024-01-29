package com.demater.core.usecase.param_value;

import com.demater.core.domain.profession.ProfessionalCat;
import com.demater.core.port.CatProfessionalRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCatProfessionalUseCase {
    private final CatProfessionalRepository catProfessionalRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public ProfessionalCat execute(ProfessionalCat professionalCat) {
        if (catProfessionalRepository.existsByNameIgnoreCase(professionalCat.getName())) {
            throw new AccountTypeAlreadyExistsException("category professional [" + professionalCat.getName() + "] already exists");
        }

        ProfessionalCat professionalCatToSave = catProfessionalRepository.save(professionalCat);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return professionalCatToSave;
    }
}
