package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CustomerTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllCustomerTypeUseCase {
    private final CustomerTypeRepository customerTypeRepository;

    public List<CustomerType> execute() {
        List<CustomerType> customerTypes = customerTypeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(c ->c.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return customerTypes;
    }
}
