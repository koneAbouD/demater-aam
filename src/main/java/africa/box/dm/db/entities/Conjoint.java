package africa.box.dm.db.entities;

import africa.box.dm.utils.DateFormatter;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = Conjoint.TABLE_NAME)
@Access(AccessType.FIELD)
public class Conjoint {
    public static final String TABLE_NAME = "conjoint";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String nomMere;
    private String typeClient;
    private String mobile;
    private String adresse;
    private String email;
    private String ville;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "NATIONALITE_CODE")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "NATIONALITE_NAME")),
    })
    private Pays nationalite;
    private String regimeMatrimonial;
    private String situationMatrimonial;
    private String codePostal;
    private String boitePostal;
    private String typeDePiece;
    private String profession;
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.PERSIST,CascadeType.REMOVE})
    private CategorieProfessionnelle categorieProfessionnelle;
    private String salaireMensuel;
    private BigDecimal montantDesRevenus = BigDecimal.valueOf(0);
    private String Agence;
    private String customercode;
    private Boolean listPepsEtCrimVerifier = false;
    private Boolean cipVerifier;
    private String langue;

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
            @AttributeOverride(name = "code", column = @Column(name = "PAYS_RESIDENCE_CODE")),
            @AttributeOverride(name = "sigl", column = @Column(name = "PAYS_RESIDENCE_SIGL")),
            @AttributeOverride(name = "name", column = @Column(name = "PAYS_RESIDENCE_NAME")),
            @AttributeOverride(name = "nationalite", column = @Column(name = "PAYS_RESIDENCE_NATIONALITE")),
    })
    private Pays paysResidence;
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
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Gestionnaire gestionnaire;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private CapaciteJuridique capaciteJuridique;
    private String adresseCourrierPermanente;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Profil profil;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private ResidenceDeclaration residenceDeclaration;
    @OneToOne(cascade=CascadeType.ALL)
    private LienApparenteBanque lienApparenteBanque;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private NiveauRisqueRelationClient niveauRisqueRelationClient;
    private Boolean personnePolitiquementExpos;
    private Boolean interdictionChequier;
    private Boolean flagSurveillance;
    private Boolean isQualite;
    @OneToOne(cascade=CascadeType.ALL)
    private PartenaireDeMariage partenaireDeMariage;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Territorialite territorialite;
    private String nomPersoAContact;
    private String prenomPersoAContact;
    private String filationAvecClient;
    private String contactPersoContact;
    private String lieuResidenceContact;
    private String precisionContact;
    private String emailPersoContact;
    public void setDateNaissance(String dateNaissance) {
            if (dateNaissance != null) {
                LocalDate date = DateFormatter.toDate(dateNaissance.replace("-", "/"));
                this.dateNaissance = date;
            }
    }
}
