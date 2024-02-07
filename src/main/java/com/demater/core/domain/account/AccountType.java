package com.demater.core.domain.account;

import com.demater.core.domain.common.CodeNameAbstract;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AccountType extends CodeNameAbstract {
    private Long id;
    public AccountType(Long id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
