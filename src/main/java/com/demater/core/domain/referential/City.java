package com.demater.core.domain.referential;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    private Long id;
    private String code;
    private String designation;
}
