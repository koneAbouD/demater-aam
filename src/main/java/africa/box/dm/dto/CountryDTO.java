package africa.box.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
public class CountryDTO {
    private String code;
    private String iso;
    private String name;
}
