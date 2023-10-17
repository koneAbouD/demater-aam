package africa.box.dm.consumer.banking.mapper;

import africa.box.dm.consumer.banking.CompteAmplitude;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.Conjoint;
import com.sun.media.jfxmedia.logging.Logger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static africa.box.dm.config.ValuesParam.*;
import static com.squareup.okhttp.internal.Internal.logger;

public class CompteMapper {
    public static CompteAmplitude toCompteAmplitude(Compte compte) {


        if (compte == null) {
            return null;
        } else {
            return CompteAmplitude.builder()
                    .nom(compte.getNomDemandeur())
                    .prenom(compte.getPrenomDemandeur())
                    .nomPrenom(compte.getFullName())
                    .genre(compte.getGenre().equals("Homme") ? "M" : "F")
                    .dateNaissance(compte.getDateDeNaissance())
                    .villeNaissance(compte.getVilleNaissance())
                    .nomMere(compte.getMotherFullName())
                    .typeClient(compte.getTypeDemandeur())
                    .typeCompte(compte.getTypeCompte())
                    .mobile(compte.getMobile())
                    .adresse(compte.getAdresse())
                    .email(compte.getEmail())
                    .ville(compte.getVille())
                    .codeNationalite(compte.getNationalite().getCode())
                    .codeLangueParle(getLangueParle(compte.getLangue()))
                    .boitePostal(compte.getBoitePostal())
                    .situationMatrimonial(getSituationFamille(compte.getSituationMatrimonial()))
                    .regimeMatrimonial(compte.getRegimeMatrimonial() != null ? getRegimeMatrimonial(compte.getRegimeMatrimonial()) : null)
                    .codePaysResidence(compte.getPaysResidence().getCode())
                    .codePostal(compte.getCodePostal() == null || compte.getCodePostal().isEmpty() ? forceCodePostal(compte.getVille()) : compte.getCodePostal())
                    .typePiece(compte.getTypeDePiece())
                    .numPiece(compte.getRegisteredID().getNumber())
                    .autorityPiece(compte.getRegisteredID().getAuthority())
                    .lieuDelivrancePiece(compte.getRegisteredID().getLocale())
                    .dateDelivrancePiece(compte.getRegisteredID().getValidFrom())
                    .dateValiditePiece(compte.getRegisteredID().getValidTo())
                    .profession(compte.getPoste())
                    .categorieProfessionnelle(compte.getCategorieProfessionnelle().getCode() != null ? compte.getCategorieProfessionnelle().getCode():"OOO")
                    .montantDesRevenus(compte.getMontantDesRevenus() != null ? compte.getMontantDesRevenus(): BigDecimal.valueOf(0))
                    .codeTrancheRevenus(getCodeTrancheRevenus(compte.getMontantDesRevenus()))
                    .memo(compte.getObservationText())
                    .titleCode(compte.getIsConjoint().equals(true) ? "06" : "01")
                    .typeConjoint(compte.getIsConjoint().equals(true) ? "C" : null)//conjoint client
                    .customerCodeConjoint(compte.getCustomerCodeConjoint())
                    .codeAgence(getCodeAgence(compte.getAgence()))
                    .typeLien("MI")
                    .toBePrintedInTheAddress(false)
                    .isCompteConjoint(compte.getIsConjoint())
                    .codePaysNaissance(compte.getPaysNaissance().getCode())
                    .dptNaissance(compte.getDptNaissance())
                    .nomPartenaire(compte.getPartenaireDeMariage() != null ? compte.getPartenaireDeMariage().getNom():null)
                    .prenomPartenaire(compte.getPartenaireDeMariage() != null ? compte.getPartenaireDeMariage().getPrenom():null)
                    .dptPartenaire(compte.getPartenaireDeMariage() != null ? compte.getPartenaireDeMariage().getDepartement():null)
                    .villePartenaire(compte.getPartenaireDeMariage() != null ? compte.getPartenaireDeMariage().getVille():null)
                    .dateNaissancePartenaire(compte.getPartenaireDeMariage() != null ? compte.getPartenaireDeMariage().getDateNaissance():null)
                    .adresseCourrierPermanente(compte.getAdresseCourrierPermanente())
                    .codeLienApparenteBanque(compte.getLienApparenteBanque().getCode())
                    .codeNiveauRisqueRelationClient(compte.getNiveauRisqueRelationClient().getCode())
                    .codeResidenceDeclaration(compte.getResidenceDeclaration().getCode())
                    .codeCapaciteJuridique(compte.getCapaciteJuridique().getCode())
                    .interdictionChequier(true)
                    .codeGestionnaire(compte.getGestionnaire().getCode())
                    .personnePolitiquementExpos(true)
                    .codeProfil(compte.getProfil().getCode())
                    .codeTerritorialite(compte.getTerritorialite().getCode())
                    .build();
        }

    }

}
