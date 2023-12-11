package com.demater.core.domain.customer;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private UUID id;
    private String customer_code;
    private String firstName;
    private String LastNames;
}
