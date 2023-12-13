package com.demater.infrastructure.database.entity.account;

import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.document.Document;
import com.demater.core.domain.user.Branch;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.user.RoleEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = RoleEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class AccountEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "account";

    @Id
    private String businessKey;
    private String designation;
    private String accountCode;
    private Customer customer;
    private Set<Customer> coOwner;
    private Set<Document> documentsRequired;
    private Set<Document> documentsSigned;
    private Branch branch;
    private EStatus status;
    private AccountType type;
}
