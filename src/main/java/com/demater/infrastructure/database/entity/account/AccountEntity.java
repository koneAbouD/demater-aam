package com.demater.infrastructure.database.entity.account;

import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.document.Document;
import com.demater.core.domain.folder.EStatus;
import com.demater.core.domain.user.Branch;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import com.demater.infrastructure.database.entity.document.DocumentEntity;
import com.demater.infrastructure.database.entity.station.StationEntity;
import com.demater.infrastructure.database.entity.user.BranchEntity;
import com.demater.infrastructure.database.entity.user.RoleEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;
import static org.hibernate.annotations.UuidGenerator.Style.TIME;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = AccountEntity.TABLE_NAME)
@Access(AccessType.FIELD)
public class AccountEntity extends CustomAuditAbstract {
    public static final String TABLE_NAME = "account";

    @Id
    @UuidGenerator(style = TIME)
    private UUID id;
    private String businessKey;
    private String designation;
    private String accountCode;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "customer_id")
    @OnDelete(action = NO_ACTION)
    private CustomerEntity customer;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "account_customer",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<CustomerEntity> coOwner;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "account_document",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<DocumentEntity> documentsRequired;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "account_document",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<DocumentEntity> documentsSigned;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "branch_id")
    @OnDelete(action = NO_ACTION)
    private BranchEntity branch;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20, nullable = false)
    @NotNull(message = "The status can't be null")
    private EStatus status;

    @NotNull(message = "The account type can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "account_type_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private AccountTypeEntity type;
}
