package africa.box.dm.config;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class DmnConstants {
    @Value("${amplitude.soap-path}")
    public static final String SOAP_PATH ="";
    public static final String DMN_DECISION_KEY="listDocumentForNewAccount";
    public static final String PERSONNE_PHYSIQUE_COMPTE_COURANT = "personnes_physiques_cc";
    public static final String PERSONNE_PHYSIQUE_COMPTE_EPARGNE = "personnes_physiques_ce";
    public static final String PERSONNE_PHYSIQUE_CORPS_COMPTE_COURANT= "personnes_physiques_corps_cc";
    public static final String PERSONNE_PHYSIQUE_COMMERCANT_COMPTE_COURANT= "personnes_physiques_commercants_cc";

    public static final String PERSONNE_MORALE= "personnes_morale";
    public static final String PERSONNE_MORALE_NOTAIRE= "personnes_morale_not";
    public static final String PERSONNE_MORALE_ENTR_INDIVID= "personnes_morale_ent_individ";
    public static final String PERSONNE_MORALE_SARL= "personnes_morale_sarl";
    public static final String PERSONNE_MORALE_SA= "personnes_morale_sa";
    public static final String PERSONNE_MORALE_COURTIER_ASS= "personnes_morale_courtier_ass";
    public static final String PERSONNE_MORALE_SOCIETE_CIVIL_EXPLOITATION= "personnes_morale_societ_civil_ex";
    public static final String PERSONNE_MORALE_AVOCAT= "personnes_morale_avocat";
    public static final String PERSONNE_MORALE_HUISSIER= "personnes_morale_huissier";
    public static final String PERSONNE_MORALE_LIQUIDATEUR= "personnes_morale_liquidateur";
    public static final String PERSONNE_MORALE_PHARMACIE= "personnes_morale_pharmacie";
    public static final String PERSONNE_MORALE_ASSOCIATION_CIVIL= "personnes_morale_association_civil";
    public static final String PERSONNE_MORALE_CABINET_ARCHITECTURE= "personnes_morale_cabinet_architecture";
    public static final String PERSONNE_MORALE_SOCIETE_IMMOBILIERE= "personnes_morale_immobiliere";
    public static final String PERSONNE_MORALE_CLINIQUES_MEDICALE= "personnes_morale_cliniques";
    public static final String PERSONNE_MORALE_ANCIEN= "personnes_morale_ancien";
    public static final String PERSONNE_MORALE_NOUVEAU= "personnes_morale_nouveau";
    public static final String PERSONNE_ETRANGERE = "personne_etrangere";
    public static final String PERSONNE_PHYSIQUE_CONJOINT = "personnes_physiques_conjoint";
    public static final String CREDIT_CARD = "credit_card";
    public static final String ID_CARD_VERSO = "id_card_verso";
    public static final String ID_CARD_CONJOINT_VERSO = "id_card_verso_conjoint";

    public static final class NATIONALITE {
        public static final String NATIONALITE_IVOIRIENNE = "IVOIRIENNE";
    }
    public static final class TYPE_COMPTE {
        public static final String EPARGNE = "epargne";
        public static final String CHECK = "cheque";
    }

    public static final class TYPE_DEMANDEUR {
        public static final String PHYSIQUE = "Personne Physique";
        public static final String MORALE = "Personne Morale";
    }

    public static final class TYPE_DOMAINE_DEMANDEUR {
        public static final String FONCTIONNAIRE = "fonctionnaire";
        public static final String GENDARME = "gendarme";
        public static final String PRIVE = "prive";
        public static final String CORPS = "militaire";
        public static final String COMMERCANT = "commercant";
    }

    public static final class FORME_JURIDIQUE_ENTREPRISE {
        public  static final String SARL = "sarl";
        public  static final String SA = "sa";
        public  static final String COURTIER_ASSURANCE = "courtier_assurance";
        public  static final String SOCIETE_CIVILE_EXPLOITANTS_FORESTIERS = "societe_civile_exploitants_forestiers";
        public  static final String SOCIETES_CIVILES_IMMOBILIERES = "societes_civiles_immo";
        public  static final String ASSOCIATION_CIVILE = "association_civile";
        public  static final String ENTREPRISE_INDIVIDUELLE = "entreprise_individuelle";
        public  static final String NOTAIRE = "notaire";
        public  static final String AVOCAT = "avocat";
        public  static final String HUISSIER = "huissier";
        public  static final String LIQUIDATEUR = "liquidateur";
        public  static final String CABINET_ARCHITECTURE = "cabinet_architecture";
        public  static final String PHARMACIE = "pharmacie";
        public  static final String CLINIQUES_MEDICALES = "cliniques_medicales";
    }

    public static final class IDCardType {
        public final static String PASSEPORT = "PSP";
        public final static String CNI = "CNI";
        public final static String PERMIS_DE_CONDUIRE = "PERMIS DE CONDUIRE";
    }
}
