package africa.box.dm.db.entities;

import africa.box.dm.config.MyAppConfig;
import africa.box.dm.service.CompteService;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExternalCompte {
    private String businesskey;
    private String adresse;
    private String adresse2;
    private String agence;
    private Integer anciennete;
    private String augmentation;
    private String boitepostal;
    private Double capitalentreprise;
    private String centreimpotent;
    private Double chiffresaffaires;
    private String codepostal;
    private String comptecontribuablelent;
    private String concurentsecteurent;
    private String contactpersocontact;
    private Date created_at;
    private String created_by;
    private Date datecreationsociete;
    private Date datedenaissance;
    private Date dateregistrecom;
    private String delaisregclientent;
    private String detailspersonnepolitique;
    private String devise;
    private String effectifentreprise;
    private String email;
    private String emailemployeur;
    private String filationavecclient;
    private String fixe;
    private String formejuridique;
    private String fournisseursent;
    private String garant;
    private String genre;
    private String grade;
    private Boolean isadresse2;
    private Boolean isautrerevenu;
    private Boolean isautresignataire;
    private Boolean iscartebancaire;
    private Boolean isclient;
    private Boolean isclientcip;
    private Boolean isdemarche;
    private Boolean ismineur;
    private Boolean ismobile2;
    private Boolean personnePolitique;
    private String lieudenaissance;
    private String lieuregistrecom;
    private String lieuresidencecontact;
    private List<HashMap<String,Object>> listautresignataire;
    private List<HashMap<String,Object>> listautrerevenu;
    private String matricule;
    private String mobile;
    private String mobile2;
    private String modecommercialent;
    private Double montantdescharges;
    private Double montantdesrevenus;
    private Double montantestimtransact;
    private String motifouverture;
    private String nationalite;
    private String niveauetude;
    private String nomdenaissance;
    private String nomdemandeur;
    private String nomemployeur;
    private String nompersoacontact;
    private String nomsociete;
    private String nomsurcarte;
    private Integer nombreenfants;
    private String numeroregistrecommerce;
    private String pays;
    private Integer personneacharge;
    private String poste;
    private String precisioncontact;
    private String prenomdemandeur;
    private String prenompersoacontact;
    private String[] proprietaire;
    private Double salairemensuel;
    private String secteuractiveentrep;
    private String siegesocialent;
    private String siteinternetent;
    private String situationgeographique;
    private String situationmatrimonial;
    private String soustypeclient;
    private Integer status;
    private Integer statut_docs;
    private String tailleconcurentent;
    private String typecompte;
    private String typedemandeur;
    private Date updated_at;
    private String updated_by;
    private String ville;
    private String useruid;
    private String businesskey_account;
    private String statut_demande;
    private String statut_confirm;
    private String nommineur;
    private String prenommineur;
    private String datedenaissancemineur;
    private String lieudenaissancemineur;
    private String nationalitemineur;
    private String genremineur;
    //****************************
    private String numeroDePiece;
    private String typeDePiece;
    private String typeDemandeur;
    private String nomDemandeur;
    private String prenomDemandeur;
    private String sousTypeClient;
    private String lieuDeNaissance;
    private String telephoneEmployeur;
    private String codePostal;
    private String nomEmployeur;
    private double salaireMensuel;
    private String dateDeNaissance;
    private String dateExpirationPiece;
    private String dateCreationPiece;
    private String geopoint;

    public ExternalCompte() {
    }

    public String getNumeroDePiece() {
        return numeroDePiece;
    }

    @Override
    public String toString() {
        return "ExternalCompte{" +
                "businesskey='" + businesskey + '\'' +
                ", adresse='" + adresse + '\'' +
                ", adresse2='" + adresse2 + '\'' +
                ", agence='" + agence + '\'' +
                ", anciennete=" + anciennete +
                ", augmentation='" + augmentation + '\'' +
                ", boitepostal='" + boitepostal + '\'' +
                ", capitalentreprise=" + capitalentreprise +
                ", centreimpotent='" + centreimpotent + '\'' +
                ", chiffresaffaires=" + chiffresaffaires +
                ", codepostal='" + codepostal + '\'' +
                ", comptecontribuablelent='" + comptecontribuablelent + '\'' +
                ", concurentsecteurent='" + concurentsecteurent + '\'' +
                ", contactpersocontact='" + contactpersocontact + '\'' +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", datecreationsociete=" + datecreationsociete +
                ", datedenaissance=" + datedenaissance +
                ", dateregistrecom=" + dateregistrecom +
                ", delaisregclientent='" + delaisregclientent + '\'' +
                ", detailspersonnepolitique='" + detailspersonnepolitique + '\'' +
                ", devise='" + devise + '\'' +
                ", effectifentreprise='" + effectifentreprise + '\'' +
                ", email='" + email + '\'' +
                ", emailemployeur='" + emailemployeur + '\'' +
                ", filationavecclient='" + filationavecclient + '\'' +
                ", fixe='" + fixe + '\'' +
                ", formejuridique='" + formejuridique + '\'' +
                ", fournisseursent='" + fournisseursent + '\'' +
                ", garant='" + garant + '\'' +
                ", genre='" + genre + '\'' +
                ", grade='" + grade + '\'' +
                ", isadresse2=" + isadresse2 +
                ", isautrerevenu=" + isautrerevenu +
                ", isautresignataire=" + isautresignataire +
                ", iscartebancaire=" + iscartebancaire +
                ", isclient=" + isclient +
                ", isclientcip=" + isclientcip +
                ", isdemarche=" + isdemarche +
                ", ismineur=" + ismineur +
                ", ismobile2=" + ismobile2 +
                ", personnePolitique=" + personnePolitique +
                ", lieudenaissance='" + lieudenaissance + '\'' +
                ", lieuregistrecom='" + lieuregistrecom + '\'' +
                ", lieuresidencecontact='" + lieuresidencecontact + '\'' +
                ", listautresignataire=" + listautresignataire +
                ", listautrerevenu=" + listautrerevenu +
                ", matricule='" + matricule + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobile2='" + mobile2 + '\'' +
                ", modecommercialent='" + modecommercialent + '\'' +
                ", montantdescharges=" + montantdescharges +
                ", montantdesrevenus=" + montantdesrevenus +
                ", montantestimtransact=" + montantestimtransact +
                ", motifouverture='" + motifouverture + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", niveauetude='" + niveauetude + '\'' +
                ", nomdenaissance='" + nomdenaissance + '\'' +
                ", nomdemandeur='" + nomdemandeur + '\'' +
                ", nomemployeur='" + nomemployeur + '\'' +
                ", nompersoacontact='" + nompersoacontact + '\'' +
                ", nomsociete='" + nomsociete + '\'' +
                ", nomsurcarte='" + nomsurcarte + '\'' +
                ", nombreenfants=" + nombreenfants +
                ", numeroregistrecommerce='" + numeroregistrecommerce + '\'' +
                ", pays='" + pays + '\'' +
                ", personneacharge=" + personneacharge +
                ", poste='" + poste + '\'' +
                ", precisioncontact='" + precisioncontact + '\'' +
                ", prenomdemandeur='" + prenomdemandeur + '\'' +
                ", prenompersoacontact='" + prenompersoacontact + '\'' +
                ", proprietaire=" + Arrays.toString(proprietaire) +
                ", salairemensuel=" + salairemensuel +
                ", secteuractiveentrep='" + secteuractiveentrep + '\'' +
                ", siegesocialent='" + siegesocialent + '\'' +
                ", siteinternetent='" + siteinternetent + '\'' +
                ", situationgeographique='" + situationgeographique + '\'' +
                ", situationmatrimonial='" + situationmatrimonial + '\'' +
                ", soustypeclient='" + soustypeclient + '\'' +
                ", status=" + status +
                ", statut_docs=" + statut_docs +
                ", tailleconcurentent='" + tailleconcurentent + '\'' +
                ", typecompte='" + typecompte + '\'' +
                ", typedemandeur='" + typedemandeur + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                ", ville='" + ville + '\'' +
                ", useruid='" + useruid + '\'' +
                ", businesskey_account='" + businesskey_account + '\'' +
                ", statut_demande='" + statut_demande + '\'' +
                ", statut_confirm='" + statut_confirm + '\'' +
                ", nommineur='" + nommineur + '\'' +
                ", prenommineur='" + prenommineur + '\'' +
                ", datedenaissancemineur='" + datedenaissancemineur + '\'' +
                ", lieudenaissancemineur='" + lieudenaissancemineur + '\'' +
                ", nationalitemineur='" + nationalitemineur + '\'' +
                ", genremineur='" + genremineur + '\'' +
                ", numeroDePiece='" + numeroDePiece + '\'' +
                ", typeDePiece='" + typeDePiece + '\'' +
                ", typeDemandeur='" + typeDemandeur + '\'' +
                ", nomDemandeur='" + nomDemandeur + '\'' +
                ", prenomDemandeur='" + prenomDemandeur + '\'' +
                ", sousTypeClient='" + sousTypeClient + '\'' +
                ", lieuDeNaissance='" + lieuDeNaissance + '\'' +
                ", telephoneEmployeur='" + telephoneEmployeur + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", nomEmployeur='" + nomEmployeur + '\'' +
                ", salaireMensuel=" + salaireMensuel +
                ", dateDeNaissance='" + dateDeNaissance + '\'' +
                ", dateExpirationPiece='" + dateExpirationPiece + '\'' +
                ", dateCreationPiece='" + dateCreationPiece + '\'' +
                ", geopoint='" + geopoint + '\'' +
                '}';
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

    public String getNomEmployeur() {
        return nomEmployeur;
    }

    public void setNomEmployeur(String nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(double salaireMensuel) {
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

    public String getBusinesskey() {
        return businesskey;
    }

    public void setBusinesskey(String businesskey) {
        this.businesskey = businesskey;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }

    public String getAugmentation() {
        return augmentation;
    }

    public void setAugmentation(String augmentation) {
        this.augmentation = augmentation;
    }

    public String getBoitepostal() {
        return boitepostal;
    }

    public void setBoitepostal(String boitepostal) {
        this.boitepostal = boitepostal;
    }

    public Double getCapitalentreprise() {
        return capitalentreprise;
    }

    public void setCapitalentreprise(Double capitalentreprise) {
        this.capitalentreprise = capitalentreprise;
    }

    public String getCentreimpotent() {
        return centreimpotent;
    }

    public void setCentreimpotent(String centreimpotent) {
        this.centreimpotent = centreimpotent;
    }

    public Double getChiffresaffaires() {
        return chiffresaffaires;
    }

    public void setChiffresaffaires(Double chiffresaffaires) {
        this.chiffresaffaires = chiffresaffaires;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getComptecontribuablelent() {
        return comptecontribuablelent;
    }

    public void setComptecontribuablelent(String comptecontribuablelent) {
        this.comptecontribuablelent = comptecontribuablelent;
    }

    public String getConcurentsecteurent() {
        return concurentsecteurent;
    }

    public void setConcurentsecteurent(String concurentsecteurent) {
        this.concurentsecteurent = concurentsecteurent;
    }

    public String getContactpersocontact() {
        return contactpersocontact;
    }

    public void setContactpersocontact(String contactpersocontact) {
        this.contactpersocontact = contactpersocontact;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getDatecreationsociete() {
        return datecreationsociete;
    }

    public void setDatecreationsociete(Date datecreationsociete) {
        this.datecreationsociete = datecreationsociete;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public Date getDateregistrecom() {
        return dateregistrecom;
    }

    public void setDateregistrecom(Date dateregistrecom) {
        this.dateregistrecom = dateregistrecom;
    }

    public String getDelaisregclientent() {
        return delaisregclientent;
    }

    public void setDelaisregclientent(String delaisregclientent) {
        this.delaisregclientent = delaisregclientent;
    }

    public String getDetailspersonnepolitique() {
        return detailspersonnepolitique;
    }

    public void setDetailspersonnepolitique(String detailspersonnepolitique) {
        this.detailspersonnepolitique = detailspersonnepolitique;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getEffectifentreprise() {
        return effectifentreprise;
    }

    public void setEffectifentreprise(String effectifentreprise) {
        this.effectifentreprise = effectifentreprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailemployeur() {
        return emailemployeur;
    }

    public void setEmailemployeur(String emailemployeur) {
        this.emailemployeur = emailemployeur;
    }

    public String getFilationavecclient() {
        return filationavecclient;
    }

    public void setFilationavecclient(String filationavecclient) {
        this.filationavecclient = filationavecclient;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getFormejuridique() {
        return formejuridique;
    }

    public void setFormejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
    }

    public String getFournisseursent() {
        return fournisseursent;
    }

    public void setFournisseursent(String fournisseursent) {
        this.fournisseursent = fournisseursent;
    }

    public String getGarant() {
        return garant;
    }

    public void setGarant(String garant) {
        this.garant = garant;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getIsadresse2() {
        return isadresse2;
    }

    public void setIsadresse2(Boolean isadresse2) {
        this.isadresse2 = isadresse2;
    }

    public Boolean getIsautrerevenu() {
        return isautrerevenu;
    }

    public void setIsautrerevenu(Boolean isautrerevenu) {
        this.isautrerevenu = isautrerevenu;
    }

    public Boolean getIsautresignataire() {
        return isautresignataire;
    }

    public void setIsautresignataire(Boolean isautresignataire) {
        this.isautresignataire = isautresignataire;
    }

    public Boolean getIscartebancaire() {
        return iscartebancaire;
    }

    public void setIscartebancaire(Boolean iscartebancaire) {
        this.iscartebancaire = iscartebancaire;
    }

    public Boolean getIsclient() {
        return isclient;
    }

    public void setIsclient(Boolean isclient) {
        this.isclient = isclient;
    }

    public Boolean getIsclientcip() {
        return isclientcip;
    }

    public void setIsclientcip(Boolean isclientcip) {
        this.isclientcip = isclientcip;
    }

    public Boolean getIsdemarche() {
        return isdemarche;
    }

    public void setIsdemarche(Boolean isdemarche) {
        this.isdemarche = isdemarche;
    }

    public Boolean getIsmineur() {
        return ismineur;
    }

    public void setIsmineur(Boolean ismineur) {
        this.ismineur = ismineur;
    }

    public Boolean getIsmobile2() {
        return ismobile2;
    }

    public void setIsmobile2(Boolean ismobile2) {
        this.ismobile2 = ismobile2;
    }

    public Boolean getpersonnePolitique() {
        return personnePolitique;
    }

    public void setpersonnePolitique(Boolean personnePolitique) {
        this.personnePolitique = personnePolitique;
    }

    public String getLieudenaissance() {
        return lieudenaissance;
    }

    public void setLieudenaissance(String lieudenaissance) {
        this.lieudenaissance = lieudenaissance;
    }

    public String getLieuregistrecom() {
        return lieuregistrecom;
    }

    public void setLieuregistrecom(String lieuregistrecom) {
        this.lieuregistrecom = lieuregistrecom;
    }

    public String getLieuresidencecontact() {
        return lieuresidencecontact;
    }

    public void setLieuresidencecontact(String lieuresidencecontact) {
        this.lieuresidencecontact = lieuresidencecontact;
    }

    public List<HashMap<String, Object>> getListautresignataire() {
        return listautresignataire;
    }

    public void setListautresignataire(List<HashMap<String, Object>> listautresignataire) {
        this.listautresignataire = listautresignataire;
    }

    public List<HashMap<String, Object>> getListautrerevenu() {
        return listautrerevenu;
    }

    public void setListautrerevenu(List<HashMap<String, Object>> listautrerevenu) {
        this.listautrerevenu = listautrerevenu;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getModecommercialent() {
        return modecommercialent;
    }

    public void setModecommercialent(String modecommercialent) {
        this.modecommercialent = modecommercialent;
    }

    public Double getMontantdescharges() {
        return montantdescharges;
    }

    public void setMontantdescharges(Double montantdescharges) {
        this.montantdescharges = montantdescharges;
    }

    public Double getMontantdesrevenus() {
        return montantdesrevenus;
    }

    public void setMontantdesrevenus(Double montantdesrevenus) {
        this.montantdesrevenus = montantdesrevenus;
    }

    public Double getMontantestimtransact() {
        return montantestimtransact;
    }

    public void setMontantestimtransact(Double montantestimtransact) {
        this.montantestimtransact = montantestimtransact;
    }

    public String getMotifouverture() {
        return motifouverture;
    }

    public void setMotifouverture(String motifouverture) {
        this.motifouverture = motifouverture;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNiveauetude() {
        return niveauetude;
    }

    public void setNiveauetude(String niveauetude) {
        this.niveauetude = niveauetude;
    }

    public String getNomdenaissance() {
        return nomdenaissance;
    }

    public void setNomdenaissance(String nomdenaissance) {
        this.nomdenaissance = nomdenaissance;
    }

    public String getNomdemandeur() {
        return nomdemandeur;
    }

    public void setNomdemandeur(String nomdemandeur) {
        this.nomdemandeur = nomdemandeur;
    }

    public String getNomemployeur() {
        return nomemployeur;
    }

    public void setNomemployeur(String nomemployeur) {
        this.nomemployeur = nomemployeur;
    }

    public String getNompersoacontact() {
        return nompersoacontact;
    }

    public void setNompersoacontact(String nompersoacontact) {
        this.nompersoacontact = nompersoacontact;
    }

    public String getNomsociete() {
        return nomsociete;
    }

    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    public String getNomsurcarte() {
        return nomsurcarte;
    }

    public void setNomsurcarte(String nomsurcarte) {
        this.nomsurcarte = nomsurcarte;
    }

    public Integer getNombreenfants() {
        return nombreenfants;
    }

    public void setNombreenfants(Integer nombreenfants) {
        this.nombreenfants = nombreenfants;
    }

    public String getNumeroregistrecommerce() {
        return numeroregistrecommerce;
    }

    public void setNumeroregistrecommerce(String numeroregistrecommerce) {
        this.numeroregistrecommerce = numeroregistrecommerce;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getPersonneacharge() {
        return personneacharge;
    }

    public void setPersonneacharge(Integer personneacharge) {
        this.personneacharge = personneacharge;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getPrecisioncontact() {
        return precisioncontact;
    }

    public void setPrecisioncontact(String precisioncontact) {
        this.precisioncontact = precisioncontact;
    }

    public String getPrenomdemandeur() {
        return prenomdemandeur;
    }

    public void setPrenomdemandeur(String prenomdemandeur) {
        this.prenomdemandeur = prenomdemandeur;
    }

    public String getPrenompersoacontact() {
        return prenompersoacontact;
    }

    public void setPrenompersoacontact(String prenompersoacontact) {
        this.prenompersoacontact = prenompersoacontact;
    }

    public String[] getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String[] proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Double getSalairemensuel() {
        return salairemensuel;
    }

    public void setSalairemensuel(Double salairemensuel) {
        this.salairemensuel = salairemensuel;
    }

    public String getSecteuractiveentrep() {
        return secteuractiveentrep;
    }

    public void setSecteuractiveentrep(String secteuractiveentrep) {
        this.secteuractiveentrep = secteuractiveentrep;
    }

    public String getSiegesocialent() {
        return siegesocialent;
    }

    public void setSiegesocialent(String siegesocialent) {
        this.siegesocialent = siegesocialent;
    }

    public String getSiteinternetent() {
        return siteinternetent;
    }

    public void setSiteinternetent(String siteinternetent) {
        this.siteinternetent = siteinternetent;
    }

    public String getSituationgeographique() {
        return situationgeographique;
    }

    public void setSituationgeographique(String situationgeographique) {
        this.situationgeographique = situationgeographique;
    }

    public String getSituationmatrimonial() {
        return situationmatrimonial;
    }

    public void setSituationmatrimonial(String situationmatrimonial) {
        this.situationmatrimonial = situationmatrimonial;
    }

    public String getSoustypeclient() {
        return soustypeclient;
    }

    public void setSoustypeclient(String soustypeclient) {
        this.soustypeclient = soustypeclient;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTailleconcurentent() {
        return tailleconcurentent;
    }

    public void setTailleconcurentent(String tailleconcurentent) {
        this.tailleconcurentent = tailleconcurentent;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

    public String getTypedemandeur() {
        return typedemandeur;
    }

    public void setTypedemandeur(String typedemandeur) {
        this.typedemandeur = typedemandeur;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getUseruid() {
        return useruid;
    }

    public void setUseruid(String useruid) {
        this.useruid = useruid;
    }

    public String getBusinesskey_account() {
        return businesskey_account;
    }

    public void setBusinesskey_account(String businesskey_account) {
        this.businesskey_account = businesskey_account;
    }

    public String getStatut_demande() {
        return statut_demande;
    }

    public void setStatut_demande(String statut_demande) {
        this.statut_demande = statut_demande;
    }

    public String getStatut_confirm() {
        return statut_confirm;
    }

    public void setStatut_confirm(String statut_confirm) {
        this.statut_confirm = statut_confirm;
    }

    public String getNommineur() {
        return nommineur;
    }

    public void setNommineur(String nommineur) {
        this.nommineur = nommineur;
    }

    public String getPrenommineur() {
        return prenommineur;
    }

    public void setPrenommineur(String prenommineur) {
        this.prenommineur = prenommineur;
    }

    public String getDatedenaissancemineur() {
        return datedenaissancemineur;
    }

    public void setDatedenaissancemineur(String datedenaissancemineur) {
        this.datedenaissancemineur = datedenaissancemineur;
    }

    public String getLieudenaissancemineur() {
        return lieudenaissancemineur;
    }

    public void setLieudenaissancemineur(String lieudenaissancemineur) {
        this.lieudenaissancemineur = lieudenaissancemineur;
    }

    public String getNationalitemineur() {
        return nationalitemineur;
    }

    public void setNationalitemineur(String nationalitemineur) {
        this.nationalitemineur = nationalitemineur;
    }

    public String getGenremineur() {
        return genremineur;
    }

    public void setGenremineur(String genremineur) {
        this.genremineur = genremineur;
    }

    public Integer getStatut_docs() {
        return statut_docs;
    }

    public void setStatut_docs(Integer statut_docs) {
        this.statut_docs = statut_docs;
    }

    public String getGeopoint() {
        return geopoint;
    }

    public void setGeopoint(String geopoint) {
        this.geopoint = geopoint;
    }
}
