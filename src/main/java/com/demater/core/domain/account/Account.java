package com.demater.core.domain.account;

import com.demater.core.domain.customer.LegalCapacity;
import com.demater.core.domain.profession.Profession;
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
    private String code;
    private Customer customer;
    private Set<Customer> coOwners;
    private Set<Document> documentsRequired;
    private Set<Document> documentsSigned;
    private Branch branch;
    private AccountType type;
    private EStatus status;
    private String motif;
    private boolean checkCIP;
    private String levelRisque;

    public void createAccount(AccountType type, Customer customer, String motif){
        this.type = type;
        this.customer = customer;
        this.motif = motif;
    }

    public String type() {
        return type.getName();
    }
    public Set<Profession> profetion(){
        return customer.getProfessions();
    }
    public LegalCapacity legalCapacity(){
        return customer.getLegalCapacity();
    }
}
