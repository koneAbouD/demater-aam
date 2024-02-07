package com.demater.core.domain.customer;

import com.demater.core.domain.profession.Profession;
import com.demater.core.domain.reference.Address;
import lombok.*;

import java.util.List;
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
    private Set<Profession> professions;
    private MaritalStatus maritalStatus;
    private FamilyStatus familyStatus;
    private int numbChildrens;
    private String code;

    public void create(String firstName, String lastNames, String matherFullNames){
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.matherFullNames = matherFullNames;
    }
    public void update(String numTelephone, String email, Address address , Nationality nationality, Language language){
        this.numTelephone = numTelephone;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.language = language;
    }
    public void update(Set<Profession> profession, ELevelStudent levelStudent, MaritalStatus maritalStatus , FamilyStatus familyStatus, int numbChildrens){
        this.professions = profession;
        this.levelStudent = levelStudent;
        this.maritalStatus = maritalStatus;
        this.familyStatus = familyStatus;
        this.numbChildrens = numbChildrens;
    }
    public String type() {
        return type.getName();
    }
    public Long typeId(){
        return type.getId();
    }
    public String nationality(){
        return nationality.getName();
    }
    public Long nationalityId(){
        return nationality.getId();
    }
    public String language(){
        return language.getName();
    }
    public Long languageId(){
        return language.getId();
    }
    public UUID addressId(){
        return address.getId();
    }
    public String maritalStatus(){
        return maritalStatus.getName();
    }
    public Long maritalStatusId(){
        return nationality.getId();
    }
    public String familyStatus(){
        return familyStatus.getName();
    }
    public Long familyStatusId(){
        return nationality.getId();
    }
    public List<UUID> profetionIds() {
        return getProfessions().stream().map(Profession::getId).toList();
    }
}
