package com.demater.infrastructure.database.entity.account;

import com.demater.core.domain.account.EStatus;
import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import com.demater.infrastructure.database.entity.customer.CustomerEntity;
import com.demater.infrastructure.database.entity.document.DocumentEntity;
import com.demater.infrastructure.database.entity.user.BranchEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
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

    @Column(name="business_key", unique = true)
    @NotNull(message = "The business key can't be null")
    private String businessKey;

    @Column(name="designation")
    private String designation;

    @Column(name="code", unique = true)
    private String code;

    @NotNull(message = "The account type can't be null")
    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "account_type_id", nullable = false)
    @OnDelete(action = NO_ACTION)
    private AccountTypeEntity type;

    @ManyToOne(fetch = EAGER, cascade=CascadeType.ALL)
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
    @JoinTable(name = "account_document_required",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<DocumentEntity> documentsRequired;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "account_document_signed",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"))
    @OnDelete(action = NO_ACTION)
    private Set<DocumentEntity> documentsSigned;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "branch_id")
    @OnDelete(action = NO_ACTION)
    @JsonIgnoreProperties("account")
    private BranchEntity branch;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    @NotNull(message = "The status can't be null")
    private EStatus status;

    @Column(name = "is_activate")
    private boolean isActivate;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;

    @Column(name = "is_delete")
    private boolean isDelete;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;
}
