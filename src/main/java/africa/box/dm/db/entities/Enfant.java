package africa.box.dm.db.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.NO_ACTION;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = Enfant.TABLE_NAME)
@Access(AccessType.FIELD)
public class Enfant {
    public static final String TABLE_NAME = "enfant";
    public static final String ID = "_id";
    public static final String SEQ = TABLE_NAME + ID + "_seq";
    public static final String GENERATOR = TABLE_NAME + "_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = SEQ, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String nom;
    private String prenoms;
    private String dateNaissance;
   /* @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "businessKey", nullable = false)
    @OnDelete(action = NO_ACTION)
    private Compte compte;*/
}
