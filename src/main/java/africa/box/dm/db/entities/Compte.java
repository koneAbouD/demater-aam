package africa.box.dm.db.entities;

import africa.box.dm.config.ExternalEndPointConfig;
import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;
import africa.box.dm.utils.DateFormatter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = Compte.TABLE_NAME)
@TypeDef(name = "jsonb", typeClass = JsonNodeType.class)
public class Compte implements Serializable {
    public static final String TABLE_NAME = "Compte";

    @Id
    private String businessKey;
    // Information sur le compte
    private String applicantId;
    private String externalUserId;
    private String typeCompte;
    private String motifOuverture;
    private String typeDemandeur;
    private String sousTypeClient;
    private Boolean isMineur;
    private Boolean isClient;
    private Boolean isClientCIP;
    private Boolean isConjoint;
    // Information sur le client
    private String nomSociete;
    private Date dateCreationSociete;
    private String numeroRegistreCommerce;
    private Date dateRegistreCom;
    private String lieuRegistreCom;
    private String secteurActiveEntrep;
    private String sousSecteurAct;
    private Boolean isDemarche;
    private Boolean isAutreSignataire;
    private String matricule;
    private String genre;
    private String nomDemandeur;
    private String prenomDemandeur;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "NATIONALITE_CODE")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "NATIONALITE_NAME")),
    })
    private Pays nationalite;
    private String situationMatrimonial;
    private String nomDeNaissance;
    private LocalDate dateDeNaissance;
    private Date dateDeEmbauche;
    private String lieuDeNaissance;
    private Boolean personnePolitique;
    private Boolean listeCriminel;
    private Boolean listPepsEtCrimVerifier = false;
    private Integer indexPepsEtCrim;
    private Integer nombreSignatures;
    private String detailsPersonnePolitique;
    private String isCarteBancaire;
    private String nomSurCarte;
    private String devise;
    private String formeJuridique;
    private String compteContribuablelEnt;
    //@Column(columnDefinition="TEXT")
    @Transient
    @Autowired
    DmInitiationServices services;

//    private String listAutreSignataire;

    private String centreImpotEnt;
    private String augmentation;
    private String delaisRegClientEnt;
    private String concurentSecteurEnt;
    private String tailleConcurentEnt;
    private String fournisseursEnt;
    private String modeCommercialEnt;

    // Information sur les Coordonnees du client
    private String mobile;
    private Boolean isMobile2;
    private String mobile2;
    private String fixe;
    private String email;
    private String adresse;
    private Boolean isAdresse2;
    private String siegeSocialEnt;
    private String siteInternetEnt;
    private String adresse2;
    private String situationGeographique;
    private String boitePostal;
    private String codePostal;
    private String ville;
    private String nomPersoAContact;
    private String prenomPersoAContact;
    private String filationAvecClient;
    private String contactPersoContact;
    private String lieuResidenceContact;
    private String precisionContact;
    private String emailPersoContact;

    // Information sur les revenus et l'employeur
    private BigDecimal salaireMensuel;
    private boolean isAutreRevenu;
    @Transient
    private List<AutreRevenu> listAutreRevenu = new ArrayList<>();
    private BigDecimal montantDesRevenus;
    private BigDecimal montantDesCharges;
    private BigDecimal montantEstimTransact;
    private String grade;
    private String poste;
    private String nomEmployeur;
    private String emailEmployeur;
    private String anciennete;
    private String effectifEntreprise;
    private Double chiffresAffaires;
    private Double capitalEntreprise;

    // Information Complementaire
    private String garant;
    private String proprietaire;
    private Integer nombreEnfants;
    private Integer personneACharge;
    private String niveauEtude;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DmStatus status;
    private Boolean fromOnboarding = false;
    private Boolean fromAdmin = false;
    private Boolean isNouvelleSociete;
    private String numIdentifiantFisc;
    private String nombreActionnaire;
    private Boolean isSignataire;
    private Boolean isGerant;
    private Boolean isDg;
    private Boolean isPdg;
    private Boolean isDirigeant;
    private Boolean isAutreActionnaire;
    @Transient
    private List<Actionnaire> listAutreActionnaire;
    private String mobileDemandeur;
    private String emailDemandeur;
    private String observationText;
    private Boolean cipVerifier;
    private String signatureUrl;
    private Date signatureDate;
    private Boolean signatureVoloEffectue;
    private Boolean signatureCompteEffectue;
    private String typeDePiece;
    private String numeroDePiece;
    private Date dateExpirationPiece;
    private Date dateCreationPiece;
    private String telephoneEmployeur;
    private String langue;

    @Column(nullable = true)
    private boolean proprietaireBiens = false;

    @ElementCollection
    private List<ApplicantGood> biens = new ArrayList<>();
    @ElementCollection
    Set<CarteBancaire> carteBancaires = new HashSet<>();

    private String regimeMatrimonial;

    private String partnerName;
    private String motherFullName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "authority", column = @Column(name = "REGISTERED_ID_AUTHORITY")),
            @AttributeOverride(name = "number", column = @Column(name = "REGISTERED_ID_NUMBER")),
            @AttributeOverride(name = "validFrom", column = @Column(name = "REGISTERED_ID_VALID_FROM")),
            @AttributeOverride(name = "validTo", column = @Column(name = "REGISTERED_ID_VALID_TO"))
    })
    private RegisteredID registeredID;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "CHEQUIER_TYPE")),
            @AttributeOverride(name = "numberOfPapers", column = @Column(name = "CHEQUIER_TYPE_NUMBER_OF_PAPERS")),

    })
    private Chequier chequier;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nom", column = @Column(name = "MINEUR_NOM")),
            @AttributeOverride(name = "prenom", column = @Column(name = "MINEUR_PRENOM")),
            @AttributeOverride(name = "dateNaissance", column = @Column(name = "MINEUR_DATE_NAISSANCE")),
            @AttributeOverride(name = "lieuNaissance", column = @Column(name = "MINEUR_LIEU_NAISSANCE")),
            @AttributeOverride(name = "genre", column = @Column(name = "MINEUR_GENRE")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "MINEUR_NATIONALITE"))
    })
    private Mineur minor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "PAYS_RESIDENCE_CODE")),
            @AttributeOverride(name = "sigl", column = @Column(name = "PAYS_RESIDENCE_SIGL")),
            @AttributeOverride(name = "name", column = @Column(name = "PAYS_RESIDENCE_NAME")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "PAYS_RESIDENCE_NATIONALITE")),
    })
    private Pays paysResidence;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private CategorieProfessionnelle categorieProfessionnelle;

    @OneToOne(cascade=CascadeType.ALL)
    private Conjoint conjoint;
    // Signature du client
    @Lob
    private byte[] signature;
    private String geolocalization;
    private String customerCodeConjoint;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "updated_by")
    private String updatedBy;
    private String agence;
    private String geopoint;
    private String customercode;

    @Transient
    @Autowired
    ExternalEndPointConfig externalEndPointConfig;

    @Transient
    @Autowired
    DmInitiationServices dmInitiationServices;

    @OneToOne(cascade = {CascadeType.ALL})
    ReleveIdentiteBancaire rib;
    // Newwwwwwwwwwwwwww
    private String villeNaissance;
    private String dptNaissance;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "PAYS_NAISSANCE_CODE")),
            @AttributeOverride(name = "sigl", column = @Column(name = "PAYS_NAISSANCE_SIGL")),
            @AttributeOverride(name = "name", column = @Column(name = "PAYS_NAISSANCE_NAME")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "PAYS_NAISSANCE_NATIONALITE")),
    })
    private Pays paysNaissance;
    @OneToOne(cascade=CascadeType.ALL)
    private Gestionnaire gestionnaire;
    @OneToOne(cascade=CascadeType.ALL)
    private CapaciteJuridique capaciteJuridique;
    private String adresseCourrierPermanente;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Profil profil;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private ResidenceDeclaration residenceDeclaration;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private LienApparenteBanque lienApparenteBanque;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private NiveauRisqueRelationClient niveauRisqueRelationClient;
    private Boolean personnePolitiquementExpos;
    private Boolean interdictionChequier;
    private Boolean flagSurveillance;
    @OneToOne(cascade=CascadeType.ALL)
    private PartenaireDeMariage partenaireDeMariage;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Territorialite territorialite;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Enfant> enfants;

    public void setDateDeNaissance(String dateDeNaissance) {
            if (dateDeNaissance != null) {
                LocalDate date = DateFormatter.toDate(dateDeNaissance.replace("-", "/"));
                this.dateDeNaissance = date;
            }
    }
    @PrePersist()
    public void AddCustomInformationUser() {
        if (this.fromAdmin != null && this.fromAdmin) {
            this.agence = externalEndPointConfig.getDefault_agence();
            this.createdBy = externalEndPointConfig.getDefault_user();
            this.createdAt = new Date();
            this.updatedBy = externalEndPointConfig.getDefault_user();
            this.updatedAt = new Date();
        } else {
            DmInitiationServices services = new DmInitiationServices();
            User user = services.getUser();
            this.agence = user.getAgence();
            this.createdBy = user.getFullName();
            this.createdAt = new Date();
            this.updatedBy = user.getFullName();
            this.updatedAt = new Date();
        }
    }
    @PreUpdate()
    public void UpdateCustomInformationUser() {

        DmInitiationServices services = new DmInitiationServices();
        if (businessKey != null && dmInitiationServices != null) {
            Compte lf = dmInitiationServices.getDossier(this.businessKey);
            if (lf != null) {
                this.agence = lf.getAgence();
                this.createdBy = lf.getCreatedBy();
                this.createdAt = lf.getCreatedAt();
            }
        }
        if (this.fromAdmin != null && this.fromAdmin) {
        } else {
            User user = services.getUser();
            this.updatedBy = user.getEmail();
            this.updatedAt = new Date();
        }
    }

    public Boolean getFromOnboarding() {
        return fromOnboarding;
    }

    public void setFromOnboarding(Boolean fromOnboarding) {
        this.fromOnboarding = fromOnboarding;
    }

    public Compte(String businessKey) {
        this.businessKey = businessKey;
    }

    public Boolean getIsConjoint() {
        return isConjoint;
    }

    @JsonIgnore
    public String getFullName() {
        return nomDemandeur + " " + prenomDemandeur;
    }
    public Compte(String businessKey, String applicantId, String externalUserId, String typecompte, String motifouverture, String typedemandeur, String soustypeclient, Boolean ismineur, Boolean isclient, Boolean isclientcip, String nomsociete, Date datecreationsociete, String numeroregistrecommerce, Date dateregistrecom, String lieuregistrecom, String secteuractiveentrep, Boolean isdemarche, Boolean isautresignataire, String matricule, String genre, String nomdemandeur, String prenomdemandeur, String nationalite, String situationmatrimonial, String nomdenaissance, Date datedenaissance, String lieudenaissance, Boolean personnePolitique, String detailspersonnepolitique, String isCarteBancaire, String nomsurcarte, String devise, String formejuridique, String comptecontribuablelent, String listAutreSignataire, String centreimpotent, String augmentation, String delaisregclientent, String concurentsecteurent, String tailleconcurentent, String fournisseursent, String modecommercialent, String mobile, Boolean ismobile2, String mobile2, String fixe, String email, String adresse, Boolean isadresse2, String siegesocialent, String siteinternetent, String adresse2, String situationgeographique, String boitepostal, String codepostal, String ville, String pays, String nompersoacontact, String prenompersoacontact, String filationavecclient, String contactpersocontact, String lieuresidencecontact, String precisioncontact, Double salairemensuel, Boolean isautrerevenu, Double montantdesrevenus, Double montantdescharges, Double montantestimtransact, String grade, String poste, String nomemployeur, String emailemployeur, String anciennete, String effectifentreprise, Double chiffresaffaires, Double capitalentreprise, String garant, String proprietaire, Integer nombreenfants, Integer personneacharge, String niveauetude, DmStatus status, Date created_at, String created_by, Date updated_at, String updated_by, String agence, Boolean fromOnboarding, String sousSecteurAct, String observationText, Boolean cipVerifier, String signatureUrl, Date signatureDate, Boolean signitureEffectue, Boolean signatureVoloEffectue, Boolean signatureCompteEffectue, String typeDePiece, String numeroDePiece, String dateExpirationPiece, String dateCreationPiece, String telephoneEmployeur, String geopoint, Boolean listeCriminel, Boolean listPepsEtCrimVerifier, Integer indexPepsEtCrim) {

    }
}