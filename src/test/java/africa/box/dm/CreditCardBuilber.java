package africa.box.dm;

import africa.box.dm.db.entities.CreditCardParameter;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreditCardBuilber {

    private String name;

    private String[] features;

    private BigInteger amount;

    private List<CreditCardParameter.CreditCardInsurance> possibleInsurance = new ArrayList<>();

    private byte[] picture;

    private CreditCardBuilber() {}

    public static CreditCardBuilber anCreditCard() {
        return new CreditCardBuilber();
    }

    public CreditCardBuilber withInsurances(CreditCardParameter.CreditCardInsurance insurances) {
        this.possibleInsurance.add(insurances);
        return this;
    }

    public CreditCardBuilber withFeatures(String[] features) {
        this.features = features;
        return this;
    }

    public CreditCardBuilber withAmount(BigInteger amount) {
        this.amount = amount;
        return this;
    }

    public CreditCardBuilber withName(String name) {
        this.name = name;
        return this;
    }

    public CreditCardBuilber withPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    public CreditCardParameter build() {
        CreditCardParameter cardParameter = new CreditCardParameter();
        cardParameter.setName(name);
        cardParameter.setPossibleInsurance(possibleInsurance);
        cardParameter.setFeatures(features);
        cardParameter.setAmount(amount);
        cardParameter.setPicture(picture);

        return cardParameter;
    }
}
