package com.demater.core.domain.profession;

import lombok.*;

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
}
