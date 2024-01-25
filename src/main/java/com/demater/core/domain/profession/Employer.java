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
    private String name;
    private String numTelephone;
    private String email;
    private String address;
    private EmployerType type;

    public String employerType() {
        return getType().getName();
    }
    public String employerCode() {
        return getType().getCode();
    }
}
