package com.demater.infrastructure.provider;

import com.demater.core.domain.common.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {
    @Test
    void should_return_result_when_is_value_contains() {
       assertTrue(StringUtils.isValueContains("Hello, I'm software developer", "software"));
       assertFalse(StringUtils.isValueContains("Hello, I'm software developer", "Good morning"));
    }
}
