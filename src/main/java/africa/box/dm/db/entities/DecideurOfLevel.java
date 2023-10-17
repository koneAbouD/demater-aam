package africa.box.dm.db.entities;


import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "decideur_of_level",
        uniqueConstraints= @UniqueConstraint(columnNames={"idlevel", "decideur"}))
public class DecideurOfLevel implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String createdby;
    private Date createdat;
    private Integer idlevel;
    private String decideur;
    private String decideurFullName;
    private String role;
    private Integer priorite;
    private String businessKey;
    @Enumerated(EnumType.STRING)
    private NoteTypes decision;
    private String note;
    private String status;
    private String absence;

    public DecideurOfLevel() {
    }

    public DecideurOfLevel(Integer id, String createdby, Date createdat, Integer idlevel,
                           String decideur, String decideurFullName, String role, int priorite, String businessKey,
                           NoteTypes decision, String note, String status, String absence) {
        this.id = id;
        this.createdby = createdby;
        this.createdat = createdat;
        this.idlevel = idlevel;
        this.decideur = decideur;
        this.decideurFullName = decideurFullName;
        this.role = role;
        this.priorite = priorite;
        this.businessKey = businessKey;
        this.decision = decision;
        this.note = note;
        this.status = status;
        this.absence = absence;
    }

    @Override
    public String toString() {
        return "DecideurOfLevel{" +
                "id=" + id +
                ", createdby='" + createdby + '\'' +
                ", createdat=" + createdat +
                ", idlevel=" + idlevel +
                ", decideur='" + decideur + '\'' +
                ", decideurFullName='" + decideurFullName + '\'' +
                ", role='" + role + '\'' +
                ", priorite=" + priorite +
                ", businessKey='" + businessKey + '\'' +
                ", decision=" + decision +
                ", note='" + note + '\'' +
                ", status='" + status + '\'' +
                ", absence='" + absence + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Integer getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(Integer idlevel) {
        this.idlevel = idlevel;
    }

    public String getDecideur() {
        return decideur;
    }

    public void setDecideur(String decideur) {
        this.decideur = decideur;
    }

    public String getDecideurFullName() {
        return decideurFullName;
    }

    public void setDecideurFullName(String decideurFullName) {
        this.decideurFullName = decideurFullName;
    }

    public NoteTypes getDecision() {
        return decision;
    }

    public void setDecision(NoteTypes decision) {
        this.decision = decision;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getAbsence() {
        return absence;
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @PrePersist()
    public void AddCustomInformationUser(){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        this.createdby=user.getEmail();
        this.createdat=new Date();
    }

}
