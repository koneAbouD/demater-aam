package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.FamilyStatus;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.FamilyStatusRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllFamilyStatusUseCase {
    private final FamilyStatusRepository familyStatusRepository;

    public List<FamilyStatus> execute() {
        List<FamilyStatus> familyStatuses = familyStatusRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return familyStatuses;
    }
}
