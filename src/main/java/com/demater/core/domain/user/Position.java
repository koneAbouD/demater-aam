package com.demater.core.domain.user;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Position {
    private Long id;
    private String code;
    private String designation;
    private String description;
}
