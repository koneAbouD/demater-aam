package africa.box.dm.db.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "actionnaire")
public class Actionnaire implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String identifiant;
    private String businessKey;
//    private String nom;
//    private String prenom;
//    private Date dateNaissance;
//    private String lieuNaissance;
//    private String identifiant;

    private String typeActionnaire;
    private String nomSocieteActionnaire;
    private String numeroRegActionnaire;
    private String genreActionnaire;
    private String nomActionnaire;
    private String prenomActionnaire;
    private String dateNaissanceActionnaire;
    private String lieuDeNaissanceActionnaire;
    private String mobileActionnaire;
    private String emailActionnaire;
    private Boolean isSignataire;
    private Boolean isGerant;
    private Boolean isDg;
    private Boolean isPdg;
    private Boolean isDirigeant;

    public Actionnaire() {
    }

    public Actionnaire(String identifiant, String businessKey, String typeActionnaire, String nomSocieteActionnaire, String numeroRegActionnaire, String genreActionnaire, String nomActionnaire, String prenomActionnaire, String dateNaissanceActionnaire, String lieuDeNaissanceActionnaire, String mobileActionnaire, String emailActionnaire, Boolean isSignataire, Boolean isGerant, Boolean isDg, Boolean isPdg, Boolean isDirigeant) {
        this.identifiant = identifiant;
        this.identifiant = businessKey;
        this.typeActionnaire = typeActionnaire;
        this.nomSocieteActionnaire = nomSocieteActionnaire;
        this.numeroRegActionnaire = numeroRegActionnaire;
        this.genreActionnaire = genreActionnaire;
        this.nomActionnaire = nomActionnaire.toUpperCase();
        this.prenomActionnaire = prenomActionnaire.toLowerCase();
        this.dateNaissanceActionnaire = dateNaissanceActionnaire;
        this.lieuDeNaissanceActionnaire = lieuDeNaissanceActionnaire;
        this.mobileActionnaire = mobileActionnaire;
        this.emailActionnaire = emailActionnaire;
        this.isSignataire = isSignataire;
        this.isGerant = isGerant;
        this.isDg = isDg;
        this.isPdg = isPdg;
        this.isDirigeant = isDirigeant;
    }

    @Override
    public String toString() {
        return "Actionnaire{" +
                "identifiant='" + identifiant + '\'' +
                "businessKey='" + businessKey + '\'' +
                ", typeActionnaire='" + typeActionnaire + '\'' +
                ", nomSocieteActionnaire='" + nomSocieteActionnaire + '\'' +
                ", numeroRegActionnaire='" + numeroRegActionnaire + '\'' +
                ", genreActionnaire='" + genreActionnaire + '\'' +
                ", nomActionnaire='" + nomActionnaire + '\'' +
                ", prenomActionnaire='" + prenomActionnaire + '\'' +
                ", dateNaissanceActionnaire='" + dateNaissanceActionnaire + '\'' +
                ", lieuDeNaissanceActionnaire='" + lieuDeNaissanceActionnaire + '\'' +
                ", mobileActionnaire='" + mobileActionnaire + '\'' +
                ", emailActionnaire='" + emailActionnaire + '\'' +
                ", isSignataire=" + isSignataire +
                ", isGerant=" + isGerant +
                ", isDg=" + isDg +
                ", isPdg=" + isPdg +
                ", isDirigeant=" + isDirigeant +
                '}';
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTypeActionnaire() {
        return typeActionnaire;
    }

    public void setTypeActionnaire(String typeActionnaire) {
        this.typeActionnaire = typeActionnaire;
    }

    public String getNomSocieteActionnaire() {
        return nomSocieteActionnaire;
    }

    public void setNomSocieteActionnaire(String nomSocieteActionnaire) {
        this.nomSocieteActionnaire = nomSocieteActionnaire;
    }

    public String getNumeroRegActionnaire() {
        return numeroRegActionnaire;
    }

    public void setNumeroRegActionnaire(String numeroRegActionnaire) {
        this.numeroRegActionnaire = numeroRegActionnaire;
    }

    public String getGenreActionnaire() {
        return genreActionnaire;
    }

    public void setGenreActionnaire(String genreActionnaire) {
        this.genreActionnaire = genreActionnaire;
    }

    public String getNomActionnaire() {
        return nomActionnaire;
    }

    public void setNomActionnaire(String nomActionnaire) {
        this.nomActionnaire = nomActionnaire.toUpperCase();
    }

    public String getPrenomActionnaire() {
        return prenomActionnaire;
    }

    public void setPrenomActionnaire(String prenomActionnaire) {
        this.prenomActionnaire = prenomActionnaire.toLowerCase();
    }

    public String getDateNaissanceActionnaire() {
        return dateNaissanceActionnaire;
    }

    public void setDateNaissanceActionnaire(String dateNaissanceActionnaire) {
        this.dateNaissanceActionnaire = dateNaissanceActionnaire;
    }

    public String getLieuDeNaissanceActionnaire() {
        return lieuDeNaissanceActionnaire;
    }

    public void setLieuDeNaissanceActionnaire(String lieuDeNaissanceActionnaire) {
        this.lieuDeNaissanceActionnaire = lieuDeNaissanceActionnaire;
    }

    public String getMobileActionnaire() {
        return mobileActionnaire;
    }

    public void setMobileActionnaire(String mobileActionnaire) {
        this.mobileActionnaire = mobileActionnaire;
    }

    public String getEmailActionnaire() {
        return emailActionnaire;
    }

    public void setEmailActionnaire(String emailActionnaire) {
        this.emailActionnaire = emailActionnaire;
    }

    public Boolean getSignataire() {
        return isSignataire;
    }

    public void setSignataire(Boolean signataire) {
        isSignataire = signataire;
    }

    public Boolean getGerant() {
        return isGerant;
    }

    public void setGerant(Boolean gerant) {
        isGerant = gerant;
    }

    public Boolean getDg() {
        return isDg;
    }

    public void setDg(Boolean dg) {
        isDg = dg;
    }

    public Boolean getPdg() {
        return isPdg;
    }

    public void setPdg(Boolean pdg) {
        isPdg = pdg;
    }

    public Boolean getDirigeant() {
        return isDirigeant;
    }

    public void setDirigeant(Boolean dirigeant) {
        isDirigeant = dirigeant;
    }

}
