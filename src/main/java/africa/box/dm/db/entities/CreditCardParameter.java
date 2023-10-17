package africa.box.dm.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "credit_card_parameter")
@Data @NoArgsConstructor
public class CreditCardParameter implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String features;

    private BigInteger amount;

    @ElementCollection
    private List<CreditCardInsurance> possibleInsurance = new ArrayList<>();

    @Lob
    private byte[] picture;


    public void setFeatures(String[] features) {
        this.features = String.join(";",features);
    }

    public String[] getFeatures() {
        return features.split(";");
    }

    @Embeddable
    @Data @NoArgsConstructor
    public static class CreditCardInsurance implements Serializable{
        private final static long serialVersionUID = 1L;

        private String name;
        private String insurancefeatures;
        private BigInteger amount;


        public void setFeatures(String[] features) {
            this.insurancefeatures = String.join(";",features);
        }

        public String[] getFeatures() {
            return insurancefeatures.split(";");
        }

    }
}
