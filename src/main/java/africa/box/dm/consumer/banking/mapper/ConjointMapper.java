package africa.box.dm.consumer.banking.mapper;

import africa.box.dm.consumer.banking.CompteAmplitude;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.Conjoint;

import java.math.BigDecimal;

import static africa.box.dm.config.ValuesParam.*;
import static com.squareup.okhttp.internal.Internal.logger;

public class ConjointMapper {
    public static String forceCodePostal(Conjoint conjoint){
        logger.info("Champ code postal du conjoint force par defaut à la ville: "+conjoint.getVille());
        return conjoint.getVille();
    }
    public static CompteAmplitude toCompteAmplitude(Conjoint conjoint) {

        if (conjoint == null) {
            return null;
        } else {
            return CompteAmplitude.builder()
                    .nom(conjoint.getNom())
                    .prenom(conjoint.getPrenom())
                    .nomPrenom(conjoint.getNom()+" "+conjoint.getPrenom())
                    .dateNaissance(conjoint.getDateNaissance())
                    .villeNaissance(conjoint.getVilleNaissance())
                    .genre(conjoint.getGenre().equals("Homme") ? "M" : "F")
                    .nomMere(conjoint.getNomMere())
                    .typeClient(conjoint.getTypeClient())
                    .mobile(conjoint.getMobile())
                    .adresse(conjoint.getAdresse())
                    .email(conjoint.getEmail())
                    .ville(conjoint.getVille())
                    .codeNationalite(conjoint.getNationalite().getCode())
                    .codeLangueParle(getLangueParle(conjoint.getLangue()))
                    .boitePostal(conjoint.getBoitePostal())
                    .situationMatrimonial(getSituationFamille(conjoint.getSituationMatrimonial()))
                    .regimeMatrimonial(conjoint.getRegimeMatrimonial() != null ? getRegimeMatrimonial(conjoint.getRegimeMatrimonial()) : null)
                    .codePaysResidence(conjoint.getPaysResidence().getCode())
                    .codePostal(conjoint.getCodePostal() == null || conjoint.getCodePostal().isEmpty() ? forceCodePostal(conjoint) : conjoint.getCodePostal())
                    .typePiece(conjoint.getTypeDePiece())
                    .numPiece(conjoint.getRegisteredID().getNumber())
                    .autorityPiece(conjoint.getRegisteredID().getAuthority())
                    .lieuDelivrancePiece(conjoint.getRegisteredID().getLocale())
                    .dateDelivrancePiece(conjoint.getRegisteredID().getValidFrom())
                    .dateValiditePiece(conjoint.getRegisteredID().getValidTo())
                    .categorieProfessionnelle(conjoint.getCategorieProfessionnelle().getCode() != null ? conjoint.getCategorieProfessionnelle().getCode():"OOO")
                    .profession(conjoint.getProfession())
                    .memo("ras")
                    .titleCode("01")
                    .montantDesRevenus(conjoint.getMontantDesRevenus() != null ? conjoint.getMontantDesRevenus(): BigDecimal.valueOf(0))
                    .codeTrancheRevenus(getCodeTrancheRevenus(conjoint.getMontantDesRevenus()) != null ? getCodeTrancheRevenus(conjoint.getMontantDesRevenus()):"10")
                    .codeAgence(getCodeAgence(conjoint.getAgence()))
                    .isCompteConjoint(false)
                    .codePaysNaissance(conjoint.getPaysNaissance().getCode())
                    .dptNaissance(conjoint.getDptNaissance())
                    .nomPartenaire(conjoint.getPartenaireDeMariage() != null ? conjoint.getPartenaireDeMariage().getNom():null)
                    .prenomPartenaire(conjoint.getPartenaireDeMariage() != null ? conjoint.getPartenaireDeMariage().getPrenom():null)
                    .dptPartenaire(conjoint.getPartenaireDeMariage() != null ? conjoint.getPartenaireDeMariage().getDepartement():null)
                    .villePartenaire(conjoint.getPartenaireDeMariage() != null ? conjoint.getPartenaireDeMariage().getVille():null)
                    .dateNaissancePartenaire(conjoint.getPartenaireDeMariage() != null ? conjoint.getPartenaireDeMariage().getDateNaissance():null)
                    .adresseCourrierPermanente(conjoint.getAdresseCourrierPermanente())
                    .codeLienApparenteBanque(conjoint.getLienApparenteBanque() != null ?conjoint.getLienApparenteBanque().getCode(): null)
                    .codeNiveauRisqueRelationClient(conjoint.getNiveauRisqueRelationClient() != null ?conjoint.getNiveauRisqueRelationClient().getCode(): null)
                    .codeResidenceDeclaration(conjoint.getResidenceDeclaration() != null ?conjoint.getResidenceDeclaration().getCode(): null)
                    .codeCapaciteJuridique(conjoint.getCapaciteJuridique() != null ?conjoint.getCapaciteJuridique().getCode(): null)
                    .interdictionChequier(true)
                    .codeGestionnaire(conjoint.getGestionnaire() != null ? conjoint.getGestionnaire().getCode(): null)
                    .personnePolitiquementExpos(true)
                    .codeTerritorialite(conjoint.getTerritorialite().getCode())
                    .codeProfil(conjoint.getProfil().getCode())
                    .build();
        }

    }
}
