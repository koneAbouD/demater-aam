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
    private CategorieProfessionnelle categorieProfessionnelle;
    private LocalDate dateEmbauche;
    private Double salaire;
    private Employer employer;

    public String categorieProfessionnelle() {
        return getCategorieProfessionnelle().getName();
    }
    public String professionCode() {
        return getCategorieProfessionnelle().getCode();
    }
}
