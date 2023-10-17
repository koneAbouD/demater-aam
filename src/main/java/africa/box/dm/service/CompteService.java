package africa.box.dm.service;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.consumer.banking.BankingBase;
import africa.box.dm.consumer.banking.CompteAmplitude;
import africa.box.dm.consumer.banking.mapper.CompteMapper;
import africa.box.dm.consumer.banking.mapper.ConjointMapper;
import africa.box.dm.controllers.exceptions.GenericNotFoundExceoption;
import africa.box.dm.db.CompteDao;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.NotesDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.utils.ContratFactory;
import createaccountproxy.AccountIdentifierOurBranch;
import createaccountproxy.CreateAccountResponseFlow;
import createcustomerproxy.ErrorResponseFlow_Exception;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.squareup.okhttp.internal.Internal.logger;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CompteService {
    @Autowired
    Utils utils;
    @Autowired
    CompteDao compteDao;
    @Autowired
    NotesDao notesDao;
    @Autowired
    CompteDocumentDao compteDocumentDao;
    @Autowired
    MailService mailService;

    @Autowired
    private BankingBase bankingBase;

// Information sur le client
// Information sur les Coordonnees du client
// Information sur les revenus et l'employeur
// Information Complementaire
    public Compte saveInformationCompte(Compte compte) {

        if (compte.getBusinessKey() == null || compte.getBusinessKey().equals("")) {
            compte.setBusinessKey(utils.generateBusinessKey());
            compte.setStatus(DmStatus.BROUILLON);
        }
        return compteDao.save(compte);
    }

    public Compte saveInformationClient(Compte compte) {
        return compteDao.save(compte);
    }

    public Compte saveCip(Compte compte) {

        return compteDao.save(compte);
    }

    public Compte saveInformationListPeps(Compte compte) {
        return compteDao.save(compte);
    }

    public Compte saveCoordonneesClient(Compte compte) {

        return compteDao.save(compte);
    }

    public Compte saveRevenusEmployeur(Compte compte) {
        return compteDao.save(compte);
    }

    public Compte saveInformationComplementaire(Compte compte) {
        Compte c = compteDao.save(compte);
        return c;
    }

    public Compte saveVerificationKyc(Compte compte) {
        return compteDao.save(compte);
    }

    public Compte updateImformationPepsCompte(Compte compte) {
        compte = compteDao.save(compte);
        return compte;
    }

    public Compte sauvegardeListeDesdocuments(Compte compte) {
        Boolean etranger = compte.getNationalite().getNationalite().equalsIgnoreCase("Ivoirienne") ? false : true;
        List<DocumentType> documentTypes = new ArrayList<>();

        if (compte.getStatus() == DmStatus.BROUILLON) {
            List<CompteDocument> compteDocuments = new ArrayList<>();
            documentTypes = utils.getListDocumentRequirements(compte);

            documentTypes.forEach(doc -> {

                CompteDocument document = ModelMapper.convertDocumentTypeToCompteDocument(doc);
                document.setBusinessKey(compte.getBusinessKey());
                document.setDocumentstatus(DocumentStatus.MANQUANT);
                document.setDocMeta(null);
                compteDocuments.add(document);

            });

            List<Actionnaire> actionnaires = new ArrayList<>();
            try {
                actionnaires = compte.getListAutreActionnaire();
                actionnaires.forEach(actionnaire -> {
                    if (actionnaire.getTypeActionnaire().equals("physique")) {
                        CompteDocument doc = new CompteDocument();
                        doc.setIdentifiant(String.valueOf(UUID.randomUUID()));
                        doc.setBusinessKey(compte.getBusinessKey());
                        doc.setNumberOfCopies(1);
                        doc.setCreatedAt(new Date());
                        doc.setStatut("confirmation");
                        doc.setDocumentstatus(DocumentStatus.MANQUANT);
                        doc.setFacultatif(false);
                        doc.setName(BusinessConstants.DOC_CNI +
                                " - " + actionnaire.getNomActionnaire() +
                                " - " + actionnaire.getPrenomActionnaire());
                        doc.setDocCode(BusinessConstants.DOC_CODE_CNI);
                        doc.setDescription(BusinessConstants.DOC_CNI);
                        compteDocuments.add(doc);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            CompteDocument doc = new CompteDocument();
            doc.setIdentifiant(String.valueOf(UUID.randomUUID()));
            doc.setBusinessKey(compte.getBusinessKey());
            doc.setNumberOfCopies(1);
            doc.setCreatedAt(new Date());
            doc.setStatut("confirmation");
            doc.setDocumentstatus(DocumentStatus.MANQUANT);
            doc.setFacultatif(false);
            doc.setName(BusinessConstants.DOC_CIP);
            doc.setDocCode(BusinessConstants.DOC_CODE_CONFIRMATION);
            doc.setDescription(BusinessConstants.DOC_CODE_CONFIRMATION);
            compteDocuments.add(doc);

            if (compte.getIsConjoint().equals(true)){
                CompteDocument docConjoint = new CompteDocument();
                docConjoint.setIdentifiant(String.valueOf(UUID.randomUUID()));
                docConjoint.setBusinessKey(compte.getBusinessKey());
                docConjoint.setNumberOfCopies(1);
                docConjoint.setCreatedAt(new Date());
                docConjoint.setStatut("confirmation");
                docConjoint.setDocumentstatus(DocumentStatus.MANQUANT);
                docConjoint.setFacultatif(false);
                docConjoint.setName(BusinessConstants.DOC_CIP_CONJOINT);
                docConjoint.setDocCode(BusinessConstants.DOC_CODE_CONFIRMATION_CONJOINT);
                docConjoint.setDescription(BusinessConstants.DOC_CODE_CONFIRMATION_CONJOINT);
                compteDocuments.add(docConjoint);
            }

            compteDocumentDao.saveAll(compteDocuments);
            compte.setStatus(DmStatus.EN_ATTENTE);
            Notes notes = new Notes();
            notes.setNote("Initialisation de la création du compte.");
            notes.setBusinessKey(compte.getBusinessKey());
            notes.setType(NoteTypes.INFORMATION);
            notesDao.save(notes);
        }
        return compteDao.save(compte);
    }

    public Compte saveSyntheseInformation(Compte compte) {
        return compteDao.save(compte);
    }

    public List<Compte> getAll() {
        return compteDao.findAll();
    }

    public List<Compte> getByAgence(String agence) {
        return compteDao.findByAgence(agence);
    }

    public Optional<Compte> getCompte(String b) {
        return compteDao.findById(b);
    }

    public Compte updateCompte(Compte c, Notes notes) {
        if (notes != null && notes.getType() == null) {
            notes.setType(NoteTypes.INFORMATION);
        }
        notesDao.save(notes);
        compteDao.save(c);

//        mailService.sendEmailFormValidateDossierTemplate(c.getBusinessKey(),UserService.getConnectedUser().getFullName(),
//                "html/validateDossier","Fr");
        return c;
    }

    public Notes ajouterNote(Notes note) {
        return notesDao.save(note);
    }

    public List<Notes> getNotesByBusinessKey(String businessKey) {
        return notesDao.findByBusinessKey(businessKey);
    }

    public void deleteNoteByBK(String bussinesskey) {
        notesDao.deleteByBusinessKey(bussinesskey);
    }

    public void deleteNote(Integer id) {
        notesDao.deleteById(id);
    }


    /**
     * Méthode crée les contrats requis pour l'ouverture de compte
     *
     * @param compte
     */
    public void createContratsFor(Compte compte) {
        ContratFactory contratFactory =
                ContratFactory.contratsFor(compte)
                        .withCartonDeSignature()
                        .withConventionBDU()
                        .withFormulaireSmsEtEBanking()
                        .withKYCPersonnePhysiqueBDU()
                        .withDemandeOuvertureDeCompte()
                        .withFormulaireAdhesionServiceMonetiqueBDU()
                        .withFormulaire_Obtention_De_Consentement();

        if (compte.getChequier() != null) {
            contratFactory.withDemandeDeChequier();
        }
        compteDocumentDao.saveAll(contratFactory.build());
    }


    public Optional<Compte> changeSignatureForCOmpteWithBusinessKey(String businessKey, byte[] bytes) {
        return Optional.of(compteDao.findByBusinessKey(businessKey))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(compte -> {
                    try {
                        compte.setSignature(bytes);
                        compteDao.save(compte);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return compte;
                });
    }

    public Optional<String> viewCompteSignatureWithBusinessKey(String businessKey) {

        return Optional.of(compteDao.findByBusinessKey(businessKey))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(compte -> {
                    if (compte.getSignature() != null)
                        return Base64.getEncoder().encodeToString(compte.getSignature());

                    return null;
                });
    }

    public Optional<Compte> getCompteWithCustomerCode(String customerCode) {
        return compteDao.findCompteWithCustomerCode(customerCode);
    }

    public String createCustomer(String businessKey) throws ErrorResponseFlow_Exception, createaccountproxy.ErrorResponseFlow_Exception {
        Optional<Compte> mayBe = this.getCompte(businessKey);

        if (!mayBe.isPresent()) {
            throw new GenericNotFoundExceoption("Compte Introuvable.");
        }

        Compte compte = mayBe.get();
        if (compte.getStatus().equals(DmStatus.SOUMIS)) {

            if (compte.getIsConjoint().equals(true)){
                Conjoint conjoint = compte.getConjoint();
                conjoint.setGestionnaire(compte.getGestionnaire());
                conjoint.setAgence(compte.getAgence());
                CompteAmplitude compteAmplitudeConjoint = ConjointMapper.toCompteAmplitude(conjoint);
                logger.info(compte.getConjoint().toString());
                logger.info(compteAmplitudeConjoint.toString());
                String customerCodeConjoint = "mock";
                customerCodeConjoint = bankingBase.createCustomer(compteAmplitudeConjoint);
                conjoint.setCustomercode(customerCodeConjoint);
                compte.setConjoint(conjoint);
                compte.setCustomerCodeConjoint(customerCodeConjoint);
                logger.info("customerCodeConjoint_________ "+customerCodeConjoint);
            }

            CompteAmplitude compteAmplitude = CompteMapper.toCompteAmplitude(compte);

            logger.info(compteAmplitude.toString());

            String customerCode = "mock";
            customerCode = bankingBase.createCustomer(compteAmplitude);

            if (customerCode != null) {

                CreateAccountResponseFlow response = bankingBase.createAccount(compteAmplitude, customerCode);
                AccountIdentifierOurBranch identifier = response.getCreateAccountResponse().getAccountIdentifier().getIdentifier();
                ReleveIdentiteBancaire rib = new ReleveIdentiteBancaire();
                rib.setCodeBank("CI180");
                rib.setCustomerCode(customerCode);
                rib.setDemandeur(compte.getNomDemandeur() + " " + compte.getPrenomDemandeur());
                rib.setAdresse1(compte.getVille());
                rib.setAdresse2(compte.getAdresse());
                rib.setAccountCode(identifier.getInternalFormatAccountOurBranch().getAccount());
                rib.setIban(identifier.getIbanFormatAccount().getValue());
                rib.setBranch(identifier.getInternalFormatAccountOurBranch().getBranch().getDesignation());
                rib.setBranchCode(identifier.getInternalFormatAccountOurBranch().getBranch().getCode());
                rib.setDevise(identifier.getInternalFormatAccountOurBranch().getCurrency().getAlphaCode());
                rib.setBic("BDUTCIABXXX");
                rib.setCleRib(StringUtils.right(identifier.getIbanFormatAccount().getValue(), 2));

                compte.setCustomercode(customerCode);

                compte.setRib(rib);
                compte.setStatus(DmStatus.APPROUVE);
                compteDao.save(compte);
            }
            return customerCode;
        } else {
            throw new RuntimeException("Ce dossier ne peut pas etre approuve car il n est pas soumis.");
        }

    }
}