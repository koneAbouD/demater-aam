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
    private String businessKey;
    private String designation;
    private CatProfessional catProfessional;
    private LocalDate dateEmbauche;
    private Double salaire;
    private Employer employer;

    public String catProfessionnelle() {
        return getCatProfessional().getName();
    }
    public String professionCode() {
        return getCatProfessional().getCode();
    }
}
