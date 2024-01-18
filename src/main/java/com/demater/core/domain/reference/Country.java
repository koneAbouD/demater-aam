package com.demater.core.domain.reference;

import com.demater.core.domain.common.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country extends CodeNameAbstract {
    private Long id;
    public Country(String code, String name){
        this.code = code;
        this.name = name;
    }
}