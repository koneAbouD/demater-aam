package africa.box.dm.consumer.banking;
import africa.box.dm.utils.DateFormatter;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompteAmplitude {
    String nom;
    String prenom;
    String nomPrenom;
    LocalDate dateNaissance;
    String genre;
    String nomMere;
    String typeClient;
    String typeCompte;
    String mobile;
    String adresse;
    String email;
    String ville;
    String codeNationalite;
    String codePostal;
    String boitePostal;
    String typePiece;
    String numPiece;
    String situationMatrimonial;
    String regimeMatrimonial;
    String autorityPiece;
    String lieuDelivrancePiece;
    LocalDate dateDelivrancePiece;
    LocalDate dateValiditePiece;
    String profession;
    String categorieProfessionnelle;
    BigDecimal montantDesRevenus = BigDecimal.valueOf(0);
    String memo = "Creation client";
    String codeAgence;
    String codePaysResidence;
    String titleCode;
    String typeConjoint;
    String customerCodeConjoint;
    String typeLien;
    Boolean toBePrintedInTheAddress;
    Boolean isCompteConjoint;
    String codeLangueParle;
    String codeTrancheRevenus;


    String villeNaissance;
    String dptNaissance;
    String codePaysNaissance;
    String codeCapaciteJuridique;
    String codeGestionnaire;
    String adresseCourrierPermanente;
    String codeProfil;
    String codeTerritorialite = "1";
    String codeResidenceDeclaration;
    String codeAgentEconomique = "2420";
    String codeLienApparenteBanque;
    String codeNiveauRisqueRelationClient;
    Boolean personnePolitiquementExpos;
    Boolean interdictionChequier;
    String nomPartenaire;
    String prenomPartenaire;
    String dateNaissancePartenaire;
    String villePartenaire;
    String dptPartenaire;

    public void setDateNaissance(String dateNaissance) {
        if (dateNaissance != null) {
            LocalDate date = DateFormatter.toDate(dateNaissance.replace("-", "/"));
            this.dateNaissance = date;
        }
    }
}