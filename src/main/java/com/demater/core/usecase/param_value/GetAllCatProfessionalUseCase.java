package com.demater.core.usecase.param_value;

import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.profession.CatProfessional;
import com.demater.core.port.CatProfessionalRepository;
import com.demater.core.port.CustomerTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllCatProfessionalUseCase {
    private final CatProfessionalRepository catProfessionalRepository;

    public List<CatProfessional> execute() {
        List<CatProfessional> catProfessionals = catProfessionalRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(c ->c.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return catProfessionals;
    }
}
