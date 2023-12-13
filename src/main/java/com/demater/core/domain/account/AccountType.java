package com.demater.core.domain.account;

public class AccountType {
    private Long id;
    private String designation;

    public AccountType(String designation) {
        this.designation = designation;
    }

    public void update(String designation) {
        this.designation = designation;
    }
}
