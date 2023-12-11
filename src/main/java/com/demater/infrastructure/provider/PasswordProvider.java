package com.demater.infrastructure.provider;

import com.demater.configuration.security.jwt.JwtUtils;
import com.demater.core.port.Password;
import lombok.RequiredArgsConstructor;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static org.passay.AllowedRegexRule.ERROR_CODE;

@Component
@RequiredArgsConstructor
public class PasswordProvider implements Password {
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Override
    public String generatePassword() {
        PasswordGenerator generator = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(4);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(4);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%&*_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        return generator.generatePassword(12, splCharRule, lowerCaseRule, upperCaseRule, digitRule);
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public String generateJwtToken(String username) {
        return jwtUtils.generateJwtToken(username);
    }

    @Override
    public boolean validateJwtToken(String token) {
        return jwtUtils.validateJwtToken(token);
    }
}
