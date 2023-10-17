package africa.box.dm.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor @AllArgsConstructor
public class ApplicantGood implements Serializable {
    private final static  long serialVersionUID = 1L;

    private String name;
    private String description;


    @Override
    public String toString() {
        return "ApplicantGood{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
