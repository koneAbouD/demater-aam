package com.demater.infrastructure.database.entity.profession;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ProfessionEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class ProfessionEntity {
    public static final String TABLE_NAME = "profession";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "income")
    private Double income;

    @NotNull(message = "The professional category can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "professional_category_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private ProfessionalCatEntity professionalCat;

    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private EmployerEntity employer;
}
