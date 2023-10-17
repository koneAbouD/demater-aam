package africa.box.dm.db.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
//import io.saworks.loaninitiate.dtos.AutreRevenuDto;
//import io.saworks.loaninitiate.dtos.User;
//import io.saworks.loaninitiate.services.LoanInitiationServices;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "autre_revenu")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class AutreRevenu implements Serializable {
    @Id
    private String identifiant;
    private String description;
    private Double montantAutreRevenu;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String agence;

//    public AutreRevenu(AutreRevenuDto e) {
//        identifiant=e.getIdentifiant();
//        description=e.getDescription();
//        montantAutreRevenu =e.getMontantAutreRevenu();
//    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontantAutreRevenu() {
        return montantAutreRevenu;
    }

    public void setMontantAutreRevenu(Double montantAutreRevenu) {
        this.montantAutreRevenu = montantAutreRevenu;
    }

    public AutreRevenu() {
    }

    public AutreRevenu(String identifiant, String description, Double montantAutreRevenu) {
        this.identifiant = identifiant;
        this.description = description;
        this.montantAutreRevenu = montantAutreRevenu;
    }

    @Override
    public String toString() {
        return "AutreRevenu{" +
                "identifiant='" + identifiant + '\'' +
                ", description='" + description + '\'' +
                ", montantAutreRevenu=" + montantAutreRevenu +
                '}';
    }

//    @PrePersist()
//    public void AddCustomInformationUser(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        this.agence=user.getAgence();
//        this.createdBy=user.getEmail();
//        this.createdAt=new Date();
//        this.updatedBy=user.getEmail();
//        this.updatedAt=new Date();
//    }
//
//    @PreUpdate()
//    public void UpdateCustomInformationUser(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        this.updatedBy=user.getEmail();
//        this.updatedAt=new Date();
//    }
}
