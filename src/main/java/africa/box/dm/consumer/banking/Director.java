package africa.box.dm.consumer.banking;

import createaccountproxy.AccountCreationType;
import createaccountproxy.CreateAccountRequest;
import createcustomerproxy.CustomerIndividualGeneralInfoCreate;

public class Director {
    private Director() {}
    public static Factory.CreateAccountRequestBuilder createAccountRequestBuilder() {
        return new Factory.CreateAccountRequestBuilder();
    }

    public static Factory.CreateAccoutnTypeBuilder createAccoutnTypeBuilder() {
        return new Factory.CreateAccoutnTypeBuilder();
    }

    public static Factory.FileaccountNatureBuilder createFileAccountNatureBuilder() {
        return new Factory.FileaccountNatureBuilder();
    }


    public static Factory.AccountCustomerBuilder createCustomerBuilder() {
        return new Factory.AccountCustomerBuilder();
    }

    public static Factory.CreateCustomerRequestBuilder createCustomerRequestBuilder() {
        return new Factory.CreateCustomerRequestBuilder();
    }

    public static Factory.CustomerIndividualGeneralInfoBuilder createCustomerIndividualGeneralInfo() {
        return new Factory.CustomerIndividualGeneralInfoBuilder();
    }

    public static Factory.CustomerIndividualInfoBuilder createCustomerIndividualInfo() {
        return new Factory.CustomerIndividualInfoBuilder();
    }

    public static Factory.CustomerReportingAttributesCreateBuilder createCustomerReportingAttributesCreateBuilder() {
        return new Factory.CustomerReportingAttributesCreateBuilder();
    }

    public static Factory.CustomerJointAccountsBuilder createCustomerJointAccountInfo() {
        return new Factory.CustomerJointAccountsBuilder();
    }
    public static Factory.CustomerJointAccountListInfoBuilder createJointAccountsListInfo() {
        return new Factory.CustomerJointAccountListInfoBuilder();
    }
    public static Factory.CustomerAddressesEmailCreateBuilder customerAddressesEmailCreateInfo() {
        return new Factory.CustomerAddressesEmailCreateBuilder();
    }
    public static Factory.CustomerAddressEmailRequestBuilder customerAddressEmailCreateInfo() {
        return new Factory.CustomerAddressEmailRequestBuilder();
    }
}
