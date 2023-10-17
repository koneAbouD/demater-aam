package africa.box.dm.dto;

import java.util.Date;

public class KpiTempsTraitementDto {
    public String businesskey ;
    public Date created_at;
    public Date ended_at;
    public double nb_minute;

    public KpiTempsTraitementDto(String businesskey, Date created_at, Date ended_at, double nb_minute) {
        this.businesskey = businesskey;
        this.created_at = created_at;
        this.ended_at = ended_at;
        this.nb_minute = nb_minute;
    }

    public KpiTempsTraitementDto() {
    }
}
