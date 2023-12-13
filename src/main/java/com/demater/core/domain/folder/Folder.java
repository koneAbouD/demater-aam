package com.demater.core.domain.folder;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.referential.ESetting;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Folder {
    private UUID id;
    private String businessKey;
    private String designation;
    private Account account;
    private Set<Customer> customers;
    private EStatus status;

}
