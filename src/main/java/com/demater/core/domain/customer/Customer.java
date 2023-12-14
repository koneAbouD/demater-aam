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
    private String customerCode;
    private String firstName;
    private String LastNames;
    private Set<Profession> profession;
}
