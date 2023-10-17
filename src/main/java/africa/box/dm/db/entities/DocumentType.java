package africa.box.dm.db.entities;

import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "document_types")
@TypeDef(name = "jsonb", typeClass = JsonNodeType.class)
@Data
public class DocumentType implements Serializable {
    private String name;
    private String description;
    private String docCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numberOfCopies;
    private String statut;
    private Boolean facultatif;
    private String businessKey;
    private Boolean confirmation;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String agence;

    private Boolean fromClient;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String metaData;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getMetaData() {
        return metaData;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Boolean getFacultatif() {
        return facultatif;
    }

    public void setFacultatif(Boolean facultatif) {
        this.facultatif = facultatif;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", docCode='" + docCode + '\'' +
                ", id=" + id +
                ", numberOfCopies=" + numberOfCopies +
                ", fromClient=" + fromClient +
                '}';
    }

    public DocumentType(String docCode, String name, String description) {
        this.docCode = docCode;
        this.name = name;
        this.description = description;
    }
    //@ManyToMany(mappedBy = "documentTypes")
    //List<Dossier> dossiers;


    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentType() {
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentType)) return false;
        DocumentType that = (DocumentType) o;
        return docCode.equals(that.docCode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Boolean getFromClient() {
        return fromClient;
    }

    public void setFromClient(Boolean fromClient) {
        this.fromClient = fromClient;
    }

    /*public List<Dossier> getDossiers() {
            return dossiers;
        }

        public void setDossiers(List<Dossier> dossiers) {
            this.dossiers = dossiers;
        }*/
    @PrePersist()
    public void AddCustomInformationUser(){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        this.agence=user.getAgence();
        this.createdBy=user.getEmail();
        this.createdAt=new Date();
        this.updatedBy=user.getEmail();
        this.updatedAt=new Date();
    }

    @PreUpdate()
    public void UpdateCustomInformationUser(){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        this.updatedBy=user.getEmail();
        this.updatedAt=new Date();
    }
}
