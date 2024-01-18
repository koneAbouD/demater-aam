package com.demater.core.domain.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class CodeNameAbstract {

    protected String code;
    protected String name;
    public void update(String code,String name) {
        this.code = code;
        this.name = name;
    }
}
