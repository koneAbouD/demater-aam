package com.demater.core.domain.account;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.domain.user.Branch;
import com.demater.core.domain.customer.Customer;
import com.demater.core.domain.document.Document;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private UUID id;
    private String businessKey;
    private String designation;
    private String accountCode;
    private Customer customer;
    private Set<Customer> coOwners;
    private Set<Document> documentsRequired;
    private Set<Document> documentsSigned;
    private Branch branch;
    private AccountType type;
    private EStatus status;
    private boolean checkCIP;
    private String levelRisque;

    public void UpdateWithIinfosOfCustomer(
            String businessKey,
            Customer customer,
            Set<Customer> coOwners) {
        this.businessKey = businessKey;
        this.customer = customer;
        this.coOwners = coOwners;
    }
}
