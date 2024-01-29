package com.demater.infrastructure.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class CodeNameAbstractEntity extends CustomAuditAbstract{

    @NotNull(message = "The code can't be null")
    @Column(name="code", nullable = false)
    protected String code;

    @NotNull(message = "The name can't be null")
    @Column(name="name", nullable = false)
    protected String name;
    public void update(String name) {
        this.name = name;
    }
    public void update(String code,String name) {
        this.code = code;
        this.name = name;
    }
}
