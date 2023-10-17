package africa.box.dm.db.entities;

import africa.box.dm.dto.User;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.DmInitiationServices;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "log_info")
public class LogInfo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String type;
    private String text;
    private String destinatairemail;
    private String fullname;
    private String status;
    private String app;
    private String parent;
    private String iddossier;
    private String createdBy;
    private Date createdAt;

    public LogInfo() {
    }

    public LogInfo(Integer id, String type, String text,
                   String destinatairemail, String fullname,
                   String status, String app, String parent,
                   String iddossier, String createdBy, Date createdAt) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.destinatairemail = destinatairemail;
        this.fullname = fullname;
        this.status = status;
        this.app = app;
        this.parent = parent;
        this.iddossier = iddossier;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", destinatairemail='" + destinatairemail + '\'' +
                ", fullname='" + fullname + '\'' +
                ", status='" + status + '\'' +
                ", app='" + app + '\'' +
                ", parent='" + parent + '\'' +
                ", iddossier='" + iddossier + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDestinatairemail() {
        return destinatairemail;
    }

    public void setDestinatairemail(String destinatairemail) {
        this.destinatairemail = destinatairemail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getIddossier() {
        return iddossier;
    }

    public void setIddossier(String iddossier) {
        this.iddossier = iddossier;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist()
    public void AddCustomInformationUser(){
        DmInitiationServices services = new DmInitiationServices();
        User user = services.getUser();
        this.createdBy=user.getEmail();
        this.createdAt=new Date();
        this.app="loan";
    }
}
