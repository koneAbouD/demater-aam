package com.demater.core.domain.profession;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employer {
    private UUID id;
    private String designation;
    private String numTelephone;
    private String email;
    private String adresse;
    private EmployerType employerType;

    public String employerType() {
        return getEmployerType().getName();
    }
    public String employerCode() {
        return getEmployerType().getCode();
    }
}
