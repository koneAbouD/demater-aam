package com.demater.core.domain.user;

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
