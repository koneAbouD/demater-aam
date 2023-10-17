package africa.box.dm.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data @NoArgsConstructor
public class Mineur implements Serializable {
    private final static long serialVersionUID = 1L;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String genre;
    private String nationality;
}
