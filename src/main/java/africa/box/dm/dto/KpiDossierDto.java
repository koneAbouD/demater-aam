package africa.box.dm.dto;

public class KpiDossierDto {
    public String element ;
//    public double montant_total;
    public int nombre_total;

    public KpiDossierDto(String element,  int nombre_total) {
        this.element = element;
//        this.montant_total = montant_total;
        this.nombre_total = nombre_total;
    }

    public KpiDossierDto() {
    }
}
