package com.demater.core.domain.customer;

import com.demater.core.domain.profession.Profession;
import com.demater.core.domain.reference.Address;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private UUID id;
    private CustomerType type;
    private String firstName;
    private String lastNames;
    private String numTelephone;
    private String email;
    private String matherFullNames;
    private Nationality nationality;
    private Language language;
    private Address address;
    private ELevelStudent levelStudent;
    private LegalCapacity legalCapacity;
    private Set<Profession> profession;
    private MaritalStatus maritalStatus;
    private FamilyStatus familyStatus;
    private int numbChildrens;
    private String customerCode;

    public void createCustomer(String firstName,String lastNames, String matherFullNames){
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.matherFullNames = matherFullNames;
    }

    public void updateCustomerOfCoordinated(String numTelephone, String email, Address address , Nationality nationality, Language language){
        this.numTelephone = numTelephone;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.language = language;
    }

    public String nationality(){
        return nationality.getName();
    }
    public String language(){
        return nationality.getName();
    }
    public String maritalStatus(){
        return nationality.getName();
    }
    public String familyStatus(){
        return nationality.getName();
    }
}
