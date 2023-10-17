package africa.box.dm.db.entities;

import africa.box.dm.config.ExternalEndPointConfig;
import africa.box.dm.dto.User;
import africa.box.dm.service.BusinessKeyGenerator;
import africa.box.dm.service.DmInitiationServices;
import com.lowagie.text.Document;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "compte_documents")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class CompteDocument extends Document {
    @Id
    private String identifiant;
    @Column(nullable = false)
    private String docCode;
    @Column(nullable = false,name = "business_key")
    private String businessKey;
    @Column(nullable = true)
    private String docPath;
    //    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb")
    @Column(columnDefinition="TEXT")
    private String docMeta;

    private String name;
    private String description;
    private int numberOfCopies;
    private String statut;
    private Boolean facultatif;
    private Integer id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentStatus documentstatus;

    private Boolean fromClient ;
    private Boolean fromAdmin ;

    // relation
    private String autreRevenu;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String agence;

    @Column(name = "content_type")
    private String contentType;

    @Column(nullable = true)
    private String type;

    @Transient
    @Autowired
    ExternalEndPointConfig externalEndPointConfig;

    @Transient
    @Autowired
    DmInitiationServices dmInitiationServices;

    public DocumentStatus getDocumentstatus() {
        return documentstatus;
    }

    public void setDocumentstatus(DocumentStatus documentstatus) {
        this.documentstatus = documentstatus;
    }

    @Override
    public String toString() {
        return "CompteDocument{" +
                "identifiant='" + identifiant + '\'' +
                ", docCode='" + docCode + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", docPath='" + docPath + '\'' +
                ", docMeta='" + docMeta + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", statut='" + statut + '\'' +
                ", facultatif=" + facultatif +
                ", id=" + id +
                ", documentstatus=" + documentstatus +
                ", fromClient=" + fromClient +
                ", autreRevenu='" + autreRevenu + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", agence='" + agence + '\'' +
                ", contentType='" + contentType + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public CompteDocument() {
        this.identifiant = BusinessKeyGenerator.newKey();
        this.createdAt=new Date();
    }

    public CompteDocument(String identifiant, String docCode, String businessKey, String docPath,
                          String docMeta, String name, String description, int numberOfCopies,
                          String statut, Boolean facultatif, Integer id, DocumentStatus documentstatus,
                          String autreRevenu, Date createdAt, Date updatedAt, String createdBy,
                          String updatedBy, String agence, String contentType, String type) {
        this.identifiant = identifiant;
        this.docCode = docCode;
        this.businessKey = businessKey;
        this.docPath = docPath;
        this.docMeta = docMeta;
        this.name = name;
        this.description = description;
        this.numberOfCopies = numberOfCopies;
        this.statut = statut;
        this.facultatif = facultatif;
        this.id = id;
        this.documentstatus = documentstatus;
        this.autreRevenu = autreRevenu;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.agence = agence;
        this.contentType = contentType;
        this.type = type;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public String getDocMeta() {
        return docMeta;
    }

    public void setDocMeta(String docMeta) {
        this.docMeta = docMeta;
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

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
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

    public String getAutreRevenu() {
        return autreRevenu;
    }

    public void setAutreRevenu(String autreRevenu) {
        this.autreRevenu = autreRevenu;
    }

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getFromClient() {
        return fromClient;
    }

    public void setFromClient(Boolean fromClient) {
        this.fromClient = fromClient;
    }

    public Boolean getFromAdmin() {
        return fromAdmin;
    }

    public void setFromAdmin(Boolean fromAdmin) {
        this.fromAdmin = fromAdmin;
    }

    @PrePersist()
    public void AddCustomInformationUser(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        this.agence=user.getAgence();
//        this.createdBy=user.getEmail();
//        this.createdAt=new Date();
//        this.updatedBy=user.getEmail();
//        this.updatedAt=new Date();
//
        if (this.fromAdmin != null && this.fromAdmin){
            this.agence= externalEndPointConfig.getDefault_agence();
            this.createdBy=externalEndPointConfig.getDefault_user();
            this.createdAt=new Date();
            this.updatedBy=externalEndPointConfig.getDefault_user();
            this.updatedAt=new Date();
        }else{
            DmInitiationServices services=new DmInitiationServices();
            User user=  services.getUser();
            this.agence=user.getAgence();
            this.createdBy=user.getEmail();
            this.createdAt=new Date();
            this.updatedBy=user.getEmail();
            this.updatedAt=new Date();
        }
    }

    @PreUpdate()
    public void UpdateCustomInformationUser(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        if(identifiant!=null && loanInitiationServices!=null){
//            DossierDocument lf=  loanInitiationServices.getDossierDocument(this.identifiant);
//            if(lf!=null) {
//                this.agence=lf.getAgence();
//                this.createdBy=lf.getCreatedBy();
//                this.createdAt=lf.getCreatedAt();
//            }
//        }
//        User user=  services.getUser();
//        this.updatedBy=user.getEmail();
//        this.updatedAt=new Date();

        DmInitiationServices services=new DmInitiationServices();
        if(identifiant!=null && dmInitiationServices !=null){
            CompteDocument lf=  dmInitiationServices.getCompteDocument(this.identifiant);
            if(lf!=null) {
                this.agence=lf.getAgence();
                this.createdBy=lf.getCreatedBy();
                this.createdAt=lf.getCreatedAt();
            }
        }
        if (this.fromAdmin != null && this.fromAdmin){
            System.out.println("Server action");
        }else {
            User user = services.getUser();
            this.updatedBy = user.getEmail();
            this.updatedAt = new Date();
        }
    }
}
