package africa.box.dm.dto;

import africa.box.dm.controllers.exceptions.MalformedDateEception;
import africa.box.dm.utils.DateFormatter;
import lombok.Data;
import org.apache.commons.lang3.Validate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

@Data
public class PepsDTO {
    @NotEmpty(message = "businessKey est requis")
    private String businessKey;
    @NotEmpty(message = "name est requis")
    private String name;

    private LocalDate birthDay;

    @Size(min = 2, max = 2, message = "code de pays à deux lettres")
//    @NotEmpty(message = "countryCode est requis")
    private String countryCode;

    public void setBirthDay(String date) {
        if (date !=null) {
            LocalDate birthDay = DateFormatter.toDate(date.replace("-", "/"));
            this.birthDay = birthDay;
        }

    }

    public PepsDTO(){}

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        //Validate.matchesPattern(birthDay, "[0-9]{4}-[0-9]{2}-[0-9]{1,2}", "Formats autorisés yyyy-MM-dd");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
             this.birthDay = sdf.parse(birthDay).toInstant()
                     .atZone(ZoneId.systemDefault()).toLocalDate();
        }catch (Exception ex){
            throw new MalformedDateEception("Formats autorisés yyyy | yyyy-MM | yyyy-MM-dd");
        }
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }*/
}
