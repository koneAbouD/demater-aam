package com.demater.core.domain.account;

import com.demater.core.domain.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AccountType extends CodeNameAbstract {
    private Long id;
    public AccountType(String code, String name){
        this.code = code;
        this.name = name;
    }
}
