package com.demater.core.domain.account;

import com.demater.core.domain.user.Branch;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.document.Document;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private Long id;
    private String designation;
    private String accountCode;
    private Customer customer;
    private Set<Customer> coOwner;
    private Set<Document> documentsRequired;
    private Set<Document> documentsSigned;
    private Branch branch;
}
