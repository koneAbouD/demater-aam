package com.demater.infrastructure.database.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class CodeNameAbstractEntity extends CustomAuditAbstract{

    protected String code;
    protected String name;
    public void update(String name) {
        this.name = name;
    }
    public void update(String code,String name) {
        this.code = code;
        this.name = name;
    }
}
