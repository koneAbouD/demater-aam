package africa.box.dm.db.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "decideur_template")
public class DecideurTemplate implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private Integer priorite;
    private String status;
    private String typeLevel;
    private String agence;

    @Override
    public String toString() {
        return "DecideurTemplate{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", priorite=" + priorite +
                ", status='" + status + '\'' +
                ", typeLevel='" + typeLevel + '\'' +
                ", agence='" + agence + '\'' +
                '}';
    }

    public DecideurTemplate() {
    }

    public DecideurTemplate(Integer id, String nom, String prenom, String email, String role, Integer priorite, String status, String typeLevel, String agence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        this.priorite = priorite;
        this.status = status;
        this.typeLevel = typeLevel;
        this.agence = agence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(String typeLevel) {
        this.typeLevel = typeLevel;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }
}
