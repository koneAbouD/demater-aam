package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.MaritalStatus;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.MaritalStatusRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllMaritalStatusUseCase {
    private final MaritalStatusRepository maritalStatusRepository;

    public List<MaritalStatus> execute() {
        List<MaritalStatus> maritalStatuses = maritalStatusRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return maritalStatuses;
    }
}
