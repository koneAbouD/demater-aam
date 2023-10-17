package africa.box.dm.db.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import net.minidev.json.JSONObject;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import java.util.Date;

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ExternalCompteDocument {

    private String identifiant;
    private String doccode;
    private String business_key;
    private String docpath;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private JSONObject docmetadacanevas;
    private String name;
    private String description;
    private int numberofcopies;
    private String statut;
    private Boolean facultatif;
    private Integer id;
    private String documentstatus;
    private Boolean fromclient ;
    private Date createdat;
    private Date updatedat;
    private String content_type;

    public ExternalCompteDocument() {
    }

    public ExternalCompteDocument(String identifiant, String doccode, String business_key, String docpath, JSONObject docmetadacanevas, String name, String description, int numberofcopies, String statut, Boolean facultatif, Integer id, String documentstatus, Boolean fromclient, Date createdat, Date updatedat, String content_type) {
        this.identifiant = identifiant;
        this.doccode = doccode;
        this.business_key = business_key;
        this.docpath = docpath;
        this.docmetadacanevas = docmetadacanevas;
        this.name = name;
        this.description = description;
        this.numberofcopies = numberofcopies;
        this.statut = statut;
        this.facultatif = facultatif;
        this.id = id;
        this.documentstatus = documentstatus;
        this.fromclient = fromclient;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.content_type = content_type;
    }

    @Override
    public String toString() {
        return "ExternalDossierDocument{" +
                "identifiant='" + identifiant + '\'' +
                ", doccode='" + doccode + '\'' +
                ", business_key='" + business_key + '\'' +
                ", docpath='" + docpath + '\'' +
                ", docmetadacanevas='" + docmetadacanevas + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberofcopies=" + numberofcopies +
                ", statut='" + statut + '\'' +
                ", facultatif=" + facultatif +
                ", id=" + id +
                ", documentstatus='" + documentstatus + '\'' +
                ", fromclient=" + fromclient +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", content_type='" + content_type + '\'' +
                '}';
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDoccode() {
        return doccode;
    }

    public void setDoccode(String doccode) {
        this.doccode = doccode;
    }

    public String getBusiness_key() {
        return business_key;
    }

    public void setBusiness_key(String business_key) {
        this.business_key = business_key;
    }

    public String getDocpath() {
        return docpath;
    }

    public void setDocpath(String docpath) {
        this.docpath = docpath;
    }

    public JSONObject getDocmetadacanevas() {
        return docmetadacanevas;
    }

    public void setDocmetadacanevas(JSONObject docmetadacanevas) {
        this.docmetadacanevas = docmetadacanevas;
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

    public int getNumberofcopies() {
        return numberofcopies;
    }

    public void setNumberofcopies(int numberofcopies) {
        this.numberofcopies = numberofcopies;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentstatus() {
        return documentstatus;
    }

    public void setDocumentstatus(String documentstatus) {
        this.documentstatus = documentstatus;
    }

    public Boolean getFromclient() {
        return fromclient;
    }

    public void setFromclient(Boolean fromclient) {
        this.fromclient = fromclient;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }
}
