package africa.box.dm.db.entities;

import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Notes implements Serializable {

//    @Transient
//    @Autowired
//    LoanInitiationServices loanInitiationServices;
    private Date date;
    private String createdby;
    private String fullName;
    @NotNull(message = "La note ne doit pas être null")
    @NotBlank(message = "La note ne doit pas être null")
    private String note;
    private String sla;
    @NotNull(message = "La clé du Bussinesskey ne doit pas être nulle ou vide")
    @NotBlank(message = "La clé du Bussinesskey ne doit pas être nulle ou vide")
    private String businessKey;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer level;

    private String decision;

    @Enumerated(EnumType.STRING)
    private NoteTypes type;

    public NoteTypes getType() {
        return type;
    }

    @Transient
    @Autowired
    DmInitiationServices dmInitiationServices ;

    @Override
    public String toString() {
        return "Notes{" +
                "date=" + date +
                ", createdby='" + createdby + '\'' +
                ", fullName='" + fullName + '\'' +
                ", note='" + note + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", id=" + id +
                ", level=" + level +
                ", decision='" + decision + '\'' +
                ", type=" + type +
                ", sla=" + sla +
                '}';
    }

    public Notes(Date date, String createdby,
                 @NotNull(message = "La note ne doit pas être null")
                 @NotBlank(message = "La note ne doit pas être null") String note,
                 @NotNull(message = "La clé du Bussinesskey ne doit pas être nulle ou vide")
                 @NotBlank(message = "La clé du Bussinesskey ne doit pas être nulle ou vide") String businessKey,
                 Integer id,
                 Integer level,
                 String decision,
                 NoteTypes type, String sla) {
        this.date = date;
        this.createdby = createdby;
        this.note = note;
        this.businessKey = businessKey;
        this.id = id;
        this.level = level;
        this.decision = decision;
        this.type = type;
        this.sla = sla;
    }

    public Notes() {
    }

    public void setType(NoteTypes type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
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

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getSla() {
        return sla;
    }

    public void setSla(String sla) {
        this.sla = sla;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @PrePersist()
    public void AddCustomInformationUser(){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        this.createdby=user.getEmail(); //user.getEmail()
        this.date=new Date();
        this.fullName = user.getFullName(); //user.getFullName()
    }

    @PreUpdate()
    public void UpdateCustomInformationUser(){
//        DmInitiationServices services=new DmInitiationServices();
        if(businessKey!=null && dmInitiationServices!=null){
            Compte lf=  dmInitiationServices.getDossier(this.businessKey);
            if(lf!=null) {
                this.createdby=lf.getCreatedBy();
                this.date=lf.getCreatedAt();
            }
        }
//        User user=  services.getUser();
    }
}
