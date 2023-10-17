//package africa.box.dm.db.entities;
//
//import africa.box.dm.config.MyAppConfig;
//import africa.box.dm.service.CompteService;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.databind.node.JsonNodeType;
//import org.hibernate.annotations.TypeDef;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Entity
//@Table(name = "Compte")
//@TypeDef(name = "jsonb", typeClass = JsonNodeType.class)
//public class Compte___ implements Serializable {
//    /*
//    informationOuvertureCompte = {
//    loadInformationDossier: false,
//    bussinessKey: null,
//    createdAt: null,
//
//    // Information sur le client
//    typeDemandeur: '',
//    sousTypeClient: '',
//    typeCompte: '',
//    motifOuverture: '',
//    nomSociete: '',
//    dateCreationSociete: null,
//    numeroRegistreCommerce: '',  //RCCM
//    dateRegistreCom: null,
//    lieuRegistreCom: '',
//    secteurActiveEntrep: '',
//    isDemarche: false,
//    isAutreSignataire: false,
//    listAutreSignataire: [
//        {
//            nomDemandeur: '',
//            prenomDemandeur: '',
//        }
//    ],
//    matricule: '',
//    genre: 'Homme',
//    nomDemandeur: '',
//    prenomDemandeur: '',
//    nationalite: 'Ivoirienne',
//    situationMatrimonial: 'Marié(e)',
//    nomDeNaissance: '',
//    dateDeNaissance: '',
//    lieuDeNaissance: '',
//    client: false,
//    isClientCIP: false,
//    isMineur: false,
//    isPersoPolitique: false,
//    detailsPersoPolitiq: '',
//    carteBancaire: false,
//    nomSurCarte: '',
//    devise: '',
//    numerocompte: '',
//    formeJuridique: '',
//    compteComtribualEnt:'',
//
//    centreImpotEnt:'',
//    augmentation:false,
//    equipeDirectionEnt:'',
//    experienProfMembr:'',
//    evolutionEnt:'',
//    comptesEnt:'',
//    detteEnt:'',
//    produitsEnt:'',
//    grosClientEnt:'',
//    delaisRegClientEnt:'',
//    concurentSecteurEnt:'',
//    tailleConcurentEnt:'',
//    donneeFinaceEnt:'',
//    donneeActiviteEnt:'',
//    fournisseursEnt:'',
//    modeCommercialEnt:'',
//
//
//    // Information sur les Coordonnees du client
//
//    mobile: '',
//    isMobile2: false,
//    mobile2: '',
//    fixe: '',
//    email: '',
//    adresse: '',
//    isAdresse2: false,
//    siegeSocialEnt:'',
//    siteInternetEnt:'',
//    adresse2: '',
//    situationGeographique: '',
//    boitePostal: '',
//    codePostal: '',
//    ville: '',
//    pays: 'COTE D\'IVOIRE',
//    nomPersoAContact: '',
//    prenomPersoAContact: '',
//    filationAvecClient: '',
//    contactPersoContact: '',
//    lieuResidenceContact: '',
//    precisionContact: '',
//
//    // Information sur les revenus et l'employeur
//
//    salaireMensuel: '',
//    autreRevenu: false,
//    listAutreRevenu: [],
//    montantDesRevenus: '',
//    montantDesCharges: '',
//    montantEstimTransact: '',
//    grade: "",
//    poste: "",
//    nomEmployeur: '',
//    emailEmployeur: "",
//    anciennete: '',
//    effectifEntreprise: '',
//    chiffresAffaires: '',
//    capitalEntreprise: '',
//
//    // Information Complementaire
//
//    garant: false,
//    proprietaire: '',
//    nombreEnfants: '',
//    personneACharge: '',
//    niveauEtude: '',
//}
//
//// Information sur le compte
//// Information sur le client
//// Information sur les Coordonnees du client
//// Information sur les revenus et l'employeur
//// Information Complementaire
//     */
//
//    @Id
//    private String businessKey;
//    // Information sur le compte
//    private String typeCompte;
//    private String motifOuverture;
//    private String typeDemandeur;
//    private String sousTypeClient;
//    private Boolean isMineur;
//    private Boolean isClient;
//    private Boolean isClientCIP;
//
//    // Information sur le client
//    private String nomSociete;
//    private Date dateCreationSociete;
//    private String numeroRegistreCommerce;
//    private Date dateRegistreCom;
//    private String lieuRegistreCom;
//    private String secteurActiveEntrep;
//    private Boolean isDemarche;
//    private Boolean isAutreSignataire;
//    private String matricule;
//    private String genre;
//    private String nomDemandeur;
//    private String prenomDemandeur;
//    private String nationalite;
//    private String situationMatrimonial;
//    private String nomDeNaissance;
//    private Date dateDeNaissance;
//    private String lieuDeNaissance;
//    private Boolean personnePolitique;
//    private String detailsPersonnePolitique;
//    private String isCarteBancaire;
//    private String nomSurCarte;
//    private String devise;
//    private String formeJuridique;
//    private String compteContribuablelEnt;
//    @Column(columnDefinition="TEXT")
//    private String listAutreSignataire;
//
//    private String centreImpotEnt;
//    private String augmentation;
//    //    private String equipeDirectionEnt;
////    private String experienceProfMembre;
////    private String evolutionEnt;
////    private String comptesEnt;
////    private String detteEnt;
////    private String produitsEnt;
////    private String grosClientEnt;
//    private String delaisRegClientEnt;
//    private String concurentSecteurEnt;
//    private String tailleConcurentEnt;
//    //    private String donneeFinaceEnt;
////    private String donneeActiviteEnt;
//    private String fournisseursEnt;
//    private String modeCommercialEnt;
//
//    // Information sur les Coordonnees du client
//    private String mobile;
//    private Boolean isMobile2;
//    private String mobile2;
//    private String fixe;
//    private String email;
//    private String adresse;
//    private Boolean isAdresse2;
//    private String siegeSocialEnt;
//    private String siteInternetEnt;
//    private String adresse2;
//    private String situationGeographique;
//    private String boitePostal;
//    private String codePostal;
//    private String ville;
//    private String pays;
//    private String nomPersoAContact;
//    private String prenomPersoAContact;
//    private String filationAvecClient;
//    private String contactPersoContact;
//    private String lieuResidenceContact;
//    private String precisionContact;
//
//    // Information sur les revenus et l'employeur
//    private Double salaireMensuel;
//    private boolean isAutreRevenu;
//    // private String listAutreRevenu;
//    private Double montantDesRevenus;
//    private Double montantDesCharges;
//    private Double montantEstimTransact;
//    private String grade;
//    private String poste;
//    private String nomEmployeur;
//    private String emailEmployeur;
//    private String anciennete;
//    private String effectifEntreprise;
//    private Double chiffresAffaires;
//    private Double capitalEntreprise;
//
//    // Information Complementaire
//    private String garant;
//    private String proprietaire;
//    private Integer nombreEnfants;
//    private Integer personneACharge;
//    private String niveauEtude;
//    private DmStatus status;
//    private Boolean fromOnboarding;
//
//    @Column(name = "created_at")
//    private Date createdAt;
//    @Column(name = "created_by")
//    private String createdBy;
//    @Column(name = "updated_at")
//    private Date updatedAt;
//    @Column(name = "updated_by")
//    private String updatedBy;
//
//    private String agence;
//
//
//    public String getBusinessKey() {
//        return businessKey;
//    }
//
//    public void setBusinessKey(String businessKey) {
//        this.businessKey = businessKey;
//    }
//
//    public String getTypeCompte() {
//        return typeCompte;
//    }
//
//    public void setTypeCompte(String typeCompte) {
//        this.typeCompte = typeCompte;
//    }
//
//    public String getMotifOuverture() {
//        return motifOuverture;
//    }
//
//    public void setMotifOuverture(String motifOuverture) {
//        this.motifOuverture = motifOuverture;
//    }
//
//    public String getTypeDemandeur() {
//        return typeDemandeur;
//    }
//
//    public void setTypeDemandeur(String typeDemandeur) {
//        this.typeDemandeur = typeDemandeur;
//    }
//
//    public String getSousTypeClient() {
//        return sousTypeClient;
//    }
//
//    public void setSousTypeClient(String sousTypeClient) {
//        this.sousTypeClient = sousTypeClient;
//    }
//
//    public Boolean getMineur() {
//        return isMineur;
//    }
//
//    public void setMineur(Boolean mineur) {
//        isMineur = mineur;
//    }
//
//    public Boolean getClient() {
//        return isClient;
//    }
//
//    public void setClient(Boolean client) {
//        isClient = client;
//    }
//
//    public Boolean getClientCIP() {
//        return isClientCIP;
//    }
//
//    public void setClientCIP(Boolean clientCIP) {
//        isClientCIP = clientCIP;
//    }
//
//    public String getNomSociete() {
//        return nomSociete;
//    }
//
//    public void setNomSociete(String nomSociete) {
//        this.nomSociete = nomSociete;
//    }
//
//    public Date getDateCreationSociete() {
//        return dateCreationSociete;
//    }
//
//    public void setDateCreationSociete(Date dateCreationSociete) {
//        this.dateCreationSociete = dateCreationSociete;
//    }
//
//    public String getNumeroRegistreCommerce() {
//        return numeroRegistreCommerce;
//    }
//
//    public void setNumeroRegistreCommerce(String numeroRegistreCommerce) {
//        this.numeroRegistreCommerce = numeroRegistreCommerce;
//    }
//
//    public Date getDateRegistreCom() {
//        return dateRegistreCom;
//    }
//
//    public void setDateRegistreCom(Date dateRegistreCom) {
//        this.dateRegistreCom = dateRegistreCom;
//    }
//
//    public String getLieuRegistreCom() {
//        return lieuRegistreCom;
//    }
//
//    public void setLieuRegistreCom(String lieuRegistreCom) {
//        this.lieuRegistreCom = lieuRegistreCom;
//    }
//
//    public String getSecteurActiveEntrep() {
//        return secteurActiveEntrep;
//    }
//
//    public void setSecteurActiveEntrep(String secteurActiveEntrep) {
//        this.secteurActiveEntrep = secteurActiveEntrep;
//    }
//
//    public Boolean getDemarche() {
//        return isDemarche;
//    }
//
//    public void setDemarche(Boolean demarche) {
//        isDemarche = demarche;
//    }
//
//    public Boolean getAutreSignataire() {
//        return isAutreSignataire;
//    }
//
//    public void setAutreSignataire(Boolean autreSignataire) {
//        isAutreSignataire = autreSignataire;
//    }
//
//    public String getMatricule() {
//        return matricule;
//    }
//
//    public void setMatricule(String matricule) {
//        this.matricule = matricule;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getNomDemandeur() {
//        return nomDemandeur;
//    }
//
//    public void setNomDemandeur(String nomDemandeur) {
//        this.nomDemandeur = nomDemandeur;
//    }
//
//    public String getPrenomDemandeur() {
//        return prenomDemandeur;
//    }
//
//    public void setPrenomDemandeur(String prenomDemandeur) {
//        this.prenomDemandeur = prenomDemandeur;
//    }
//
//    public String getNationalite() {
//        return nationalite;
//    }
//
//    public void setNationalite(String nationalite) {
//        this.nationalite = nationalite;
//    }
//
//    public String getSituationMatrimonial() {
//        return situationMatrimonial;
//    }
//
//    public void setSituationMatrimonial(String situationMatrimonial) {
//        this.situationMatrimonial = situationMatrimonial;
//    }
//
//    public String getNomDeNaissance() {
//        return nomDeNaissance;
//    }
//
//    public void setNomDeNaissance(String nomDeNaissance) {
//        this.nomDeNaissance = nomDeNaissance;
//    }
//
//    public Date getDateDeNaissance() {
//        return dateDeNaissance;
//    }
//
//    public void setDateDeNaissance(Date dateDeNaissance) {
//        this.dateDeNaissance = dateDeNaissance;
//    }
//
//    public String getLieuDeNaissance() {
//        return lieuDeNaissance;
//    }
//
//    public void setLieuDeNaissance(String lieuDeNaissance) {
//        this.lieuDeNaissance = lieuDeNaissance;
//    }
//
//    public Boolean getPersonnePolitique() {
//        return personnePolitique;
//    }
//
//    public void setPersonnePolitique(Boolean personnePolitique) {
//        personnePolitique = personnePolitique;
//    }
//
//    public String getDetailsPersonnePolitique() {
//        return detailsPersonnePolitique;
//    }
//
//    public void setDetailsPersonnePolitique(String detailsPersonnePolitique) {
//        this.detailsPersonnePolitique = detailsPersonnePolitique;
//    }
//
//    public String getIsCarteBancaire() {
//        return isCarteBancaire;
//    }
//
//    public void setIsCarteBancaire(String isCarteBancaire) {
//        this.isCarteBancaire = isCarteBancaire;
//    }
//
//    public String getNomSurCarte() {
//        return nomSurCarte;
//    }
//
//    public void setNomSurCarte(String nomSurCarte) {
//        this.nomSurCarte = nomSurCarte;
//    }
//
//    public String getDevise() {
//        return devise;
//    }
//
//    public void setDevise(String devise) {
//        this.devise = devise;
//    }
//
//    public String getFormeJuridique() {
//        return formeJuridique;
//    }
//
//    public void setFormeJuridique(String formeJuridique) {
//        this.formeJuridique = formeJuridique;
//    }
//
//    public String getCompteContribuablelEnt() {
//        return compteContribuablelEnt;
//    }
//
//    public void setCompteContribuablelEnt(String compteContribuablelEnt) {
//        this.compteContribuablelEnt = compteContribuablelEnt;
//    }
//
//    public String getListAutreSignataire() {
//        return listAutreSignataire;
//    }
//
//    public void setListAutreSignataire(String listAutreSignataire) {
//        this.listAutreSignataire = listAutreSignataire;
//    }
//
//    public String getCentreImpotEnt() {
//        return centreImpotEnt;
//    }
//
//    public void setCentreImpotEnt(String centreImpotEnt) {
//        this.centreImpotEnt = centreImpotEnt;
//    }
//
//    public String getAugmentation() {
//        return augmentation;
//    }
//
//    public void setAugmentation(String augmentation) {
//        this.augmentation = augmentation;
//    }
//
//    public String getDelaisRegClientEnt() {
//        return delaisRegClientEnt;
//    }
//
//    public void setDelaisRegClientEnt(String delaisRegClientEnt) {
//        this.delaisRegClientEnt = delaisRegClientEnt;
//    }
//
//    public String getConcurentSecteurEnt() {
//        return concurentSecteurEnt;
//    }
//
//    public void setConcurentSecteurEnt(String concurentSecteurEnt) {
//        this.concurentSecteurEnt = concurentSecteurEnt;
//    }
//
//    public String getTailleConcurentEnt() {
//        return tailleConcurentEnt;
//    }
//
//    public void setTailleConcurentEnt(String tailleConcurentEnt) {
//        this.tailleConcurentEnt = tailleConcurentEnt;
//    }
//
//    public String getFournisseursEnt() {
//        return fournisseursEnt;
//    }
//
//    public void setFournisseursEnt(String fournisseursEnt) {
//        this.fournisseursEnt = fournisseursEnt;
//    }
//
//    public String getModeCommercialEnt() {
//        return modeCommercialEnt;
//    }
//
//    public void setModeCommercialEnt(String modeCommercialEnt) {
//        this.modeCommercialEnt = modeCommercialEnt;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public Boolean getMobile2() {
//        return isMobile2;
//    }
//
//    public void setMobile2(String mobile2) {
//        this.mobile2 = mobile2;
//    }
//
//    public String getFixe() {
//        return fixe;
//    }
//
//    public void setFixe(String fixe) {
//        this.fixe = fixe;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    public Boolean getAdresse2() {
//        return isAdresse2;
//    }
//
//    public void setAdresse2(String adresse2) {
//        this.adresse2 = adresse2;
//    }
//
//    public String getSituationGeographique() {
//        return situationGeographique;
//    }
//
//    public void setSituationGeographique(String situationGeographique) {
//        this.situationGeographique = situationGeographique;
//    }
//
//    public String getBoitePostal() {
//        return boitePostal;
//    }
//
//    public void setBoitePostal(String boitePostal) {
//        this.boitePostal = boitePostal;
//    }
//
//    public String getCodePostal() {
//        return codePostal;
//    }
//
//    public void setCodePostal(String codePostal) {
//        this.codePostal = codePostal;
//    }
//
//    public String getVille() {
//        return ville;
//    }
//
//    public void setVille(String ville) {
//        this.ville = ville;
//    }
//
//    public String getPays() {
//        return pays;
//    }
//
//    public void setPays(String pays) {
//        this.pays = pays;
//    }
//
//    public String getNomPersoAContact() {
//        return nomPersoAContact;
//    }
//
//    public void setNomPersoAContact(String nomPersoAContact) {
//        this.nomPersoAContact = nomPersoAContact;
//    }
//
//    public String getPrenomPersoAContact() {
//        return prenomPersoAContact;
//    }
//
//    public void setPrenomPersoAContact(String prenomPersoAContact) {
//        this.prenomPersoAContact = prenomPersoAContact;
//    }
//
//    public String getFilationAvecClient() {
//        return filationAvecClient;
//    }
//
//    public void setFilationAvecClient(String filationAvecClient) {
//        this.filationAvecClient = filationAvecClient;
//    }
//
//    public String getContactPersoContact() {
//        return contactPersoContact;
//    }
//
//    public void setContactPersoContact(String contactPersoContact) {
//        this.contactPersoContact = contactPersoContact;
//    }
//
//    public String getLieuResidenceContact() {
//        return lieuResidenceContact;
//    }
//
//    public void setLieuResidenceContact(String lieuResidenceContact) {
//        this.lieuResidenceContact = lieuResidenceContact;
//    }
//
//    public String getPrecisionContact() {
//        return precisionContact;
//    }
//
//    public void setPrecisionContact(String precisionContact) {
//        this.precisionContact = precisionContact;
//    }
//
//    public Double getSalaireMensuel() {
//        return salaireMensuel;
//    }
//
//    public void setSalaireMensuel(Double salaireMensuel) {
//        this.salaireMensuel = salaireMensuel;
//    }
//
//    public boolean isAutreRevenu() {
//        return isAutreRevenu;
//    }
//
//    public void setAutreRevenu(boolean autreRevenu) {
//        isAutreRevenu = autreRevenu;
//    }
//
//    public Double getMontantDesRevenus() {
//        return montantDesRevenus;
//    }
//
//    public void setMontantDesRevenus(Double montantDesRevenus) {
//        this.montantDesRevenus = montantDesRevenus;
//    }
//
//    public Double getMontantDesCharges() {
//        return montantDesCharges;
//    }
//
//    public void setMontantDesCharges(Double montantDesCharges) {
//        this.montantDesCharges = montantDesCharges;
//    }
//
//    public Double getMontantEstimTransact() {
//        return montantEstimTransact;
//    }
//
//    public void setMontantEstimTransact(Double montantEstimTransact) {
//        this.montantEstimTransact = montantEstimTransact;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getPoste() {
//        return poste;
//    }
//
//    public void setPoste(String poste) {
//        this.poste = poste;
//    }
//
//    public String getNomEmployeur() {
//        return nomEmployeur;
//    }
//
//    public void setNomEmployeur(String nomEmployeur) {
//        this.nomEmployeur = nomEmployeur;
//    }
//
//    public String getEmailEmployeur() {
//        return emailEmployeur;
//    }
//
//    public void setEmailEmployeur(String emailEmployeur) {
//        this.emailEmployeur = emailEmployeur;
//    }
//
//    public String getAnciennete() {
//        return anciennete;
//    }
//
//    public void setAnciennete(String anciennete) {
//        this.anciennete = anciennete;
//    }
//
//    public String getEffectifEntreprise() {
//        return effectifEntreprise;
//    }
//
//    public void setEffectifEntreprise(String effectifEntreprise) {
//        this.effectifEntreprise = effectifEntreprise;
//    }
//
//    public Double getChiffresAffaires() {
//        return chiffresAffaires;
//    }
//
//    public void setChiffresAffaires(Double chiffresAffaires) {
//        this.chiffresAffaires = chiffresAffaires;
//    }
//
//    public Double getCapitalEntreprise() {
//        return capitalEntreprise;
//    }
//
//    public void setCapitalEntreprise(Double capitalEntreprise) {
//        this.capitalEntreprise = capitalEntreprise;
//    }
//
//    public String getGarant() {
//        return garant;
//    }
//
//    public void setGarant(String garant) {
//        this.garant = garant;
//    }
//
//    public String getProprietaire() {
//        return proprietaire;
//    }
//
//    public void setProprietaire(String proprietaire) {
//        this.proprietaire = proprietaire;
//    }
//
//    public Integer getNombreEnfants() {
//        return nombreEnfants;
//    }
//
//    public void setNombreEnfants(Integer nombreEnfants) {
//        this.nombreEnfants = nombreEnfants;
//    }
//
//    public Integer getPersonneACharge() {
//        return personneACharge;
//    }
//
//    public void setPersonneACharge(Integer personneACharge) {
//        this.personneACharge = personneACharge;
//    }
//
//    public String getNiveauEtude() {
//        return niveauEtude;
//    }
//
//    public void setNiveauEtude(String niveauEtude) {
//        this.niveauEtude = niveauEtude;
//    }
//
//    public DmStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(DmStatus status) {
//        this.status = status;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public String getAgence() {
//        return agence;
//    }
//
//    public void setAgence(String agence) {
//        this.agence = agence;
//    }
//
//    public void setAdresse2(Boolean adresse2) {
//        isAdresse2 = adresse2;
//    }
//
//    public String getSiegeSocialEnt() {
//        return siegeSocialEnt;
//    }
//
//    public void setSiegeSocialEnt(String siegeSocialEnt) {
//        this.siegeSocialEnt = siegeSocialEnt;
//    }
//
//    public String getSiteInternetEnt() {
//        return siteInternetEnt;
//    }
//
//    public void setSiteInternetEnt(String siteInternetEnt) {
//        this.siteInternetEnt = siteInternetEnt;
//    }
//
//    public void setMobile2(Boolean mobile2) {
//        isMobile2 = mobile2;
//    }
//
//    @PrePersist()
//    public void AddCustomInformationUser(){
//        this.agence=MyAppConfig.agence;
//        this.createdBy=MyAppConfig.mailSys;
//        this.updatedBy=MyAppConfig.mailSys;
//        this.updatedAt=new Date();
//        this.createdAt=new Date();
//    }
//
//    @PreUpdate()
//    public void UpdateCustomInformationUser(){
//        CompteService service = new CompteService();
////        if(businessKey!=null){
////            Optional<Compte> optionalCompte =  service.getCompte(this.businessKey);
////            if(optionalCompte.isPresent()) {
////                Compte c = new Compte();
////                this.agence=c.getAgence();
////                this.createdBy=c.getCreatedBy();
////                this.createdAt=c.getCreatedAt();
////            }
////        }
//
////      User user=  services.getUser();
//        this.updatedBy= MyAppConfig.mailSys;
//        this.updatedAt=new Date();
//    }
//
//    public Boolean getFromOnboarding() {
//        return fromOnboarding;
//    }
//
//    public void setFromOnboarding(Boolean fromOnboarding) {
//        this.fromOnboarding = fromOnboarding;
//    }
//
//    public Compte___() {
//    }
//
//    public Compte___(String businessKey, String typeCompte, String motifOuverture, String typeDemandeur,
//                  String sousTypeClient, Boolean isMineur, Boolean isClient, Boolean isClientCIP,
//                  String nomSociete, Date dateCreationSociete, String numeroRegistreCommerce,
//                  Date dateRegistreCom, String lieuRegistreCom, String secteurActiveEntrep,
//                  Boolean isDemarche, Boolean isAutreSignataire, String matricule, String genre,
//                  String nomDemandeur, String prenomDemandeur, String nationalite,
//                  String situationMatrimonial, String nomDeNaissance, Date dateDeNaissance,
//                  String lieuDeNaissance, Boolean personnePolitique, String detailsPersonnePolitique,
//                  String isCarteBancaire, String nomSurCarte, String devise, String formeJuridique,
//                  String compteContribuablelEnt, String listAutreSignataire, String centreImpotEnt,
//                  String augmentation, String delaisRegClientEnt, String concurentSecteurEnt,
//                  String tailleConcurentEnt, String fournisseursEnt, String modeCommercialEnt,
//                  String mobile, Boolean isMobile2, String mobile2, String fixe, String email,
//                  String adresse, Boolean isAdresse2, String siegeSocialEnt, String siteInternetEnt,
//                  String adresse2, String situationGeographique, String boitePostal, String codePostal,
//                  String ville, String pays, String nomPersoAContact, String prenomPersoAContact,
//                  String filationAvecClient, String contactPersoContact, String lieuResidenceContact,
//                  String precisionContact, Double salaireMensuel, boolean isAutreRevenu,
//                  Double montantDesRevenus, Double montantDesCharges, Double montantEstimTransact,
//                  String grade, String poste, String nomEmployeur, String emailEmployeur,
//                  String anciennete, String effectifEntreprise, Double chiffresAffaires,
//                  Double capitalEntreprise, String garant, String proprietaire, Integer nombreEnfants,
//                  Integer personneACharge, String niveauEtude, DmStatus status, Date createdAt,
//                  String createdBy, Date updatedAt, String updatedBy, String agence, Boolean fromOnboarding) {
//        this.businessKey = businessKey;
//        this.typeCompte = typeCompte;
//        this.motifOuverture = motifOuverture;
//        this.typeDemandeur = typeDemandeur;
//        this.sousTypeClient = sousTypeClient;
//        this.isMineur = isMineur;
//        this.isClient = isClient;
//        this.isClientCIP = isClientCIP;
//        this.nomSociete = nomSociete;
//        this.dateCreationSociete = dateCreationSociete;
//        this.numeroRegistreCommerce = numeroRegistreCommerce;
//        this.dateRegistreCom = dateRegistreCom;
//        this.lieuRegistreCom = lieuRegistreCom;
//        this.secteurActiveEntrep = secteurActiveEntrep;
//        this.isDemarche = isDemarche;
//        this.isAutreSignataire = isAutreSignataire;
//        this.matricule = matricule;
//        this.genre = genre;
//        this.nomDemandeur = nomDemandeur;
//        this.prenomDemandeur = prenomDemandeur;
//        this.nationalite = nationalite;
//        this.situationMatrimonial = situationMatrimonial;
//        this.nomDeNaissance = nomDeNaissance;
//        this.dateDeNaissance = dateDeNaissance;
//        this.lieuDeNaissance = lieuDeNaissance;
//        this.personnePolitique = personnePolitique;
//        this.detailsPersonnePolitique = detailsPersonnePolitique;
//        this.isCarteBancaire = isCarteBancaire;
//        this.nomSurCarte = nomSurCarte;
//        this.devise = devise;
//        this.formeJuridique = formeJuridique;
//        this.compteContribuablelEnt = compteContribuablelEnt;
//        this.listAutreSignataire = listAutreSignataire;
//        this.centreImpotEnt = centreImpotEnt;
//        this.augmentation = augmentation;
//        this.delaisRegClientEnt = delaisRegClientEnt;
//        this.concurentSecteurEnt = concurentSecteurEnt;
//        this.tailleConcurentEnt = tailleConcurentEnt;
//        this.fournisseursEnt = fournisseursEnt;
//        this.modeCommercialEnt = modeCommercialEnt;
//        this.mobile = mobile;
//        this.isMobile2 = isMobile2;
//        this.mobile2 = mobile2;
//        this.fixe = fixe;
//        this.email = email;
//        this.adresse = adresse;
//        this.isAdresse2 = isAdresse2;
//        this.siegeSocialEnt = siegeSocialEnt;
//        this.siteInternetEnt = siteInternetEnt;
//        this.adresse2 = adresse2;
//        this.situationGeographique = situationGeographique;
//        this.boitePostal = boitePostal;
//        this.codePostal = codePostal;
//        this.ville = ville;
//        this.pays = pays;
//        this.nomPersoAContact = nomPersoAContact;
//        this.prenomPersoAContact = prenomPersoAContact;
//        this.filationAvecClient = filationAvecClient;
//        this.contactPersoContact = contactPersoContact;
//        this.lieuResidenceContact = lieuResidenceContact;
//        this.precisionContact = precisionContact;
//        this.salaireMensuel = salaireMensuel;
//        this.isAutreRevenu = isAutreRevenu;
//        this.montantDesRevenus = montantDesRevenus;
//        this.montantDesCharges = montantDesCharges;
//        this.montantEstimTransact = montantEstimTransact;
//        this.grade = grade;
//        this.poste = poste;
//        this.nomEmployeur = nomEmployeur;
//        this.emailEmployeur = emailEmployeur;
//        this.anciennete = anciennete;
//        this.effectifEntreprise = effectifEntreprise;
//        this.chiffresAffaires = chiffresAffaires;
//        this.capitalEntreprise = capitalEntreprise;
//        this.garant = garant;
//        this.proprietaire = proprietaire;
//        this.nombreEnfants = nombreEnfants;
//        this.personneACharge = personneACharge;
//        this.niveauEtude = niveauEtude;
//        this.status = status;
//        this.createdAt = createdAt;
//        this.createdBy = createdBy;
//        this.updatedAt = updatedAt;
//        this.updatedBy = updatedBy;
//        this.agence = agence;
//        this.fromOnboarding = fromOnboarding;
//    }
//}
