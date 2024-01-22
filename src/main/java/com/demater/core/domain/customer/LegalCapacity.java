package com.demater.core.domain.customer;

import com.demater.core.domain.common.CodeNameAbstract;
import com.demater.infrastructure.database.entity.account.AccountTypeEntity;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LegalCapacity extends CodeNameAbstract {
    private Long id;
}