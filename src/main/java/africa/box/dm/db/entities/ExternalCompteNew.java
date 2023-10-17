package africa.box.dm.db.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExternalCompteNew {
    private String uuid;
    private String businesskey;
    private BigInteger id;
    private String surnom;
    private String telephone;
    private String email;
    private String civilite;
    private String nom;
    private String prenoms;
    private String paysdenaissance;
    private String datedenaissance;
    private String lieudenaissance;
    private String numeropiece;
    private String datedevalidite;
    private String autrenumero;
    private String teldomicile;
    private String telbureau;
    private String pays;
    private String adressedelocalisation;
    private String adressepostale;
    private String preuvederesidence;
    private String typeemploi;
    private String profession;
    private String nomemployeur;
    private double salairenet;
    private double autrerevenu;
    private String signature;
    private String otpcode;
    private String otpstatus;
    private boolean statusdemande;
    private String accountstatus;
    private String typeaccount;
    private String sumsub_id;
    //*****************************************
    private String numeroDePiece;
    private String typeDePiece;
    private String typeDemandeur;
    private String nomDemandeur;
    private String prenomDemandeur;
    private String sousTypeClient;
    private String lieuDeNaissance;
    private String mobile;
    private String mobile2;
    private String fixe;
    private String telephoneEmployeur;
    private String codePostal;
    private String adresse;
    private String poste;
    private String nomEmployeur;
    private BigDecimal salaireMensuel;
    private String dateDeNaissance;
    private String dateExpirationPiece;
    private String dateCreationPiece;
    private String ville;
    private String geopoint;


    public ExternalCompteNew() {
    }

    public ExternalCompteNew(String uuid, String businesskey, BigInteger id, String surnom, String telephone, String email, String civilite, String nom, String prenoms, String paysdenaissance, String datedenaissance, String lieudenaissance, String numeropiece, String datedevalidite, String autrenumero, String teldomicile, String telbureau, String pays, String adressedelocalisation, String adressepostale, String preuvederesidence, String typeemploi, String profession, String nomemployeur, double salairenet, double autrerevenu, String signature, String otpcode, String otpstatus, boolean statusdemande, String accountstatus, String typeaccount, String sumsub_id, String numeroDePiece, String typeDePiece, String typeDemandeur, String nomDemandeur, String prenomDemandeur, String sousTypeClient, String lieuDeNaissance, String mobile, String mobile2, String fixe, String telephoneEmployeur, String codePostal, String adresse, String poste, String nomEmployeur, BigDecimal salaireMensuel, String dateDeNaissance, String dateExpirationPiece, String dateCreationPiece, String ville, String geopoint) {
        this.uuid = uuid;
        this.businesskey = businesskey;
        this.id = id;
        this.surnom = surnom;
        this.telephone = telephone;
        this.email = email;
        this.civilite = civilite;
        this.nom = nom;
        this.prenoms = prenoms;
        this.paysdenaissance = paysdenaissance;
        this.datedenaissance = datedenaissance;
        this.lieudenaissance = lieudenaissance;
        this.numeropiece = numeropiece;
        this.datedevalidite = datedevalidite;
        this.autrenumero = autrenumero;
        this.teldomicile = teldomicile;
        this.telbureau = telbureau;
        this.pays = pays;
        this.adressedelocalisation = adressedelocalisation;
        this.adressepostale = adressepostale;
        this.preuvederesidence = preuvederesidence;
        this.typeemploi = typeemploi;
        this.profession = profession;
        this.nomemployeur = nomemployeur;
        this.salairenet = salairenet;
        this.autrerevenu = autrerevenu;
        this.signature = signature;
        this.otpcode = otpcode;
        this.otpstatus = otpstatus;
        this.statusdemande = statusdemande;
        this.accountstatus = accountstatus;
        this.typeaccount = typeaccount;
        this.sumsub_id = sumsub_id;
        this.numeroDePiece = numeroDePiece;
        this.typeDePiece = typeDePiece;
        this.typeDemandeur = typeDemandeur;
        this.nomDemandeur = nomDemandeur;
        this.prenomDemandeur = prenomDemandeur;
        this.sousTypeClient = sousTypeClient;
        this.lieuDeNaissance = lieuDeNaissance;
        this.mobile = mobile;
        this.mobile2 = mobile2;
        this.fixe = fixe;
        this.telephoneEmployeur = telephoneEmployeur;
        this.codePostal = codePostal;
        this.adresse = adresse;
        this.poste = poste;
        this.nomEmployeur = nomEmployeur;
        this.salaireMensuel = salaireMensuel;
        this.dateDeNaissance = dateDeNaissance;
        this.dateExpirationPiece = dateExpirationPiece;
        this.dateCreationPiece = dateCreationPiece;
        this.ville = ville;
        this.geopoint = geopoint;
    }

    public ExternalCompteNew(String uuid, String businesskey, BigInteger id, String surnom, String telephone, String email, String civilite, String nom, String prenoms, String paysdenaissance, String datedenaissance, String lieudenaissance, String numeropiece, String datedevalidite, String autrenumero, String teldomicile, String telbureau, String pays, String adressedelocalisation, String adressepostale, String preuvederesidence, String typeemploi, String profession, String nomemployeur, double salairenet, double autrerevenu, String signature, String otpcode, String otpstatus, boolean statusdemande, String accountstatus, String typeaccount, String sumsub_id, String geopoint) {
        this.uuid = uuid;
        this.businesskey = businesskey;
        this.id = id;
        this.surnom = surnom;
        this.telephone = telephone;
        this.email = email;
        this.civilite = civilite;
        this.nom = nom;
        this.prenoms = prenoms;
        this.paysdenaissance = paysdenaissance;
        this.datedenaissance = datedenaissance;
        this.lieudenaissance = lieudenaissance;
        this.numeropiece = numeropiece;
        this.datedevalidite = datedevalidite;
        this.autrenumero = autrenumero;
        this.teldomicile = teldomicile;
        this.telbureau = telbureau;
        this.pays = pays;
        this.adressedelocalisation = adressedelocalisation;
        this.adressepostale = adressepostale;
        this.preuvederesidence = preuvederesidence;
        this.typeemploi = typeemploi;
        this.profession = profession;
        this.nomemployeur = nomemployeur;
        this.salairenet = salairenet;
        this.autrerevenu = autrerevenu;
        this.signature = signature;
        this.otpcode = otpcode;
        this.otpstatus = otpstatus;
        this.statusdemande = statusdemande;
        this.accountstatus = accountstatus;
        this.typeaccount = typeaccount;
        this.sumsub_id = sumsub_id;

        this.geopoint = geopoint;
    }
    public String getNumeroDePiece() {
        return numeroDePiece;
    }

    public void setNumeroDePiece(String numeroDePiece) {
        this.numeroDePiece = numeroDePiece;
    }

    public String getTypeDePiece() {
        return typeDePiece;
    }

    public void setTypeDePiece(String typeDePiece) {
        this.typeDePiece = typeDePiece;
    }

    public String getTypeDemandeur() {
        return typeDemandeur;
    }

    public void setTypeDemandeur(String typeDemandeur) {
        this.typeDemandeur = typeDemandeur;
    }

    public String getNomDemandeur() {
        return nomDemandeur;
    }

    public void setNomDemandeur(String nomDemandeur) {
        this.nomDemandeur = nomDemandeur;
    }

    public String getPrenomDemandeur() {
        return prenomDemandeur;
    }

    public void setPrenomDemandeur(String prenomDemandeur) {
        this.prenomDemandeur = prenomDemandeur;
    }

    public String getSousTypeClient() {
        return sousTypeClient;
    }

    public void setSousTypeClient(String sousTypeClient) {
        this.sousTypeClient = sousTypeClient;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getTelephoneEmployeur() {
        return telephoneEmployeur;
    }

    public void setTelephoneEmployeur(String telephoneEmployeur) {
        this.telephoneEmployeur = telephoneEmployeur;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getNomEmployeur() {
        return nomEmployeur;
    }

    public void setNomEmployeur(String nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }

    public BigDecimal getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(BigDecimal salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getDateExpirationPiece() {
        return dateExpirationPiece;
    }

    public void setDateExpirationPiece(String dateExpirationPiece) {
        this.dateExpirationPiece = dateExpirationPiece;
    }

    public String getDateCreationPiece() {
        return dateCreationPiece;
    }

    public void setDateCreationPiece(String dateCreationPiece) {
        this.dateCreationPiece = dateCreationPiece;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBusinesskey() {
        return businesskey;
    }

    public void setBusinesskey(String businesskey) {
        this.businesskey = businesskey;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getPaysdenaissance() {
        return paysdenaissance;
    }

    public void setPaysdenaissance(String paysdenaissance) {
        this.paysdenaissance = paysdenaissance;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getLieudenaissance() {
        return lieudenaissance;
    }

    public void setLieudenaissance(String lieudenaissance) {
        this.lieudenaissance = lieudenaissance;
    }

    public String getNumeropiece() {
        return numeropiece;
    }

    public void setNumeropiece(String numeropiece) {
        this.numeropiece = numeropiece;
    }

    public String getDatedevalidite() {
        return datedevalidite;
    }

    public void setDatedevalidite(String datedevalidite) {
        this.datedevalidite = datedevalidite;
    }

    public String getAutrenumero() {
        return autrenumero;
    }

    public void setAutrenumero(String autrenumero) {
        this.autrenumero = autrenumero;
    }

    public String getTeldomicile() {
        return teldomicile;
    }

    public void setTeldomicile(String teldomicile) {
        this.teldomicile = teldomicile;
    }

    public String getTelbureau() {
        return telbureau;
    }

    public void setTelbureau(String telbureau) {
        this.telbureau = telbureau;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdressedelocalisation() {
        return adressedelocalisation;
    }

    public void setAdressedelocalisation(String adressedelocalisation) {
        this.adressedelocalisation = adressedelocalisation;
    }

    public String getAdressepostale() {
        return adressepostale;
    }

    public void setAdressepostale(String adressepostale) {
        this.adressepostale = adressepostale;
    }

    public String getPreuvederesidence() {
        return preuvederesidence;
    }

    public void setPreuvederesidence(String preuvederesidence) {
        this.preuvederesidence = preuvederesidence;
    }

    public String getTypeemploi() {
        return typeemploi;
    }

    public void setTypeemploi(String typeemploi) {
        this.typeemploi = typeemploi;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNomemployeur() {
        return nomemployeur;
    }

    public void setNomemployeur(String nomemployeur) {
        this.nomemployeur = nomemployeur;
    }

    public double getSalairenet() {
        return salairenet;
    }

    public void setSalairenet(double salairenet) {
        this.salairenet = salairenet;
    }

    public double getAutrerevenu() {
        return autrerevenu;
    }

    public void setAutrerevenu(double autrerevenu) {
        this.autrerevenu = autrerevenu;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOtpcode() {
        return otpcode;
    }

    public void setOtpcode(String otpcode) {
        this.otpcode = otpcode;
    }

    public String getOtpstatus() {
        return otpstatus;
    }

    public void setOtpstatus(String otpstatus) {
        this.otpstatus = otpstatus;
    }

    public boolean isStatusdemande() {
        return statusdemande;
    }

    public void setStatusdemande(boolean statusdemande) {
        this.statusdemande = statusdemande;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    public String getTypeaccount() {
        return typeaccount;
    }

    public void setTypeaccount(String typeaccount) {
        this.typeaccount = typeaccount;
    }

    public String getSumsub_id() {
        return sumsub_id;
    }

    public void setSumsub_id(String sumsub_id) {
        this.sumsub_id = sumsub_id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getGeopoint() {
        return geopoint;
    }

    public void setGeopoint(String geopoint) {
        this.geopoint = geopoint;
    }
}
