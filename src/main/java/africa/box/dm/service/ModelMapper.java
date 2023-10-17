package africa.box.dm.service;

import africa.box.dm.db.entities.*;
import africa.box.dm.dto.DocumentDto;
import org.keycloak.representations.account.UserRepresentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ModelMapper {
    private static org.modelmapper.ModelMapper modelMapper=new org.modelmapper.ModelMapper();

    public static Compte convertExternalCompteToCompte(ExternalCompte e, Boolean fromOnboarding) {
//        Compte compte = new Compte();
//        Compte compte= modelMapper.map(externalCompte, Compte.class);
        Compte compte= new Compte(
                null,
                null,
               null , e.getTypecompte(),
                e.getMotifouverture(),
                e.getTypedemandeur(),
                e.getSoustypeclient(),
                e.getIsmineur(),
                e.getIsclient(),
                e.getIsclientcip(),
                e.getNomsociete(),
                e.getDatecreationsociete(),
                e.getNumeroregistrecommerce(),
                e.getDateregistrecom(),
                e.getLieuregistrecom(),
                e.getSecteuractiveentrep(),
                e.getIsdemarche(),
                e.getIsautresignataire(),
                e.getMatricule(),
                e.getGenre(),
                e.getNomdemandeur(),
                e.getPrenomdemandeur(),
                e.getNationalite(),
                e.getSituationmatrimonial(),
                e.getNomdenaissance(),
                e.getDatedenaissance(),
                e.getLieudenaissance(),
                e.getpersonnePolitique(),
                e.getDetailspersonnepolitique(),
                null,//e.getIscartebancaire(),
                e.getNomsurcarte(),
                e.getDevise(),
                e.getFormejuridique(),
                e.getComptecontribuablelent(),
                null,//e.getListautresignataire(),
                e.getCentreimpotent(),
                e.getAugmentation(),
                e.getDelaisregclientent(),
                e.getConcurentsecteurent(),
                e.getTailleconcurentent(),
                e.getFournisseursent(),
                e.getModecommercialent(),
                e.getMobile(),
                e.getIsmobile2(),
                e.getMobile2(),
                e.getFixe(),
                e.getEmail(),
                e.getAdresse(),
                e.getIsadresse2(),
                e.getSiegesocialent(),
                e.getSiteinternetent(),
                e.getAdresse2(),
                e.getSituationgeographique(),
                e.getBoitepostal(),
                e.getCodepostal(),
                e.getVille(),
                e.getPays(),
                e.getNompersoacontact(),
                e.getPrenompersoacontact(),
                e.getFilationavecclient(),
                e.getContactpersocontact(),
                e.getLieuresidencecontact(),
                e.getPrecisioncontact(),
                e.getSalairemensuel(),
                e.getIsautrerevenu(),
                e.getMontantdesrevenus(),
                e.getMontantdescharges(),
                e.getMontantestimtransact(),
                e.getGrade(),
                e.getPoste(),
                e.getNomemployeur(),
                e.getEmailemployeur(),
                e.getAnciennete()+"",
                e.getEffectifentreprise(),
                e.getChiffresaffaires(),
                e.getCapitalentreprise(),
                e.getGarant(),
                e.getProprietaire().toString(),
                e.getNombreenfants(),
                e.getPersonneacharge(),
                e.getNiveauetude(),
                null,
                e.getCreated_at(),
                e.getCreated_by(),
                e.getUpdated_at(),
                e.getUpdated_by(),
                e.getAgence(),
                fromOnboarding,
                null,
                null, null, null, null, null, null, null, e.getTypeDePiece(), e.getNumeroDePiece(), e.getDateExpirationPiece(),e.getDateCreationPiece(),e.getTelephoneEmployeur(), e.getGeopoint(), null, null, null);

        /*
        compte.setBusinessKey(null);
        compte.setApplicantId(e.getApplicantId());
        compte.setTypeDemandeur(e.getTypedemandeur());
        compte.setSousTypeClient(e.getSoustypeclient());
        compte.setTypeCompte(e.getTypecompte());
        compte.setNumerocompte(null);
        compte.setMotifOuverture( e.getMotifouverture());
        compte.setMineur(e.getIsmineur());
        compte.setPersonnePolitique(e.getpersonnePolitique());
        compte.setDetailsPersonnePolitique(e.getDetailspersonnepolitique());
        compte.setClient(e.getIsclient());
        compte.setNomSociete(e.getNomsociete() );
        compte.setDateCreationSociete(e.getDatecreationsociete());
        compte.setNumeroRegistreCommerce(e.getNumeroregistrecommerce());
        compte.setNouvelleSociete(e.getNouelleSociete());
        compte.setNomDemandeur(e.getNomdemandeur());
        compte.setPrenomDemandeur(e.getPrenomdemandeur());
        compte.setDateNaissanceDemandeur(e.getDatedenaissance());
        compte.setLieuDeNaissanceDemandeur(e.getLieudenaissance());
        compte.setGenreDemandeur(e.getGenre());
        compte.setMobileDemandeur(e.getMobile());
        compte.setEmailDemandeur(e.getEmail());
        compte.setNumIdentifiantFisc(e.getNumIdentifiantFisc());
        compte.setNombreActionnaire(e.getNombreActionnaire());
        compte.setSignataire(e.getIssignataire());
        compte.setGerant(e.getIsgerant());
        compte.setDg(e.getIsdg());
        compte.setPdg(e.getIspdg());
        compte.setDirigeant(e.getIsdirigeant());
//      compte.setNumeroRegActionnaire(e.getNumeroregistrecommerce() numeroRegActionnaire);
//      compte.setNomSocieteActionnaire(String nomSocieteActionnaire);
        compte.setAutreActionnaire(e.getIsautreActionnaire());
        compte.setListAutreActionnaire(e.getListautresignataire());
        compte.setSecteurActiveEntrep(e.getSecteuractiveentrep());
        compte.setMatricule(e.getMatricule());
        compte.setGenre(e.getGenre());
        compte.setNationalite(e.getNationalite());
        compte.setSituationMatrimonial(String situationMatrimonial);
        compte.setNomDeNaissance(String nomDeNaissance);
        compte.setDateDeNaissance(String dateDeNaissance);
        compte.setLieuDeNaissance(String lieuDeNaissance);
        compte.setNomMineur(String nomMineur);
        compte.setPrenomMineur(String prenomMineur);
        compte.setDateDeNaissanceMineur(String dateDeNaissanceMineur);
        compte.setLieuDeNaissanceMineur(String lieuDeNaissanceMineur);
        compte.setNationaliteMineur(String nationaliteMineur);
        compte.setGenreMineur(String genreMineur);
        compte.setClientCIP(Boolean clientCIP);
        compte.setMobile(String mobile);
        compte.setMob(Boolean mob);
        compte.setMobile2(String mobile2);
        compte.setFixe(String fixe);
        compte.setEmail(String email);
        compte.setAdresse(String adresse);
        compte.setAdresse2(String adresse2);
        compte.setSituationGeographique(String situationGeographique);
        compte.setBoitePostal(String boitePostal);
        compte.setCodePostal(String codePostal);
        compte.setVille(String ville);
        compte.setPays(String pays);
        compte.setNomPersoAContact(String nomPersoAContact);
        compte.setPrenomPersoAContact(String prenomPersoAContact);
        compte.setFilationAvecClient(String filationAvecClient);
        compte.setContactPersoContact(String contactPersoContact);
        compte.setLieuResidenceContact(String lieuResidenceContact);
        compte.setPrecisionContact(String precisionContact);
        compte.setSalaireMensuel(String salaireMensuel);
        compte.setAutreRevenu(String autreRevenu);
        compte.setListAutreRevenu(String listAutreRevenu);
        compte.setMontantDesRevenus(String montantDesRevenus);
        compte.setMontantDesCharges(String montantDesCharges);
        compte.setGrade(String grade);
        compte.setPoste(String poste);
        compte.setNomEmployeur(String nomEmployeur);
        compte.setEmailEmployeur(String emailEmployeur);
        compte.setAnciennete(String anciennete);
        compte.setEffectifEntreprise(String effectifEntreprise);
        compte.setChiffresAffaires(String chiffresAffaires);
        compte.setCapitalEntreprise(String capitalEntreprise);
        compte.setGarant(Boolean garant);
        compte.setProprietaire(String proprietaire);
        compte.setNombreEnfants(String nombreEnfants);
        compte.setPersonneACharge(String personneACharge);
        compte.setNiveauEtude(String niveauEtude);
        compte.setStatus(DmStatus status);
        compte.setAgence(String agence);
        compte.setCreatedAt(Date createdAt);
        compte.setCreatedBy(String createdBy);
        compte.setUpdatedAt(Date updatedAt);
        compte.setUpdatedBy(String updatedBy);
        compte.setAdresse2(Boolean adresse2);
        compte.setFromOnboarding(Boolean fromOnboarding);

 */
        return compte;
    }

    public static Compte convertExternalCompteNewToCompte(ExternalCompteNew e, Boolean fromOnboarding) throws ParseException {
        Compte compte = new Compte();
//        Compte compte= modelMapper.map(externalCompte, Compte.class);

        compte.setLieuDeNaissance(e.getLieuDeNaissance());
        compte.setNomDemandeur(e.getNom());
        compte.setPrenomDemandeur(e.getPrenoms());
        compte.setEmailDemandeur(e.getEmail());
        compte.setEmail(e.getEmail());
        compte.setGenre(e.getCivilite());
        compte.setMobileDemandeur(e.getTelephone());
        compte.getPaysResidence().setName(e.getPays());
        compte.setNomEmployeur(e.getNomemployeur());
//        compte.setEmailEmployeur(e.getEmail());
        compte.setSalaireMensuel(e.getSalaireMensuel());
        compte.setTypeCompte(e.getTypeaccount());
        compte.setPoste(e.getProfession());
        compte.setTypeDemandeur("physique");
        compte.setApplicantId(e.getSumsub_id());
        compte.setMobile(e.getMobile());
        compte.setMobile2(e.getMobile2());
        compte.setDateDeNaissance(e.getDateDeNaissance());
        compte.setNumeroDePiece(e.getNumeroDePiece());
        compte.setTypeDePiece(e.getTypeDePiece());
        compte.setTelephoneEmployeur(e.getTelephoneEmployeur());
        compte.setDateCreationPiece(new SimpleDateFormat("dd/MM/yyyy").parse(e.getDateCreationPiece()));
        compte.setDateExpirationPiece(new SimpleDateFormat("dd/MM/yyyy").parse(e.getDateExpirationPiece()));
        compte.setSousTypeClient(e.getSousTypeClient());
        compte.setAdresse(e.getAdresse());
        compte.setAdresse2(e.getAdressepostale());
        compte.setVille(e.getVille());
        compte.setGeopoint(e.getGeopoint());
        compte.setFromOnboarding(true);

//        compte.set(e.getPays());
        /*
        uuid
        id
        surnom
        telephone
        email
        civilite
        nom
        prenoms

        paysdenaissance
        datedenaissance
        lieudenaissance
        numeropiece
        datedevalidite
        autrenumero
        teldomicile
        telbureau
        pays
        adressedelocalisation
        adressepostale
        preuvederesidence
        typeemploi
        profession*
        nomemployeur*
        salairenet*
        autrerevenu
        signature
        otpcode
        otpstatus
        statusdemande
        accountstatus
        typeaccount*
        sumsub_id
         */
/*
        compte.setBusinessKey(null);
        compte.setApplicantId(e.getApplicantId());
        compte.setTypeDemandeur(e.getTypedemandeur());
        compte.setSousTypeClient(e.getSoustypeclient());
        compte.setTypeCompte(e.getTypecompte());
        compte.setNumerocompte(null);
        compte.setMotifOuverture( e.getMotifouverture());
        compte.setMineur(e.getIsmineur());
        compte.setPersonnePolitique(e.getpersonnePolitique());
        compte.setDetailsPersonnePolitique(e.getDetailspersonnepolitique());
        compte.setClient(e.getIsclient());
        compte.setNomSociete(e.getNomsociete() );
        compte.setDateCreationSociete(e.getDatecreationsociete());
        compte.setNumeroRegistreCommerce(e.getNumeroregistrecommerce());
        compte.setNouvelleSociete(e.getNouelleSociete());
        compte.setNomDemandeur(e.getNomdemandeur());
        compte.setPrenomDemandeur(e.getPrenomdemandeur());
        compte.setDateNaissanceDemandeur(e.getDatedenaissance());
        compte.setLieuDeNaissanceDemandeur(e.getLieudenaissance());
        compte.setGenreDemandeur(e.getGenre());
        compte.setMobileDemandeur(e.getMobile());
        compte.setEmailDemandeur(e.getEmail());
        compte.setNumIdentifiantFisc(e.getNumIdentifiantFisc());
        compte.setNombreActionnaire(e.getNombreActionnaire());
        compte.setSignataire(e.getIssignataire());
        compte.setGerant(e.getIsgerant());
        compte.setDg(e.getIsdg());
        compte.setPdg(e.getIspdg());
        compte.setDirigeant(e.getIsdirigeant());
//        compte.setNumeroRegActionnaire(e.getNumeroregistrecommerce() numeroRegActionnaire);
//        compte.setNomSocieteActionnaire(String nomSocieteActionnaire);
        compte.setAutreActionnaire(e.getIsautreActionnaire());
        compte.setListAutreActionnaire(e.getListautresignataire());
        compte.setSecteurActiveEntrep(e.getSecteuractiveentrep());
        compte.setMatricule(e.getMatricule());
        compte.setGenre(e.getGenre());
        compte.setNationalite(e.getNationalite());
        compte.setSituationMatrimonial(String situationMatrimonial);
        compte.setNomDeNaissance(String nomDeNaissance);
        compte.setDateDeNaissance(String dateDeNaissance);
        compte.setLieuDeNaissance(String lieuDeNaissance);
        compte.setNomMineur(String nomMineur);
        compte.setPrenomMineur(String prenomMineur);
        compte.setDateDeNaissanceMineur(String dateDeNaissanceMineur);
        compte.setLieuDeNaissanceMineur(String lieuDeNaissanceMineur);
        compte.setNationaliteMineur(String nationaliteMineur);
        compte.setGenreMineur(String genreMineur);
        compte.setClientCIP(Boolean clientCIP);
        compte.setMobile(String mobile);
        compte.setMob(Boolean mob);
        compte.setMobile2(String mobile2);
        compte.setFixe(String fixe);
        compte.setEmail(String email);
        compte.setAdresse(String adresse);
        compte.setAdresse2(String adresse2);
        compte.setSituationGeographique(String situationGeographique);
        compte.setBoitePostal(String boitePostal);
        compte.setCodePostal(String codePostal);
        compte.setVille(String ville);
        compte.setPays(String pays);
        compte.setNomPersoAContact(String nomPersoAContact);
        compte.setPrenomPersoAContact(String prenomPersoAContact);
        compte.setFilationAvecClient(String filationAvecClient);
        compte.setContactPersoContact(String contactPersoContact);
        compte.setLieuResidenceContact(String lieuResidenceContact);
        compte.setPrecisionContact(String precisionContact);
        compte.setSalaireMensuel(String salaireMensuel);
        compte.setAutreRevenu(String autreRevenu);
        compte.setListAutreRevenu(String listAutreRevenu);
        compte.setMontantDesRevenus(String montantDesRevenus);
        compte.setMontantDesCharges(String montantDesCharges);
        compte.setGrade(String grade);
        compte.setPoste(String poste);
        compte.setNomEmployeur(String nomEmployeur);
        compte.setEmailEmployeur(String emailEmployeur);
        compte.setAnciennete(String anciennete);
        compte.setEffectifEntreprise(String effectifEntreprise);
        compte.setChiffresAffaires(String chiffresAffaires);
        compte.setCapitalEntreprise(String capitalEntreprise);
        compte.setGarant(Boolean garant);
        compte.setProprietaire(String proprietaire);
        compte.setNombreEnfants(String nombreEnfants);
        compte.setPersonneACharge(String personneACharge);
        compte.setNiveauEtude(String niveauEtude);
        compte.setStatus(DmStatus status);
        compte.setAgence(String agence);
        compte.setCreatedAt(Date createdAt);
        compte.setCreatedBy(String createdBy);
        compte.setUpdatedAt(Date updatedAt);
        compte.setUpdatedBy(String updatedBy);
        compte.setAdresse2(Boolean adresse2);
        compte.setFromOnboarding(Boolean fromOnboarding);

 */
        return compte;
    }

    public static CompteDocument convertExternalCompteDocumentToCompteDocument(ExternalCompteDocument doc) {
        CompteDocument compteDocument= modelMapper.map(doc, CompteDocument.class);
        return compteDocument;
    }

    public static CompteDocument convertDocumentTypeToCompteDocument(DocumentType doc) {
        CompteDocument compteDocument= modelMapper.map(doc, CompteDocument.class);
        return compteDocument;
    }
//    public static Document convertDocumentTypeToDocument(DocumentType doc) {
//        Document document= modelMapper.map(doc, Document.class);
//        return document;
//    }
//    public static DocumentDto convertDocumentToDocumentDto(Document doc) {
//        DocumentDto Documentdto= modelMapper.map(doc,DocumentDto.class);
//        return Documentdto;
//    }
    public static DocumentDto convertCompteDocumentToDocumentDto(CompteDocument doc) {
        DocumentDto Documentdto= modelMapper.map(doc,DocumentDto.class);
        return Documentdto;
    }
    public static CompteDocument convertDocumentDtoToCompteDocument(DocumentDto doc) {
        CompteDocument compteDocument= modelMapper.map(doc,CompteDocument.class);
        return compteDocument;
    }

//    public static List<DocumentDto> convertListDossierDocumentToDossierDocumentDto(List<Document> docs) {
//        List<DocumentDto> docdts=new ArrayList<>();
//        docs.forEach(x->{
//            DocumentDto dto  = convertDocumentToDocumentDto(x);
//            docdts.add(dto);
//        });
//        return docdts;
//    }

//    public static Document convertDossierDocumentDtoToDossierDocument(DocumentDto document) {
//        Document dossierDocument= modelMapper.map(document,Document.class);
//        return dossierDocument;
//    }

    public static List<DecideurTemplate> convertListUserRepresentationToListDecideurTemplate (
            List <UserRepresentation> userRepresentationList, String role, int priorite, String status, String typeLevel, String agence){
        List<DecideurTemplate> decideurTemplateList = new ArrayList<>();

        for (UserRepresentation r:userRepresentationList) {
            DecideurTemplate decideurTemplate = new DecideurTemplate();
            decideurTemplate.setNom(r.getLastName());
            decideurTemplate.setPrenom(r.getFirstName());
            decideurTemplate.setEmail(r.getEmail());
            decideurTemplate.setRole(role);
            decideurTemplate.setPriorite(priorite);
            decideurTemplate.setStatus(status);
            decideurTemplate.setTypeLevel(typeLevel);
            decideurTemplate.setAgence(agence);
            decideurTemplateList.add(decideurTemplate);
        }

        return decideurTemplateList;
    }
}
