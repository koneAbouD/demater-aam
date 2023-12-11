package com.demater.infrastructure.provider;

import com.demater.core.port.Password;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class PasswordProviderTest {
    @InjectMocks
    private PasswordProvider passwordProvider;

    @Test
    void testGeneratedPasswordMatchesPattern() {
        assertTrue(passwordProvider.generatePassword().matches(Password.REGEX_PASSWORD));
    }

    @Test
    void testGeneratedPasswordDontMatchesPattern() {
        assertFalse("14341vbwjcbdscbwx".matches(Password.REGEX_PASSWORD));
    }
}
