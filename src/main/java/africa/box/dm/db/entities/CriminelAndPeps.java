package africa.box.dm.db.entities;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CriminelAndPeps")
@TypeDef(name = "jsonb", typeClass = JsonNodeType.class)
public class CriminelAndPeps implements Serializable  {
//    {
//        "updateAt": "2021-08-28",
//            "category": "PEP",
//            "name": "Nicolas Sarkozy",
//            "firstName": "Nicolas",
//            "lastName": "Sarkozy",
//            "gender": "male",
//            "datesOfBirth": [
//        {
//            "date": "1955-01-28"
//        }
//                ],
//        "placesOfBirth": [
//        {
//            "location": "Paris",
//                "country": "France"
//        }
//                ],
//        "referenceType": "PEP",
//            "nationality": "",
//            "citizenship": "France",
//            "places": [
//        {
//            "location": "Paris",
//                "type": "work location"
//        },
//        {
//            "location": "Strasbourg",
//                "type": "work location"
//        },
//        {
//            "location": "City of Brussels",
//                "type": "work location"
//        }
//                ],
//        "otherNames": [
//        {
//            "name": "Nicolas Paul Stéphane Sarközy de Nagy-Bocsa",
//                "type": "Also Known As"
//        },
//        {
//            "name": "Nicolas Sarközy",
//                "type": "Also Known As"
//        },
//        {
//            "name": "Nicolas Paul Stéphane Sarközy de Nagy-Bocsa",
//                "type": "birth name"
//        },
//        {
//            "name": "Nicolas Sarkozy",
//                "type": "name in native language"
//        }
//                ],
//        "roles": [
//        {
//            "title": "member of the French National Assembly",
//                "since": "1997-06-12",
//                "to": "2002-06-07"
//        },
//        {
//            "title": "member of the French National Assembly",
//                "since": "1995-09-24",
//                "to": "1997-04-21"
//        },
//        {
//            "title": "member of the French National Assembly",
//                "since": "2005-03-14",
//                "to": "2005-07-02"
//        },
//        {
//            "title": "member of the French National Assembly",
//                "since": "1993-04-02",
//                "to": "1993-05-01"
//        },
//        {
//            "title": "member of the French National Assembly",
//                "since": "2002-06-19",
//                "to": "2002-07-18"
//        },
//        {
//            "title": "member of the French National Assembly",
//                "since": "1988-06-23",
//                "to": "1993-04-01"
//        },
//        {
//            "title": "member of the European Parliament",
//                "since": "1999-07-20",
//                "to": "1999-09-14"
//        },
//        {
//            "title": "President of the French Republic",
//                "since": "2007-05-16",
//                "to": "2012-05-15"
//        },
//        {
//            "title": "Co-Prince of Andorra",
//                "since": "2007",
//                "to": "2012"
//        },
//        {
//            "title": "member of the regional council of Île-de-France",
//                "since": "",
//                "to": ""
//        },
//        {
//            "title": "Mayor of Neuilly-sur-Seine",
//                "since": "1983-04-14",
//                "to": "2002-05-07"
//        },
//        {
//            "title": "Minister of Culture (France)",
//                "since": "1994-07-19",
//                "to": "1995-05-11"
//        },
//        {
//            "title": "member of the general council",
//                "since": "",
//                "to": ""
//        },
//        {
//            "title": "Minister of the Economy, Finances and Industry",
//                "since": "2004-03-31",
//                "to": "2004-11-29"
//        },
//        {
//            "title": "Ministry of Budget, Public Accounts and Civil Administration",
//                "since": "1993-03-30",
//                "to": "1995-01-19"
//        },
//        {
//            "title": "Minister of the Interior",
//                "since": "2005-06-02",
//                "to": "2007-03-26"
//        },
//        {
//            "title": "Minister of the Interior",
//                "since": "2002-05-07",
//                "to": "2002-06-17"
//        },
//        {
//            "title": "Minister of the Interior",
//                "since": "2002-06-17",
//                "to": "2004-03-30"
//        },
//        {
//            "title": "president of the departmental council",
//                "since": "2004-04-01",
//                "to": "2007-05-14"
//        }
//                ],
//        "occupations": [
//        "politician",
//                "lawyer",
//                "statesperson"
//                ],
//        "father": "Paul Sarkozy",
//            "mother": "Andrée Mallah",
//            "spouse": "Carla Bruni",
//            "children": [
//        "Jean Sarkozy",
//                "Giulia Sarkozy",
//                "Pierre Sarkozy",
//                "Louis Sarkozy"
//                ],
//        "siblings": [
//        "Guillaume Sarkozy",
//                "Olivier Sarkozy",
//                "Caroline Sarkozy",
//                "François Sarkozy"
//                ],
//        "politicalParties": [
//        {
//            "title": "Union of Democrats for the Republic",
//                "since": "",
//                "to": ""
//        },
//        {
//            "title": "The Republicans",
//                "since": "",
//                "to": ""
//        },
//        {
//            "title": "Rally for the Republic",
//                "since": "",
//                "to": ""
//        },
//        {
//            "title": "Union for a Popular Movement",
//                "since": "",
//                "to": ""
//        }
//                ],
//        "contacts": [
//        {
//            "value": "NicolasSarkozy",
//                "type": "Twitter username"
//        },
//        {
//            "value": "nicolassarkozy",
//                "type": "Instagram username"
//        },
//        {
//            "value": "nicolassarkozy",
//                "type": "Facebook profile ID"
//        }
//                ],
//        "images": [
//        "http://commons.wikimedia.org/wiki/Special:FilePath/Nicolas%20Sarkozy%20%282015-10-29%29%2003%20%28cropped%29.jpg"
//                ],
//        "matchRate": 100.0
//    }
    @Id
    private String pepsAndCrimId;

    private String scanId;
    private String nomComplet_crim_peps;
    private String nom_crim_peps;
    private String prenom_crim_peps;
    private String pere_crim_peps;
    private String mere_crim_peps;
    private String epouse_crim_peps;
    private String categorie_crim_peps;
    private String nationalite_crim_peps;
    private Date dateDeNaissance_crim_peps;
    private String lieuDeNaissance_crim_peps;
    private String genre_crim_peps;
    private String villeResidence_crim_peps;
    private String image;
    private Integer tauxDeCorrespondance_crim_peps;
//    private List<Object> contacts_crim_peps;
//    private List<Object> lieuFrequenté_crim_peps;
//    private List<Object> parcoursPolitique_crim_peps;
//    private List<Object> partiesPolitique_crim_peps;
//    private List<Object> autresNom_crim_peps;
//    private List<Object> occupations_crim_peps;
//    private List<Object> frereEtSoeur_crim_peps;
//    private List<Object> enfants_crim_peps;
//    private List<Object> endroitFrequentes_crim_peps;
    private String sourceInformation_crim_peps;

    //*************************************************
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public CriminelAndPeps(){
    }

    public CriminelAndPeps(String pepsAndCrimId, String scanId, String nomComplet_crim_peps, String nom_crim_peps, String prenom_crim_peps, String pere_crim_peps, String mere_crim_peps, String epouse_crim_peps, String categorie_crim_peps, String nationalite_crim_peps, Date dateDeNaissance_crim_peps, String lieuDeNaissance_crim_peps, String genre_crim_peps, String villeResidence_crim_peps, String image, Integer tauxDeCorrespondance_crim_peps, String sourceInformation_crim_peps, Date createdAt, Date updatedAt) {
        this.pepsAndCrimId = pepsAndCrimId;
        this.scanId = scanId;
        this.nomComplet_crim_peps = nomComplet_crim_peps;
        this.nom_crim_peps = nom_crim_peps;
        this.prenom_crim_peps = prenom_crim_peps;
        this.pere_crim_peps = pere_crim_peps;
        this.mere_crim_peps = mere_crim_peps;
        this.epouse_crim_peps = epouse_crim_peps;
        this.categorie_crim_peps = categorie_crim_peps;
        this.nationalite_crim_peps = nationalite_crim_peps;
        this.dateDeNaissance_crim_peps = dateDeNaissance_crim_peps;
        this.lieuDeNaissance_crim_peps = lieuDeNaissance_crim_peps;
        this.genre_crim_peps = genre_crim_peps;
        this.villeResidence_crim_peps = villeResidence_crim_peps;
        this.image = image;
        this.tauxDeCorrespondance_crim_peps = tauxDeCorrespondance_crim_peps;
        this.sourceInformation_crim_peps = sourceInformation_crim_peps;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CriminelAndPeps{" +
                "pepsAndCrimId='" + pepsAndCrimId + '\'' +
                ", scanId='" + scanId + '\'' +
                ", nomComplet_crim_peps='" + nomComplet_crim_peps + '\'' +
                ", nom_crim_peps='" + nom_crim_peps + '\'' +
                ", prenom_crim_peps='" + prenom_crim_peps + '\'' +
                ", pere_crim_peps='" + pere_crim_peps + '\'' +
                ", mere_crim_peps='" + mere_crim_peps + '\'' +
                ", epouse_crim_peps='" + epouse_crim_peps + '\'' +
                ", categorie_crim_peps='" + categorie_crim_peps + '\'' +
                ", nationalite_crim_peps='" + nationalite_crim_peps + '\'' +
                ", dateDeNaissance_crim_peps=" + dateDeNaissance_crim_peps +
                ", lieuDeNaissance_crim_peps='" + lieuDeNaissance_crim_peps + '\'' +
                ", genre_crim_peps='" + genre_crim_peps + '\'' +
                ", villeResidence_crim_peps='" + villeResidence_crim_peps + '\'' +
                ", image='" + image + '\'' +
                ", tauxDeCorrespondance_crim_peps=" + tauxDeCorrespondance_crim_peps +
                ", sourceInformation_crim_peps='" + sourceInformation_crim_peps + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getPepsAndCrimId() {
        return pepsAndCrimId;
    }

    public void setPepsAndCrimId(String pepsAndCrimId) {
        this.pepsAndCrimId = pepsAndCrimId;
    }

    public String getScanId() {
        return scanId;
    }

    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    public String getNomComplet_crim_peps() {
        return nomComplet_crim_peps;
    }

    public void setNomComplet_crim_peps(String nomComplet_crim_peps) {
        this.nomComplet_crim_peps = nomComplet_crim_peps;
    }

    public String getNom_crim_peps() {
        return nom_crim_peps;
    }

    public void setNom_crim_peps(String nom_crim_peps) {
        this.nom_crim_peps = nom_crim_peps;
    }

    public String getPrenom_crim_peps() {
        return prenom_crim_peps;
    }

    public void setPrenom_crim_peps(String prenom_crim_peps) {
        this.prenom_crim_peps = prenom_crim_peps;
    }

    public String getPere_crim_peps() {
        return pere_crim_peps;
    }

    public void setPere_crim_peps(String pere_crim_peps) {
        this.pere_crim_peps = pere_crim_peps;
    }

    public String getMere_crim_peps() {
        return mere_crim_peps;
    }

    public void setMere_crim_peps(String mere_crim_peps) {
        this.mere_crim_peps = mere_crim_peps;
    }

    public String getEpouse_crim_peps() {
        return epouse_crim_peps;
    }

    public void setEpouse_crim_peps(String epouse_crim_peps) {
        this.epouse_crim_peps = epouse_crim_peps;
    }

    public String getCategorie_crim_peps() {
        return categorie_crim_peps;
    }

    public void setCategorie_crim_peps(String categorie_crim_peps) {
        this.categorie_crim_peps = categorie_crim_peps;
    }

    public String getNationalite_crim_peps() {
        return nationalite_crim_peps;
    }

    public void setNationalite_crim_peps(String nationalite_crim_peps) {
        this.nationalite_crim_peps = nationalite_crim_peps;
    }

    public Date getDateDeNaissance_crim_peps() {
        return dateDeNaissance_crim_peps;
    }

    public void setDateDeNaissance_crim_peps(Date dateDeNaissance_crim_peps) {
        this.dateDeNaissance_crim_peps = dateDeNaissance_crim_peps;
    }

    public String getLieuDeNaissance_crim_peps() {
        return lieuDeNaissance_crim_peps;
    }

    public void setLieuDeNaissance_crim_peps(String lieuDeNaissance_crim_peps) {
        this.lieuDeNaissance_crim_peps = lieuDeNaissance_crim_peps;
    }

    public String getGenre_crim_peps() {
        return genre_crim_peps;
    }

    public void setGenre_crim_peps(String genre_crim_peps) {
        this.genre_crim_peps = genre_crim_peps;
    }

    public String getVilleResidence_crim_peps() {
        return villeResidence_crim_peps;
    }

    public void setVilleResidence_crim_peps(String villeResidence_crim_peps) {
        this.villeResidence_crim_peps = villeResidence_crim_peps;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTauxDeCorrespondance_crim_peps() {
        return tauxDeCorrespondance_crim_peps;
    }

    public void setTauxDeCorrespondance_crim_peps(Integer tauxDeCorrespondance_crim_peps) {
        this.tauxDeCorrespondance_crim_peps = tauxDeCorrespondance_crim_peps;
    }

    public String getSourceInformation_crim_peps() {
        return sourceInformation_crim_peps;
    }

    public void setSourceInformation_crim_peps(String sourceInformation_crim_peps) {
        this.sourceInformation_crim_peps = sourceInformation_crim_peps;
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
}
