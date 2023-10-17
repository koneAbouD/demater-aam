package africa.box.dm.db.entities;

import africa.box.dm.utils.DateFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Embeddable
@Data @NoArgsConstructor
public class RegisteredID {
    private final static long serialVersionUID = 1L;

//    @Enumerated(EnumType.STRING)
//    private IDCardType authority;
    private String authority;
    private String number;
    private LocalDate validTo;
    private LocalDate validFrom;
    private String locale;

    public void setValidFrom(LocalDate validFrom){
        if (validTo != null && !validToIsAfterValidFrom(validTo, validFrom) ){
            throw new RuntimeException("La date d émission est incorecte");
        }
        this.validFrom = validFrom;
    }

    public void setValidFrom(String date){
       if (date != null) {
           LocalDate validFrom = DateFormatter.toDate(date.replace("-", "/"));
           if (validTo != null && !validToIsAfterValidFrom(validTo, validFrom) ){
               throw new RuntimeException("La date d émission est incorecte");
           }
           this.validFrom = validFrom;
       }
    }

    public void setValidTo(LocalDate validTo) {
        if (validFrom != null && !validToIsAfterValidFrom(validTo, validFrom) ){
            throw new RuntimeException("La date d expiration est incorecte");
        }

        this.validTo = validTo;
    }

    public void setValidTo(String date) {

       if (date !=null) {
           LocalDate validTo = DateFormatter.toDate(date.replace("-", "/"));
           if (validFrom != null && !validToIsAfterValidFrom(validTo, validFrom) ){
               throw new RuntimeException("La date d expiration est incorecte");
           }
           this.validTo = validTo;
       }
    }

    private boolean validToIsAfterValidFrom(LocalDate validTo,
            LocalDate validFrom) {
        return validTo.isAfter(validFrom);
    }
}
