package africa.box.dm.config;

public final class DecisionConfig {

    public static final String action_soumettre = "SOUMETTRE";
    public static final String action_approuver_par_chef_agence = "DECISION_CHEF_AGENCE";
    public static final String action_approuver_par_membre_du_comite = "DECISION_CHEF_RESEAU";

    public static final String LEVEL_1_CHEF_AGENCE = "LEVEL_1_CHEF_AGENCE";
    public static final String LEVEL_2_MOINS_10M = "LEVEL_2_MOINS_10M";
    public static final String LEVEL_2_PLUS_10M = "LEVEL_2_PLUS_10M";
    public static final String DECISION_FINAL = "DECISION_FINAL";
    public static final double MONTANT_COMITE_SUP = 10000000.0;
    public static final int NB_AVIS_COMITE_SUP = 2;
    public static final int NB_AVIS_COMITE_INF = 1;

    public static final String role_decideur = "decideur";
    public static final String role_avis = "avis";
//
//    public static final String[] decideur_level1 = {
//            "franck@box.africa"//"aahimain@bduci.com"
//    };
//
//    public static final String[] decideur_level2_moins_10M = {
//            "fadou@box.africa",//"iwdiallo@bduci.com",
//    };
//
//    public static final String[] decideur_level2_plus_10M = {
//            "fadou@box.africa",//"iwdiallo@bduci.com",
//            "kkouakou@box.africa",//"mhouphouet@bduci.com",
//            "fngadjeu@box.africa"//"aahimain@bduci.com"
//    };
//
//    public static final String[] decideurs = {
//            "test3@box.africa",//"iwdiallo@bduci.com",
//            "test2@box.africa"//"mhouphouet@bduci.com",
//    };

//    public static final String[] decideur_mixed = {"fngadjeu@box.africa"};//"iwdiallo@bduci.com";
//
//    public static final String[] decideur_chefAgence = {"fngadjeu@box.africa"};//"iwdiallo@bduci.com";

    // Used in ChefAgenceControlleur
    // Used in DecisionControlleur
}
