package com.demater.core.usecase.param_value;

import com.demater.core.domain.profession.ProfessionalCat;
import com.demater.core.port.CatProfessionalRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllCatProfessionalUseCase {
    private final CatProfessionalRepository catProfessionalRepository;

    public List<ProfessionalCat> execute() {
        List<ProfessionalCat> professionalCats = catProfessionalRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(c ->c.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return professionalCats;
    }
}
