package com.demater.core.domain.customer;

import com.demater.core.domain.common.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CustomerType extends CodeNameAbstract {
    private Long id;
    public CustomerType(Long id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
