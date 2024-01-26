package com.demater.core.domain.profession;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profession {
    private UUID id;
    private String designation;
    private CatProfessional catProfessional;
    private LocalDate hireDate;
    private Double income;

    private Employer employer;

    public String catProfessional() {
        return getCatProfessional().getName();
    }
    public String professionCode() {
        return getCatProfessional().getCode();
    }
}
