package africa.box.dm.config;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.squareup.okhttp.internal.Internal.logger;
import static java.math.BigDecimal.valueOf;

public class ValuesParam {
    public static String forceCodePostal(String ville) {
        logger.info("Champ code postal du client force par defaut à la ville: " + ville);
        return ville;
    }

    public static String getCodeAgence(String agence) {
        Map<String, String> mapAgence = new HashMap<>();
        String codeAgence = null;
        mapAgence.put("01007", "2Plateaux");
        mapAgence.put("01002", "ADJAME");
        mapAgence.put("01001", "AGENCE PRINCIPALE");
        mapAgence.put("02001", "BOUAKE");
        mapAgence.put("08001", "DALOA");
        mapAgence.put("06001", "KORHOGO");
        mapAgence.put("01005", "KOUMASSI");
        mapAgence.put("01008", "MARCORY");
        mapAgence.put("01004", "PORT-BOUET");
        mapAgence.put("01010", "RIVIERA");
        mapAgence.put("07001", "SAN PEDRO");
        mapAgence.put("01200", "SIEGE CENTRAL");
        mapAgence.put("01001", "TEST AGENCE");
        mapAgence.put("01003", "TREICHVILLE");
        mapAgence.put("01006", "YOPOUGON");

        for (Map.Entry m : mapAgence.entrySet()) {
            if (m.getValue().equals(agence.replace("/", "").trim())) {
                codeAgence = m.getKey().toString();
                break;
            }
        }
        return codeAgence;
    }

    public static String getSituationFamille(String situationFamille) {
        Map<String, String> mapSituationFamille = new HashMap<>();
        String codeSituationFamille = null;
        mapSituationFamille.put("C", "CELIBATAIRE");
        mapSituationFamille.put("D", "DIVORCE(E)");
        mapSituationFamille.put("I", "STATUT INCONNU");
        mapSituationFamille.put("M", "MARIE(E) MONOGAME");
        mapSituationFamille.put("P", "MARIE(E) POLYGAME");
        mapSituationFamille.put("V", "VEUF(VE)");
        mapSituationFamille.put("W", "CONCUBINAGE");

        for (Map.Entry m : mapSituationFamille.entrySet()) {
            if (m.getValue().equals(situationFamille.trim())) {
                codeSituationFamille = m.getKey().toString();
                break;
            }
        }
        return codeSituationFamille;
    }
    public static String getRegimeMatrimonial(String regimeMatrimonial) {
        Map<String, String> mapRegimeMatrimonial = new HashMap<>();
        String codeRegimeMatrimonial = null;
        mapRegimeMatrimonial.put("C", "COMMUNAUTE DES BIENS");
        mapRegimeMatrimonial.put("R", "COMMUNAUTE REDUITE AUX ACQUETS");
        mapRegimeMatrimonial.put("S", "SEPARATION DES BIENS");
        mapRegimeMatrimonial.put("Z", "AUTRE REGIME");

        for (Map.Entry m : mapRegimeMatrimonial.entrySet()) {
            if (m.getValue().equals(regimeMatrimonial.trim())) {
                codeRegimeMatrimonial = m.getKey().toString();
                break;
            }
        }
        return codeRegimeMatrimonial;
    }
    public static String getLangueParle(String langueParle) {
        Map<String, String> mapLangueParle = new HashMap<>();
        String codeLanugeParle = null;
        mapLangueParle.put("001", "Français");
        mapLangueParle.put("002", "Anglais");
        mapLangueParle.put("003", "Arabe");
        mapLangueParle.put("004", "Bulgare");
        mapLangueParle.put("005", "Russe");

        for (Map.Entry m : mapLangueParle.entrySet()) {
            if (m.getValue().equals(langueParle.trim())) {
                codeLanugeParle = m.getKey().toString();
                break;
            }
        }
        return codeLanugeParle;
    }
    public static String getCodeTrancheRevenus(BigDecimal montantDesRevenus){
        String codeTrancheRevenus = null;
        if (montantDesRevenus.compareTo(BigDecimal.valueOf(50000)) < 0){
            codeTrancheRevenus = "10";
        } else if (montantDesRevenus.compareTo(BigDecimal.valueOf(100000)) < 0) {
            codeTrancheRevenus = "20";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(250000)) < 0) {
            codeTrancheRevenus = "30";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(350000)) < 0) {
            codeTrancheRevenus = "40";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(500000)) < 0) {
            codeTrancheRevenus = "50";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(700000)) < 0) {
            codeTrancheRevenus = "60";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(900000)) < 0) {
            codeTrancheRevenus = "70";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(1000000)) < 0) {
            codeTrancheRevenus = "80";
        }
        else if (montantDesRevenus.compareTo(BigDecimal.valueOf(3000000)) < 0) {
            codeTrancheRevenus = "90";
        }else {
            codeTrancheRevenus = "95";
        }
        return codeTrancheRevenus;
    }
}