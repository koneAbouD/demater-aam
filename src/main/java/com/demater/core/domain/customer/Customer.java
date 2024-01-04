package com.demater.core.domain.customer;

import com.demater.core.domain.profession.Profession;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private UUID id;
    private CustomerType type;
    private String firstName;
    private String lastNames;
    private String matherFullNames;
    private LegalCapacity legalCapacity;
    private Set<Profession> profession;
    private String customerCode;
}
