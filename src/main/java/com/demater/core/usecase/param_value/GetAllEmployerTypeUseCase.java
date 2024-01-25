package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.profession.EmployerType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.EmployerTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllEmployerTypeUseCase {
    private final EmployerTypeRepository employerTypeRepository;

    public List<EmployerType> execute() {
        List<EmployerType> employerTypes = employerTypeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return employerTypes;
    }
}
