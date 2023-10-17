package africa.box.dm;

import africa.box.dm.db.entities.CreditCardParameter;

import java.math.BigInteger;

public class CCInsuranceBuilder {
    private String name;
    private String[] features;
    private BigInteger amount;


    private CCInsuranceBuilder() {}

    public static CCInsuranceBuilder anCCInsaurance() {
        return new CCInsuranceBuilder();
    }

    public CCInsuranceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CCInsuranceBuilder withFeatures(String[] features){
        this.features = features;
        return this;
    }

    public CreditCardParameter.CreditCardInsurance build() {
        CreditCardParameter.CreditCardInsurance ccInsurance = new CreditCardParameter.CreditCardInsurance();
        ccInsurance.setName(name);
        ccInsurance.setFeatures(features);

        return ccInsurance;
    }

}
