package africa.box.dm.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data @NoArgsConstructor
public class Chequier {
    private final static  long serialVersionUID = 1L;

    private String type;
    private int numberOfPapers;
}
