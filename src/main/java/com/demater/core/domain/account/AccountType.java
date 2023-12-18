package com.demater.core.domain.account;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
