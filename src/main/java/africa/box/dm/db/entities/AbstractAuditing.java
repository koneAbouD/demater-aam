package africa.box.dm.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@Data @NoArgsConstructor
public abstract class AbstractAuditing {

    private Instant createdDate = Instant.now();
    private String CreatedBy;
    private Instant lastUpdatedDate;
    private String lastUpdatedBy;

}
