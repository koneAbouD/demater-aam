package africa.box.dm.utils;

import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DocumentStatus;
import org.springframework.core.io.Resource;

import java.util.*;

public class ContratFactory {
    private final static String DEFAULT_STATUS_CODE = "CONFIRMATION";
    private Date issuedDate;
    private Compte compte;
    private Set<CompteDocument> contratList;
    private ContratFactory(Compte compte) {
        this.compte = compte;
        issuedDate = new Date();
        this.contratList = new HashSet<>();
    }
    public static ContratFactory contratsFor(Compte compte) {
        return new ContratFactory(compte);
    }
    public ContratFactory withCartonDeSignature() {
        final String name = "Carton de signature";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }
    public ContratFactory withConventionBDU() {
        final String name = "Convention BDU";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }
    public ContratFactory withDemandeOuvertureDeCompte() {
        final String name = "Demande Ouverture de compte";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }

    public ContratFactory withFormulaireAdhesionServiceMonetiqueBDU() {
        final String name = "Formulaire d'adhésion au service Monétique BDU-CI";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(new Date());
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }

    public ContratFactory withFormulaireSmsEtEBanking() {
        final String name = "Formualire SMS et EBanking";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }

    public ContratFactory withKYCPersonnePhysiqueBDU() {
        final String name = "KYC personne physique BDU-CI";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }

    public ContratFactory withDemandeDeChequier() {
        final String name = "Demande de chequier";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }

    public ContratFactory withFormulaire_Obtention_De_Consentement() {
        final String name = "Formulaire d'obtention de consentement";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }
    /*
    public ContratFactory withFormulaireBanktoWallet() {
        final String name = "Formulaire liaison compte banque et orange money";
        final CompteDocument document = new CompteDocument();

        document.setIdentifiant(nextDocumentId());
        document.setBusinessKey(compte.getBusinessKey());
        document.setNumberOfCopies(1);
        document.setCreatedAt(issuedDate);
        document.setStatut("confirmation");
        document.setDocumentstatus(DocumentStatus.MANQUANT);
        document.setFacultatif(false);
        document.setName(name.toUpperCase());
        document.setDocCode(DEFAULT_STATUS_CODE);
        document.setDescription(name);

        contratList.add(document);
        return this;
    }*/
    public List<CompteDocument> getAllDocuments() {
        List<CompteDocument> documents = new ArrayList<>();

//        documents.add(cartonDeSignature());
//        documents.add(KYCPersonnePhysiqueBDU());
//        documents.add(formulaireSmsEtEBanking());
//        documents.add(formulaireAdhesionServiceMonetiqueBDU());
//        documents.add(demandeOuvertureDeCompte());
//        documents.add(conventionBDU());

        return documents;
    }

    public Set<CompteDocument> build(){
        return contratList;
    }

    public Resource generateConventionBDUPDF() throws Exception{
        return ContratPdfBDU.createConventBDUPdf(compte);
    }

    public Resource generateOuvertureDeComptePDF() throws Exception{
        return ContratPdfBDU.createOuvertureDeComptePdf(compte);
    }

    public Resource generateRib() throws Exception{
        return ContratPdfBDU.createRibPdf(compte);
    }

    public Resource generateCartonSignaturePDF() throws Exception{
        return ContratPdfBDU.createCartonSignaturePdf(compte);
    }

    public Resource generateKYCPersonnePhysiquePDF() throws Exception{
        return ContratPdfBDU.createKYCPersonnePhysiqueBDUPdf(compte);
    }

    public Resource generateDemandeDeChequierPDF() throws Exception{
        return ContratPdfBDU.createDemandeChequierPdf(compte);
    }

    public Resource generateFormulaireAdhésionAuServiceMonetiquePDF() throws Exception{
        return ContratPdfBDU.createFormulaireAdhesionServiceMonetiquePdf(compte);
    }

    public Resource generateFormulaireSmsEBankingPDF() throws Exception{
        return ContratPdfBDU.createFormulaireSmsEBankingPdf(compte);
    }

    public Resource generateFormulaireObtentionConsentementPDF() throws Exception{
        return ContratPdfBDU.createFormulaireObtentionConsentementPdf(compte);
    }

    public List<Resource> generateAllPdf() throws Exception{
        List<Resource> resources = new ArrayList<>();

        resources.add(generateConventionBDUPDF());
        resources.add(generateOuvertureDeComptePDF());
        resources.add(generateCartonSignaturePDF());
        resources.add(generateKYCPersonnePhysiquePDF());
        resources.add(generateFormulaireAdhésionAuServiceMonetiquePDF());
        resources.add(generateFormulaireSmsEBankingPDF());
        if (compte.getChequier() !=null) {
            resources.add(generateDemandeDeChequierPDF());
        }
        resources.add(generateFormulaireObtentionConsentementPDF());
        return resources;
    }

    private String nextDocumentId() {
        return UUID.randomUUID().toString();
    }

    public Resource findContratByName(String name) throws Exception{
        if (name.equalsIgnoreCase("Convention BDU")) {
            return generateConventionBDUPDF();
        } else if(name.equalsIgnoreCase("Demande Ouverture de compte")) {
            return generateOuvertureDeComptePDF();
        } else if (name.equalsIgnoreCase("Carton de signature")){
            return generateCartonSignaturePDF();
        } else if (name.equalsIgnoreCase("KYC personne physique BDU-CI")) {
            return generateKYCPersonnePhysiquePDF();
        } else if (name.equalsIgnoreCase("Demande de chequier")) {
            return generateDemandeDeChequierPDF();
        }else if (name.equalsIgnoreCase("Formualire SMS et EBanking")) {
            return generateFormulaireSmsEBankingPDF();
        }else if (name.equalsIgnoreCase("Formulaire d'adhésion au service Monétique BDU-CI")) {
            return generateFormulaireAdhésionAuServiceMonetiquePDF();
        }else if (name.equalsIgnoreCase("Formulaire d'obtention de consentement")) {
            return generateFormulaireObtentionConsentementPDF();
        }
        else {
            throw new  UnSupportedContratException();
        }
    }
}
