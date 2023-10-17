package africa.box.dm.db.entities;

import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (name="level_decision")
public class LevelDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotNull
    private Integer level;
    private String description;
    private Integer waitingforlevel;
    private Date dateEcheance;
    private  NoteTypes status;
    @NotNull
    @NotBlank
    private String businessKey;
    private String createdby;
    private Date createdat;

    public LevelDecision() {
    }

    public LevelDecision(Integer id, Integer level, String description, Integer waitingforlevel, Date dateEcheance,
                         NoteTypes status, String businessKey, String createdby, Date createdat) {
        this.id = id;
        this.level = level;
        this.description = description;
        this.waitingforlevel = waitingforlevel;
        this.dateEcheance = dateEcheance;
        this.status = status;
        this.businessKey = businessKey;
        this.createdby = createdby;
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "LevelDecision{" +
                "id=" + id +
                ", level=" + level +
                ", description=" + description +
                ", waitingforlevel=" + waitingforlevel +
                ", dateEcheance=" + dateEcheance +
                ", status='" + status + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createdat=" + createdat +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWaitingforlevel() {
        return waitingforlevel;
    }

    public void setWaitingforlevel(Integer waitingforlevel) {
        this.waitingforlevel = waitingforlevel;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public NoteTypes getStatus() {
        return status;
    }

    public void setStatus(NoteTypes status) {
        this.status = status;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String bussinesskey) {
        this.businessKey = bussinesskey;
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

    @PrePersist()
    public void AddCustomInformationUser(){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        this.createdby=user.getEmail();
        this.createdat=new Date();
    }
}
