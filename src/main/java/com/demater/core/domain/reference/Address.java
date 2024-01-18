package com.demater.core.domain.reference;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    private UUID id;
    private EAddressType type;
    private String city;
    private String county;
    private Country country;
    private String description;
    private String postalCode;
}
