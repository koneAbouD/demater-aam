package africa.box.dm.db.entities;

import org.springframework.core.io.Resource;

public interface GenerateContrat {
    Resource createContrat(String firstName, String lastName, String filePath);
}
