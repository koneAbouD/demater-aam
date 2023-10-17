package africa.box.dm.db.entities;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pays {
    private final static long serialVersionUID = 1L;
    private String code;
    private String sigl;
    private String name;
    private String nationalite;

    public Pays(String code, String nationalite) {
        this.code = code;
        this.nationalite = nationalite;
    }
}
