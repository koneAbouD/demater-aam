
package com.demater.builder;

import com.demater.core.domain.profession.Profession;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProfessionMB {
    private Profession profession;

    public ProfessionMB() {
        profession = mock(Profession.class);
    }

    public ProfessionMB withId(UUID id) {
        when(profession.getId()).thenReturn(id);
        return this;
    }

    public ProfessionMB withDesignation(String designation) {
        when(profession.getDesignation()).thenReturn(designation);
        return this;
    }

    public Profession build() {
        return profession;
    }
}
