package com.demater.core.usecase.param_value;

import com.demater.builder.AccountTypeMB;
import com.demater.core.domain.account.AccountType;
import com.demater.core.port.AccountTypeRepository;
import com.demater.core.usecase.account.exception.AccountTypeAlreadyExistsException;
import com.demater.core.usecase.param_value.CreateAccountTypeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateAccountTypeUseCaseTest {
    @Mock
    private AccountTypeRepository accountTypeRepository;
    private CreateAccountTypeUseCase createAccountTypeUseCase;

    @BeforeEach
    void setUp() {
        createAccountTypeUseCase = new CreateAccountTypeUseCase(accountTypeRepository);
    }

    @Test
    void should_throw_when_create_account_type_with_type_already_exists() {
        // Given
        AccountType accountType = new AccountTypeMB().withCode("225").withName("courant").build();
        when(accountTypeRepository.existsByNameIgnoreCase(accountType.getName())).thenReturn(true);

        // When
        Exception exception = assertThrows(AccountTypeAlreadyExistsException.class,
                () -> createAccountTypeUseCase.execute(accountType));

        // Then
        assertEquals("Account type [" + accountType.getName() + "] already exists", exception.getMessage());
        verify(accountTypeRepository).existsByNameIgnoreCase(accountType.getName());
        verify(accountTypeRepository, never()).save(any(AccountType.class));
    }

    @Test
    void should_create_account_type() {
        // Given
        AccountType accountType = new AccountTypeMB().withCode("225").withName("courant").build();
        when(accountTypeRepository.existsByNameIgnoreCase(accountType.getName())).thenReturn(false);

        // When
        createAccountTypeUseCase.execute(accountType);

        // Then
        verify(accountTypeRepository).existsByNameIgnoreCase(accountType.getName());
        ArgumentCaptor<AccountType> captor = ArgumentCaptor.forClass(AccountType.class);
        verify(accountTypeRepository).save(captor.capture());
        assertEquals(accountType.getName(), captor.getValue().getName());
    }
}
