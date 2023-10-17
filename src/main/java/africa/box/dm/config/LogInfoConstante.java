package africa.box.dm.config;

public final class LogInfoConstante {

    // STEP 1 CREATION DE DOSSIER
    public static class INITIALISATION_DU_DOSSIER {

        public static final String INITIALISATION_DE_DOSSIER = "Initialisation de dossier (BROUILLON)";
//        public static final String INFORMATION_COMPTE= "Modification des informations sur le COMPTE";
        public static final String VERIFICATION_PEPS = "Initialisation de la Vérification PEPs et criminelle";
        public static final String INFORMATION_DEMANDEUR = "Modification des informations sur le demandeur";
        public static final String COORDONNEES_DEMANDEUR = "Modification des coordonnées du demandeur";
        public static final String INFORMATION_REVENUS_ET_EMPLOYEUR = "Modification des informations sur les revenus et l'employeur";
        public static final String INFORMATION_COMPLEMENTAIRE = "Modification des informations complementaire";
        public static final String VALIDER_POUR_TRAITEMENT = "Valider pour traitement";
        public static final String SYNCHRONISATION = "Synchronisation des informations";
        public static final String SYNCHRONISER_POUR_TRAITEMENT = "Synchronisation des informations effectuées pour le traitement";
        public static final String MISE_A_JOUR_EN_ATTENTE = "Mise à jour du statut du dossier (EN ATTENTE)";
    }

    // STEP 2 TRAITEMENT DU DOSSIER
    public static class TRAITEMENT_DU_DOSSIER {
        public static final String TRAITEMENT_DU_DOSSIER = "Traitement du dossier";

        // STEP 2.1 CHARGEMENT DES DOCUMENTS
        public static class ETAPE_CHARGER_LES_DOCUMENTS {
            public static final String ETAPE_CHARGER_LES_DOCUMENTS = "Chargement des documents ";
            public static final String DOCUMENT_CHARGE = "Document chargé ";
            public static final String DOCUMENT_AJOUTE = "Document ajouté manuellement ";
            public static final String DOCUMENT_FACULTATIF = "Document rendu facultatif ";
            public static final String DOCUMENT_OBLIGATOIRE = "Document rendu obligatoire ";
            public static final String DOCUMENT_SUPPRIMER = "Document supprimé ";
        }

        // STEP 2.2 ENREGISTREMENT DES DONNEES
        public static class ETAPE_ENREGISTREMENT_DES_DONNEES {
            public static final String ETAPE_ENREGISTREMENT_DES_DONNEES = "Enregistrement des données ";
            public static final String DOCUMENT_TRAITE = "Document traité ";
            public static final String DOCUMENT_SUPPRIMER = "Document supprimé";

        }

        // STEP 2.3 VERIFICATION CIP
        public static class ETAPE_VERIFICATION_PEPs_CRIMINELLE {
            public static final String INITIALISATION_PEPs_CRIMINELLE = "Initialisation de la Vérification PEPs et criminelle";

            public static final String ETAPE_VERIFICATION_PEPs_CRIMINELLE = "Vérification PEPs et criminelle";

            public static final String ETAPE_VERIFICATION_PEPs_CRIMINELLE_CONJOINT = "Vérification PEPs et criminelle du conjoint";
            public static final String MODIFICATION_PEPs_CRIMINELLE = "Modification de la Vérification PEPs et criminelle";
            public static final String MODIFICATION_PEPs_CRIMINELLE_CONJOINT = "Modification de la Vérification PEPs et criminelle du conjoint";
            public static final String VALIDATION = "Validation de la Vérification PEPs et criminelle";
            public static final String VALIDATION_CONJOINT = "Validation de la Vérification PEPs et criminelle du conjoint";
        }

        // STEP 2.3 VERIFICATION CIP
        public static class ETAPE_VERIFICATION_CIP {
            public static final String ETAPE_VERIFICATION_CIP = "Vérification CIP";
            public static final String ETAPE_VERIFICATION_CIP_CONJOINT = "Vérification CIP du conjoint";
            public static final String TRAITEMENT_DU_DOCUMENT = "document CIP traité";
            public static final String TRAITEMENT_DU_DOCUMENT_CONJOINT = "document CIP traité du conjoint";
            public static final String VALIDATION = "Validation de la vérification CIP";
            public static final String VALIDATION_CONJOINT = "Validation de la vérification CIP du conjoint";
            public static final String SIGNALER_LA_VERIFICATION_CIP = "Signale de la verification CIP";
            public static final String SIGNALER_LA_VERIFICATION_CIP_CONJOINT = "Signale de la verification CIP du conjoint";
            public static final String MODIFICATION_VERIFICATION_CIP = "Modification de la vérification CIP";
            public static final String MODIFICATION_VERIFICATION_CIP_CONJOINT = "Modification de la vérification CIP du conjoint";

        }
        // STEP 2.4 SIGNATURE_CONTRAT
        public static class ETAPE_SIGNATURE_CONTRAT {
            public static final String ETAPE_VERIFICATION_SIGNATURE = "Vérification signature";
            public static final String SIGNER_CONTRAT_VOLO = "Contrat volo signé";
            public static final String SIGNER_CONTRAT_COMPTE = "Contrat ouverture de compte signé";
            public static final String SIGNER_DKBS = "Signature Dkbs effectué";

        }


        // STEP 2.5 SYNTHESE
        public static final String VALIDATION_DE_LA_SYNTHESE = "Validation de la synthèse";

    }

    // STEP 3 APPROBATION
    public static class APPROBATION_DU_DOSSIER {
        public static final String APPROBATION_DU_DOSSIER = "Approbation ";
        public static final String SOUMISSION = "Soumission du chargé clientèle";
        public static final String DECISION_CHEF_AGENCE = "Décision du chef d'agence ";
        public static final String DECISION_CHEF_DE_RESEAUX = "Décision du chef de reseau";
        public static final String RENDRE_ABSENT = "Absence signalée ";
    }

}