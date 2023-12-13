package com.demater.infrastructure.database.entity.account;

import com.demater.infrastructure.database.entity.CustomAuditAbstract;
import jakarta.persistence.*;

public class AccountType extends CustomAuditAbstract {
    public static final String TABLE_NAME = "accountType";

    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String designation;

    public AccountType(String designation) {
        this.designation = designation;
    }

    public void update(String designation) {
        this.designation = designation;
    }
}
