package com.demater.core.domain.account;

import com.demater.core.domain.customer.Customer;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private UUID id;
    private String designation;
    private String accountCode;
    private Customer customer;
    private List<Customer> coOwner;
}
