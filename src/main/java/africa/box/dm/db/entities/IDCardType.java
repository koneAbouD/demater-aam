package africa.box.dm.db.entities;

public enum IDCardType {
    CNI("CNI"), PASSEPORT("PASSEPORT"), PERMIS_CONDUIRE("PERMIS DE CONDUIRE"),
    ATTESTATION("ATTESTATION"), CARTE_CONSULAIRE("CARTE CONSULAIRE");

    private final String type;

    private IDCardType(String type){
        this.type = type;
    }
}
