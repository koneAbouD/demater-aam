package africa.box.dm.db.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "applicant_peps")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data @NoArgsConstructor
public class ApplicantPeps extends AbstractAuditing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @NotNull
    private String fullName;

    private LocalDate dateOfBirth;

    private String isoCountrieCode;

    @NotNull
    private String businessKey;

    @NotNull
    @Type(type = "jsonb")
    private Map<String, Object> result;
}
