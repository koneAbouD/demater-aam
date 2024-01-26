package com.demater.core.usecase.param_value;

import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.reference.Country;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CountryRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCountryUseCase {
    private final CountryRepository countryRepository;
    //private final AccountEventPublisher accountEventPublisher;

    public Country execute(Country country) {
        if (countryRepository.existsByNameIgnoreCase(country.getName())) {
            throw new AccountTypeAlreadyExistsException("Country [" + country.getName() + "] already exists");
        }

        Country countryToSave = countryRepository.save(country);
        //accountEventPublisher.publishAccountTypeCreatingEvent(new AccountTypeCreatingEvent(name));
        return countryToSave;
    }
}
