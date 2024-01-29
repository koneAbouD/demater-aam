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
    private ProfessionalCat professionalCat;
    private LocalDate hireDate;
    private Double income;

    private Employer employer;

    public String catProfessional() {
        return getProfessionalCat().getName();
    }
    public String professionCode() {
        return getProfessionalCat().getCode();
    }
}
