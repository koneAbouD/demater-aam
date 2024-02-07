package com.demater.core.usecase.account;

import com.demater.builder.*;
import com.demater.core.domain.account.Account;
import com.demater.core.domain.account.AccountType;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.customer.CustomerType;
import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.profession.Profession;
import com.demater.core.port.AccountRepository;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.port.CustomerTypeRepository;
import com.demater.core.usecase.account.exception.AccountAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateAccountUseCaseTest {
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountTypeRepository accountTypeRepository;
    @Mock
    private CustomerTypeRepository customerTypeRepository;
    private CreateAccountUseCase createAccountUseCase;

    @BeforeEach
    void setUp() {
        createAccountUseCase = new CreateAccountUseCase(accountRepository, accountTypeRepository, customerTypeRepository);
    }

    /*@Test
    void should_throw_when_create_account_with_account_business_key_already_exists() {
        // Given
        UUID id = UUID.randomUUID();
        AccountType accountType = new AccountType(1L, "225","type 1");
        CustomerType customerType = new CustomerType(1L, "225","type 2");
        Set<Profession> professions = Set.of();
        LegalCapacity legalCapacity = new LegalCapacity();
        Customer customer = Customer.builder()
                .type(customerType)
                .professions(professions)
                .legalCapacity(legalCapacity).build();
        Account account = new AccountMB().withId(id).withDesignation("A001").withType(accountType).withCustomer(customer).build();
        when(accountTypeRepository.findById(accountType.getId())).thenReturn(of(accountType));
        when(customerTypeRepository.findById(customerType.getId())).thenReturn(of(customerType));
        when(accountRepository.existsByBusinessKeyIgnoreCase(account.getDesignation())).thenReturn(true);

        // When
        Exception exception = assertThrows(AccountAlreadyExistsException.class, () -> createAccountUseCase.execute(account));

        // Then
        assertEquals("Account [" + account.getBusinessKey() + "] already exists", exception.getMessage());
        verify(accountRepository).existsByBusinessKeyIgnoreCase(account.getBusinessKey());
        verify(accountRepository, never()).save(any(Account.class));
    }*/

    @Test
    void should_create_account() {
        // Given
        UUID id = UUID.randomUUID();
        AccountType accountType = new AccountTypeMB().withId(1L).withCode("223").withName("courant").build();
        AccountType accountTypeExisting = new AccountTypeMB().withId(1L).withCode("223").withName("courant").build();
        CustomerType customerType = new CustomerTypeMB().withId(1L).withCode("223").withName("physique").build();
        CustomerType customerTypeExisting = new CustomerTypeMB().withId(1L).withCode("223").withName("physique").build();
        Profession profession1 = new ProfessionMB().withDesignation("aa").build();
        Customer customer = new CustomerMB().withType(customerType).withProfessions(Set.of(profession1)).withLegalCapacity(new LegalCapacity()).build();
        Account account = new AccountMB().withBusinessKey("AA01").withType(accountType).withCustomer(customer).withMotif("income").build();
        Customer customerToSave = Customer.builder()
                .type(customerTypeExisting)
                .professions(account.profession())
                .legalCapacity(account.legalCapacity())
                .build();
        Account accountToSave = new AccountMB().withId(id).withBusinessKey("A001").withType(accountType).build();
        when(accountRepository.existsByBusinessKeyIgnoreCase(account.getBusinessKey())).thenReturn(false);
        when(accountTypeRepository.findById(account.typeId())).thenReturn(Optional.of(accountTypeExisting));
        when(customerTypeRepository.findById(account.customerTypeId())).thenReturn(Optional.of(customerTypeExisting));
        when(accountRepository.save(any(Account.class))).thenReturn(accountToSave);

        // When
        createAccountUseCase.execute(account);

        // Then
        verify(accountRepository).existsByBusinessKeyIgnoreCase(account.getBusinessKey());
        verify(accountTypeRepository).findById(account.typeId());
        verify(customerTypeRepository).findById(account.customerTypeId());
        //verify(accountToSave).createAccount(accountTypeExisting, customer, account.getMotif());
        verify(accountRepository).save(any(Account.class));
    }
}
