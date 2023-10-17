package africa.box.dm.dto;

public class KpiTauxByStatusDto {
    public int nb_element ;
    public int nb_dossier;
    public double taux;

    public KpiTauxByStatusDto(int nb_element, int nb_dossier, double taux) {
        this.nb_element = nb_element;
        this.nb_dossier = nb_dossier;
        this.taux = taux;
    }

    public KpiTauxByStatusDto() {
    }
}
