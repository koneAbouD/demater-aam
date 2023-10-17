package africa.box.dm.dto;



import africa.box.dm.db.entities.DocumentStatus;
import africa.box.dm.service.Utils;

import java.util.Date;


public class DocumentDto {

    private String identifiant;

    private String docCode;
    private String businessKey;
    private String docPath;
    private String docMeta;
    private String name;
    private String description;
    private int numberOfCopies;
    private String statut;
    private Boolean facultatif;

    // relation
    private String autreRevenu;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String contentType;
    private String type;
    private DocumentStatus documentstatus;

    public DocumentDto() {
        this.identifiant = Utils.newKey();
        this.createdAt=new Date();
    }

    public DocumentStatus getDocumentstatus() {
        return documentstatus;
    }

    public void setDocumentstatus(DocumentStatus documentstatus) {
        this.documentstatus = documentstatus;
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
}
