package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.reference.Country;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CountryRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllCountryUseCase {
    private final CountryRepository countryRepository;

    public List<Country> execute() {
        List<Country> countries = countryRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(r ->r.getName()))
                .toList();
        //accountsEventPublisher.publishAccountsGettingEvent(new AccountsGettingEvent());
        return countries;
    }
}
