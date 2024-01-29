package com.demater.core.usecase.param_value;

import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.port.LegalCapacityRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllLegalCapacityUseCase {
    private final LegalCapacityRepository legalCapacityRepository;

    public List<LegalCapacity> execute() {
        List<LegalCapacity> legalCapacities = legalCapacityRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(c ->c.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return legalCapacities;
    }
}
