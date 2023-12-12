package com.demater.core.domain.branch;

import lombok.*;

import java.util.UUID;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch {
    private UUID id;
    private String code;
    private String name;
}
