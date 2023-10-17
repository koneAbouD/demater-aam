package africa.box.dm.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor
public class CarteBancaire implements Serializable {
    private final static long serialVersionUID = 1L;

    @NotNull
    private CreditCardType type;

    @Enumerated(EnumType.STRING)
    private CreditCardOption insuranceOption;

    public void setInsuranceOption(CreditCardOption option) {
        if (option != null && !type.canHaveInsurance()){
            throw new CarteBancaireInsuranceNotAllowed(
                    type.toString() + " n'a pas d'assurance"
            );
        }

        this.insuranceOption = option;
    }


    @Override
    public String toString() {
        return "CarteBancaire{" +
                "type=" + type +
                ", insuranceOption='" + insuranceOption + '\'' +
                '}';
    }
}
