package africa.box.dm.consumer.banking;

import createaccountproxy.*;
import createaccountproxy.Periodicity;
import createcustomerproxy.*;
import createcustomerproxy.AdditionalData;
import createcustomerproxy.AdditionalDataValue;
import gercustomerproxy.TerritorialityCode;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Factory {
    private Factory() {}
    public static CreateAccountRequestBuilder anAccountRequest() {
        return Director.createAccountRequestBuilder();
    }
    public static CreateAccoutnTypeBuilder anAccountType() {
        return Director.createAccoutnTypeBuilder();
    }
    public static FileaccountNatureBuilder aFileAccountNature() {
        return Director.createFileAccountNatureBuilder();
    }
    public static AccountCustomerBuilder aCustomer() {
        return Director.createCustomerBuilder();
    }
    public static CreateCustomerRequestBuilder aCustomerRequest() {
        return Director.createCustomerRequestBuilder();
    }
    public static CustomerIndividualGeneralInfoBuilder anIndividualGeneratInfo() {
        return Director.createCustomerIndividualGeneralInfo();
    }
    public static CustomerIndividualInfoBuilder aCustomerIndividualInfo() {
        return Director.createCustomerIndividualInfo();
    }
    public static CustomerReportingAttributesCreateBuilder aReportingAttributes() {
        return Director.createCustomerReportingAttributesCreateBuilder();
    }
    public static CustomerJointAccountsBuilder aCustomerJointAccount() {
        return Director.createCustomerJointAccountInfo();
    }
    public static CustomerJointAccountListInfoBuilder aCustomerJointAccountList() {
        return Director.createJointAccountsListInfo();
    }

    /** Create Account Request Builder */
    public static class CreateAccountRequestBuilder {
        private final CreateAccountRequest accountRequest = new CreateAccountRequest();

        public CreateAccountRequestBuilder branchCode(String branchCode) {
            accountRequest.setBranchCode(branchCode);
            return this;
        }
        public CreateAccountRequestBuilder currencyCode(String currencyCode) {
            accountRequest.setCurrencyCode(currencyCode);
            return this;
        }

        public CreateAccountRequestBuilder customerCode(String customerCode) {
            accountRequest.setCustomerCode(customerCode);
            return this;
        }

        public CreateAccountRequestBuilder accountType(AccountCreationType type) {
            accountRequest.setAccountType(type);
            return this;
        }

        public CreateAccountRequest build() {
            return accountRequest;
        }
    }

    /** Create Account type Builder */
    public static class CreateAccoutnTypeBuilder {
        private AccountCreationType accountType = new AccountCreationType();

        public CreateAccoutnTypeBuilder customerAccount(CustomerAccount account) {
            accountType.setCustomer(account);
            return this;
        }

        public CreateAccoutnTypeBuilder fileAccountNature(FileaccountNature file) {
            accountType.setFile(file);
            return this;
        }

        public CreateAccoutnTypeBuilder customerProduct(String productCode,  String packageCode) {
            Accountproduct product = new Accountproduct();
            product.setProductCode(productCode);
            product.setPackageCode(packageCode);

            accountType.setProduct(product);
            return this;
        }

        public AccountCreationType build() {
            return accountType;
        }
    }

    /** Create file Account Nature */
    public static class FileaccountNatureBuilder {
        private FileaccountNature file = new FileaccountNature();
        public FileaccountNatureBuilder type(String type) {
            file.setFileType(type);
            return this;
        }

        public FileaccountNatureBuilder accountNature(String nature) {
            file.setAccountNature(nature);
            return this;
        }

        public FileaccountNatureBuilder moduleCode(String module) {
            file.setModuleCode(module);
            return this;
        }

        public FileaccountNature build() {
            return file;
        }
    }

    /** Create Account Customer Builder*/
    public static class AccountCustomerBuilder {
        private CustomerAccount customerAccount = new CustomerAccount();

        public AccountCustomerBuilder address(CreateAccountAddressRequest address) {
            customerAccount.setAccountAddress(address);
            return this;
        }

        public AccountCustomerBuilder contact(ModifyAccountContactsRequest contact) {
            customerAccount.setAccountContacts(contact);
            return this;
        }

        public AccountCustomerBuilder title(String title) {
            customerAccount.setAccountTitle(title);
            return this;
        }

        public AccountCustomerBuilder memos(String memos) {
            customerAccount.setAccountMemos(memos);
            return this;
        }
        public AccountCustomerBuilder type(String type) {
            customerAccount.setAccountType(type);
            return this;
        }

        public AccountCustomerBuilder side(AccountSide side) {
            customerAccount.setAccountSide(side);
            return this;
        }
        public AccountCustomerBuilder pledging(Boolean pledging) {
            customerAccount.setAccountPledging(pledging);
            return this;
        }
        public AccountCustomerBuilder emails(AccountEmailAddresses emails) {
            customerAccount.setAccountEmailAddresses(emails);
            return this;
        }
        public AccountCustomerBuilder phones(AccountPhoneNumbers phones) {
            customerAccount.setAccountPhoneNumbers(phones);
            return this;
        }
        public AccountCustomerBuilder freeAttributes(AccountFreeAttributes freeAttributes) {
            customerAccount.setAccountFreeAttributes(freeAttributes);
            return this;
        }
        public AccountCustomerBuilder statementCode(String statementCode) {
            customerAccount.setAccountStatementCode(statementCode);
            return this;
        }
        public AccountCustomerBuilder subjectToDeductionAtSource(BigDecimal subject) {
            customerAccount.setAccountSubjectToDeductionAtSource(subject);
            return this;
        }
        public AccountCustomerBuilder branchThatDeliveredTheChequeBook(String branch) {
            customerAccount.setBranchThatDeliveredTheChequeBook(branch);
            return this;
        }
        public AccountCustomerBuilder SubjectToInterestCalculation(
                AccountSubjectToInterestCalculation subject) {
            customerAccount.setAccountSubjectToInterestCalculation(subject);
            return this;
        }
        public AccountCustomerBuilder statementDeliveryMethod(String method) {
            customerAccount.setAccountStatementDeliveryMethod(method);
            return this;
        }
        public AccountCustomerBuilder directCreditCeiling(BigDecimal credit) {
            customerAccount.setDirectCreditCeiling(credit);
            return this;
        }
        public AccountCustomerBuilder matchingCode(String code) {
            customerAccount.setMatchingCode(code);
            return this;
        }
        public AccountCustomerBuilder thresholdForReorderingCheques(BigDecimal value) {
            customerAccount.setThresholdForReorderingCheques(value);
            return this;
        }
        public AccountCustomerBuilder taxable(Boolean taxable) {
            customerAccount.setTaxableAccount(taxable);
            return this;
        }
        public AccountCustomerBuilder serviceCode(String code) {
            customerAccount.setServiceCode(code);
            return this;
        }
        public AccountCustomerBuilder ncsConstruction(String ncs) {
            customerAccount.setNcsConstruction(ncs);
            return this;
        }
        public AccountCustomerBuilder maturityDate(XMLGregorianCalendar date) {
            customerAccount.setMaturityDate(date);
            return this;
        }
        public AccountCustomerBuilder chequeDeliveryMethod(ChequeBookDeliveryMethod method) {
            customerAccount.setChequeDeliveryMethod(method);
            return this;
        }
        public AccountCustomerBuilder defaultChequeBookType(String type) {
            customerAccount.setDefaultChequeBookType(type);
            return this;
        }
        public AccountCustomerBuilder productCode(String code) {
            customerAccount.setProductCode(code);
            return this;
        }
        public AccountCustomerBuilder accountClassCode(String classCode) {
            customerAccount.setAccountClassCode(classCode);
            return this;
        }

        public AccountCustomerBuilder setCodeForInterestLadderPrinting(
                CodeForInterestLadderPrinting code) {
            customerAccount.setCodeForInterestLadderPrinting(code);
            return this;
        }
        public AccountCustomerBuilder frequencyOfCreditInterestCalculation(Periodicity periodicity) {
            customerAccount.setFrequencyOfCreditInterestCalculation(periodicity);
            return this;
        }
        public AccountCustomerBuilder frequencyOfDebitInterestCalculation(Periodicity periodicity) {
            customerAccount.setFrequencyOfDebitInterestCalculation(periodicity);
            return this;
        }
        public AccountCustomerBuilder accountSubjectToDeductionAtSource(BigDecimal value) {
            customerAccount.setAccountSubjectToDeductionAtSource(value);
            return this;
        }
        public AccountCustomerBuilder accountStatementCode(String value) {
            customerAccount.setAccountStatementCode(value);
            return this;
        }
        public AccountCustomerBuilder accountStatementDeliveryMethod(String value) {
            customerAccount.setAccountStatementDeliveryMethod(value);
            return this;
        }
        public AccountCustomerBuilder responsibleCustomer(String responsible) {
            customerAccount.setResponsibleCustomer(responsible);
            return this;
        }
        public AccountCustomerBuilder chequeBookAddress(
                AccountChequeBookAddress address) {
            customerAccount.setChequeBookAddress(address);
            return this;
        }

        public CustomerAccount build() {
            return customerAccount;
        }
    }

    /** Create Customer request builder */
    public static class CreateCustomerRequestBuilder {

        private CreateCustomerRequest request = new CreateCustomerRequest();
        public CreateCustomerRequestBuilder asset(ModifyCustomerAssetRequest asset) {
            //asset.setAssetHeader(new ModifyCustomerAssetHeader().set);
            request.setCustomerAsset(asset);
            return this;
        }

        public CreateCustomerRequestBuilder contactsList(String customerCode) {
            ModifyCustomerContactsRequest contact = new ModifyCustomerContactsRequest();
            contact.setCustomerCode(customerCode);
            request.setContactsList(contact);
            return this;
        }
        public CreateCustomerRequestBuilder customerType(String value) {
            request.setCustomerType(value);
            return this;
        }
        public CreateCustomerRequestBuilder profile( String profileCode) {
            CreateCustomerProfile profile = new CreateCustomerProfile();
            profile.setProfileCode(profileCode);
            request.setCustomerProfile(profile);
            return this;
        }
        public CreateCustomerRequestBuilder defaultCustomer(
                CustomerNonRetail nonRetail, CustomerRetail retail) {
            CustomerDefaultCustomer defaultCustomer = new CustomerDefaultCustomer();
            defaultCustomer.setNonRetail(nonRetail);
            defaultCustomer.setRetail(retail);
            request.setDefaultCustomer(defaultCustomer);
            return this;
        }
        private  void setDocumentsList() {
            ModifyCustomerDocumentsRequest documents = new ModifyCustomerDocumentsRequest();
        }
        public CreateCustomerRequestBuilder externalIdentifier(String value) {
            request.setExternalIdentifier(value);
            return this;
        }
        public CreateCustomerRequestBuilder fatcaAttributes(CustomerFatcaAttributesCreate fatcaAttributes) {
            request.setFatcaAttributes(fatcaAttributes);
            //fatcaAttributes.set
            return this;
        }
        public CreateCustomerRequestBuilder generalAttributes(
                String branchCode,
                String customerOfficer,
                String qualityCode,
                Boolean taxableCustomer,
                String internalCategoryCode,
                String segment) {
            //attributes.set
            CustomerGeneralAttributesCreate generalAttributes = new CustomerGeneralAttributesCreate();
            generalAttributes.setBranchCode(branchCode);
            generalAttributes.setCustomerOfficer(customerOfficer);
            generalAttributes.setQualityCode(qualityCode);
            generalAttributes.setTaxableCustomer(taxableCustomer);
            generalAttributes.setInternalCategoryCode(internalCategoryCode);
            generalAttributes.setSegment(segment);

            CreateCustomerFreeAttributeRequest attributeRequest = new CreateCustomerFreeAttributeRequest();

            AdditionalData additionalData = new AdditionalData();
            additionalData.setIdentifier("BIC");
            AdditionalDataValue additionalDataValue = new AdditionalDataValue();
            additionalDataValue.setAlphanumeric("O");
            additionalData.setValue(additionalDataValue);
            attributeRequest.setAdditionalData(additionalData);

            CreateCustomerFreeAttributeRequest attributeRequest2 = new CreateCustomerFreeAttributeRequest();
            AdditionalData additionalData2 = new AdditionalData();
            additionalData2.setIdentifier("FLGSURV");
            AdditionalDataValue additionalDataValue2 = new AdditionalDataValue();
            additionalDataValue2.setAlphanumeric("N");
            additionalData2.setValue(additionalDataValue);
            attributeRequest2.setAdditionalData(additionalData2);


            CustomerFreeAttributesCreate attributesCreate = new CustomerFreeAttributesCreate();
            attributesCreate.getFreeAttribute().add(attributeRequest);
            attributesCreate.getFreeAttribute().add(attributeRequest2);

            generalAttributes.setFreeAttributes(attributesCreate);

            request.setGeneralAttributes(generalAttributes);
            return this;
        }
        public CreateCustomerRequestBuilder freeFieldCode1(String code) {
            request.setFreeFieldCode1(code);
            return this;
        }
        public CreateCustomerRequestBuilder freeFieldCode2(String code) {
            request.setFreeFieldCode2(code);
            return this;
        }
        public CreateCustomerRequestBuilder freeFieldCode3(String code) {
            request.setFreeFieldCode3(code);
            return this;
        }
        public void setInternationalOperationsList() {
            ModifyCustomerInternationalOperationsRequest operationsRequest =
                    new ModifyCustomerInternationalOperationsRequest();
            request.setInternationalOperationsList(operationsRequest);
        }
        public CreateCustomerRequestBuilder situation(
                String nationalityCode,
                String countryOfResidence,
                String legalSituation) {
            CustomerSituationCreate situation = new CustomerSituationCreate();
            situation.setLegalSituation(legalSituation);
            situation.setCountryOfResidence(countryOfResidence);
            situation.setNationalityCode(nationalityCode);
            situation.setApplicationDateOfLegalSituation(null);
            request.setSituation(situation);
            return this;
        }
        public CreateCustomerRequestBuilder specificInformation(
                CustomerIndividualSpecInfoCreate individualSpecInfo,
                CustomerCorporateSpecInfoCreate corporateSpecInfo) {

            CustomerSpecInfoCreate specInfo = new CustomerSpecInfoCreate();

            specInfo.setIndividualSpecInfo(individualSpecInfo);
            specInfo.setCorporateSpecInfo(corporateSpecInfo);

            request.setSpecificInformation(specInfo);
            return this;
        }
        public CreateCustomerRequestBuilder language(String value) {
            request.setLanguage(value);
            return this;
        }
        public CreateCustomerRequestBuilder memo(String memo) {
            request.setMemo(memo);
            return this;
        }
        public CreateCustomerRequestBuilder marketingAttributes() {
            CustomerMarketingAttributesCreate marketingAttributes =
                    new CustomerMarketingAttributesCreate();
            marketingAttributes.setFreeAttributes(new CustomerFreeAttributesCreate());
            request.setMarketingAttributes(marketingAttributes);
            return this;
        }
        public CreateCustomerRequestBuilder lastName(String lastName) {
            request.setLastName(lastName);
            return this;
        }
        public CreateCustomerRequestBuilder nameToReturn(String name) {
            request.setNameToReturn(name);
            return this;
        }
        public CreateCustomerRequestBuilder paymentMethods(CustomerPaymentMethods paymentMethods) {
            request.setPaymentMethods(paymentMethods);
            return this;
        }
        public CreateCustomerRequestBuilder reportingAttributes(
                CustomerReportingAttributesCreate attributes) {
            request.setReportingAttributes(attributes);
            return this;
        }

        public CreateCustomerRequestBuilder titleCode(String value) {
            request.setTitleCode(value);
            return this;
        }

        public CreateCustomerRequestBuilder addresses(
                String type,
                String languageCode,
                String addressFormat,
                String addressLine1,
                String addressLine2,
                String addressLine3,
                String city,
                String postalCode,
                String countryCode,
                String emailAddress,
                String country
        ) {
            CustomerAddressesCreate addressesCreate = new CustomerAddressesCreate();

            CreateCustomerAddressRequest addressRequest = new CreateCustomerAddressRequest();
            AddressCreateIdentifier identifier = new AddressCreateIdentifier();
            identifier.setType(type);
            addressRequest.setIdentifier(identifier);
            addressRequest.setLanguageCode(languageCode);
            addressRequest.setAddressFormat(addressFormat);
            addressRequest.setAddressLine1(addressLine1);
            addressRequest.setAddressLine2(addressLine2);
            addressRequest.setAddressLine3(addressLine3);
            addressRequest.setCity(city);
            addressRequest.setPostalCode(postalCode);
            addressRequest.setCountryCode(countryCode);
            addressRequest.setEmailAddress(emailAddress);
            addressRequest.setCounty(country);

            addressesCreate.getAddress().add(addressRequest);
            request.setAdressesList(addressesCreate);
            return this;
        }

        public CreateCustomerRequestBuilder phoneNumbers(String type, String phoneNumber) {
            CustomerPhoneNumbersCreate numbersCreate = new CustomerPhoneNumbersCreate();
            CreateCustomerPhoneNumberRequest numberRequest = new CreateCustomerPhoneNumberRequest();
            PhoneNumberCreateIdentifier identifier = new PhoneNumberCreateIdentifier();
            identifier.setType(type);
            numberRequest.setIdentifier(identifier);
            numberRequest.setPhoneNumber(phoneNumber);
            numberRequest.setFormat("CI1");
            numbersCreate.getPhoneNumber().add(numberRequest);
            request.setPhoneNumbersList(numbersCreate);
            return this;
        }

        public CreateCustomerRequestBuilder emailAddresses(String type, String email) {
            CustomerEmailAddressesCreate addressesCreate = new CustomerEmailAddressesCreate();
            CreateCustomerEmailAddressRequest addressRequest = new CreateCustomerEmailAddressRequest();
            EmailCreateIdentifier identifier = new EmailCreateIdentifier();
            identifier.setType(type);
            addressRequest.setIdentifier(identifier);
            addressRequest.setEmail(email);
            addressesCreate.getEmailAddress().add(addressRequest);
            request.setEmailAdressesList(addressesCreate);
            return this;
        }

        public CreateCustomerRequestBuilder contacts(
                String name,
                String firstName,
                String phoneNumber,
                String emailAddress) {
            ModifyCustomerContactsRequest contactsRequest = new ModifyCustomerContactsRequest();
            CustomerContactInformations contactInformations = new CustomerContactInformations();
            contactInformations.setName(name);
            contactInformations.setFirstName(firstName);
            contactInformations.setPhoneNumber(phoneNumber);
            contactInformations.setEmailAddress(emailAddress);
            contactsRequest.getCustomerContact().add(contactInformations);
            request.setContactsList(contactsRequest);
            return this;
        }

        public CreateCustomerRequestBuilder idPapers(
            String idPaperType,
            String idPaperNumber,
            XMLGregorianCalendar deliveryDate,
            String deliveryPlace,
            String organisationWhichDeliver,
            XMLGregorianCalendar validityDateOfIdPaper
        ) {
            CustomerIdPapersCreate papersCreate = new CustomerIdPapersCreate();
            CreateCustomerIdPaperRequest paperRequest = new CreateCustomerIdPaperRequest();
            paperRequest.setIdPaperType(idPaperType);
            paperRequest.setIdPaperNumber(idPaperNumber);
            paperRequest.setDeliveryDate(deliveryDate);
            paperRequest.setDeliveryPlace(deliveryPlace);
            paperRequest.setOrganisationWhichDeliver(organisationWhichDeliver);
            paperRequest.setValidityDateOfIdPaper(validityDateOfIdPaper);
            papersCreate.getIdPaper().add(paperRequest);
            request.setIdPapersList(papersCreate);
            return this;
        }



        public CreateCustomerRequest build() {

            return request;

        }
    }

    /** Create Customer Individual Info Builder*/
    public static class CustomerIndividualInfoBuilder {
        private CustomerIndividualSpecInfoCreate infos =  new CustomerIndividualSpecInfoCreate()  ;

        public CustomerIndividualInfoBuilder Family(
                String spouseCode, String spouceType,
                Integer numberOfChildren, String familyRelationshipCode) {

            CustomerFamily family = new CustomerFamily();
            family.setSpouseCode(spouseCode);
            family.setSpouseType(spouceType);
            family.setNumberOfChildren(numberOfChildren);
            family.setCustomerFamilyRelationshipCode(familyRelationshipCode);
            infos.setFamily(family);
            return this;
        }

        public CustomerIndividualInfoBuilder individualGeneralInfo(
                CustomerIndividualGeneralInfoCreate individualGeneralInfo) {
            infos.setIndividualGeneralInfo(individualGeneralInfo);
            return this;
        }

        public CustomerIndividualInfoBuilder birth(
                String holderSex,
                XMLGregorianCalendar birthDate,String birthCity, String birthCounty, String birthCountry) {
            CustomerBirthCreate birth = new CustomerBirthCreate();
            birth.setBirthCity(birthCity);
            birth.setBirthCountry(birthCountry);
            birth.setBirthDate(birthDate);
            birth.setHolderSex(holderSex);
            birth.setBirthCounty(birthCounty);

            infos.setBirth(birth);
            return this;
        }

        public CustomerIndividualInfoBuilder idPaper(
                 String type,String number,
                 XMLGregorianCalendar date, String place,
                 String org,
                 XMLGregorianCalendar idPaperValidityDate,
                 String nationalIdentifier
        ) {
            CustomerIdPaperCreate idPaper = new CustomerIdPaperCreate();
            idPaper.setIdPaperNumber(number);
            idPaper.setType(type);
            idPaper.setIdPaperDeliveryDate(date);
            idPaper.setIdPaperDeliveryPlace(place);
            idPaper.setOrganisationWhichDeliver(org);
            idPaper.setIdPaperValidityDate(idPaperValidityDate);
            idPaper.setNationalIdentifier(nationalIdentifier);
            infos.setIdPaper(idPaper);
            return this;
        }

        public CustomerIndividualInfoBuilder territoriality( String territorialityCode){
            CustomerTerritorialityCreate territoriality =  new CustomerTerritorialityCreate();
            territoriality.setTerritorialityCode(territorialityCode);
            infos.setTerritoriality(territoriality);
            return this;
        }

        public CustomerIndividualInfoBuilder otherAttributes(String motherName) {
            CustomerOtherAttributes attributes = new CustomerOtherAttributes();
            attributes.setHolderMotherName(motherName);
            infos.setOtherAttributes(attributes);
            return this;
        }
        /** Customer joint account Info builder */

        public CustomerIndividualInfoBuilder jointAccountsList(ModifyCustomerJointAccountsRequest customerJointAccountsRequest) {

            infos.setJointAccountsList(customerJointAccountsRequest);
            return this;
        }


        public CustomerIndividualInfoBuilder mainCustomerCode(String mainCustomerCode) {
            ModifyCustomerJointAccountsRequest accountsRequest = new ModifyCustomerJointAccountsRequest();
            accountsRequest.setMainCustomerCode(mainCustomerCode);
            infos.setJointAccountsList(accountsRequest);
            return this;
        }

        public CustomerIndividualInfoBuilder customerBudget(String incomeCode, BigDecimal amount, BigDecimal initialAmount) {
            ModifyCustomerBudgetRequest budgetRequest = new ModifyCustomerBudgetRequest();

            ModifyCustomerIncomes modifyCustomerIncomes = new ModifyCustomerIncomes();
            ModifyCustomerIncome customerIncome =  new ModifyCustomerIncome();
            customerIncome.setIncomeCode(incomeCode);
            customerIncome.setAmount(amount);

            modifyCustomerIncomes.getCustomerIncome().add(customerIncome);
            budgetRequest.setCustomerIncomes(modifyCustomerIncomes);

            ModifyCustomerCharges modifyCustomerCharges = new ModifyCustomerCharges();
            ModifyCustomerCharge customerCharge = new ModifyCustomerCharge();
            customerCharge.setAmount(amount);
            customerCharge.setInitialAmount(initialAmount);

            modifyCustomerCharges.getCustomerCharge().add(customerCharge);
            budgetRequest.setCustomerCharges(modifyCustomerCharges);

            infos.setCustomerBudget(budgetRequest);
            return this;
        }

        public CustomerIndividualInfoBuilder professionAndIncomesList(String professionalCode, XMLGregorianCalendar hireDate,String incomesBracketCode) {
            ModifyCustomerProfessionsAndIncomesRequest incomesRequest =
                    new ModifyCustomerProfessionsAndIncomesRequest();

            CustomerProfessionAndIncomesInformations  customerProfessionAndIncomesInformations =
                    new CustomerProfessionAndIncomesInformations();

            customerProfessionAndIncomesInformations.setProfessionCode(professionalCode);
            customerProfessionAndIncomesInformations.setHireDate(hireDate);
            customerProfessionAndIncomesInformations.setIncomesBracketCode(incomesBracketCode);

            incomesRequest.getProfessionAndIncomes().add(customerProfessionAndIncomesInformations);
            infos.setProfessionAndIncomesList(incomesRequest);
            return this;
        }

        public CustomerIndividualSpecInfoCreate build() {
            return infos;
        }
    }

    public static class CustomerJointAccountsBuilder {
        ModifyCustomerJointAccountsRequest customerJointAccountsRequest = new ModifyCustomerJointAccountsRequest();

            public CustomerJointAccountsBuilder mainCustomerCode(String mainCustomerCode) {

                    customerJointAccountsRequest.setMainCustomerCode(mainCustomerCode);
                return this;
            }

            public CustomerJointAccountsBuilder customerJointAccountList (List<CustomerJointAccountInformations> customerJointAccountList) {

                customerJointAccountList.forEach(x -> customerJointAccountsRequest.getCustomerJointAccount().add(x));
                return this;
            }

        public ModifyCustomerJointAccountsRequest build() {
            return customerJointAccountsRequest;
        }

    }

    public static class CustomerJointAccountListInfoBuilder {
        private CustomerJointAccountInformations customerJointAccount =
                new CustomerJointAccountInformations();
        CustomerCoHolderInformations customerCoHolder = new CustomerCoHolderInformations();
        CustomerOrThirdPartyCoHolder customerOrThirdPartyCoHolder = new CustomerOrThirdPartyCoHolder();


        public CustomerJointAccountListInfoBuilder coHolderType(String coHolderType) {

            customerOrThirdPartyCoHolder.setCoHolderType(CustomerOrThirdPartyType.valueOf(coHolderType));
            customerCoHolder.setCustomerOrThirdParty(customerOrThirdPartyCoHolder);

            customerJointAccount.setCoHolderInformations(customerCoHolder);
            return this;
        }

        public CustomerJointAccountListInfoBuilder jointCustomerCode(String JointCustomerCode) {

            customerOrThirdPartyCoHolder.setJointCustomerCode(JointCustomerCode);
            customerCoHolder.setCustomerOrThirdParty(customerOrThirdPartyCoHolder);

            customerJointAccount.setCoHolderInformations(customerCoHolder);
            return this;
        }

        public CustomerJointAccountListInfoBuilder linkTyp(String linkTyp) {
            customerJointAccount.setLinkTyp(LinkTyp.valueOf(linkTyp));
            return this;
        }

        public CustomerJointAccountListInfoBuilder toBePrintedInTheAddress(Boolean toBePrintedInTheAddress) {
            customerJointAccount.setToBePrintedInTheAddress(toBePrintedInTheAddress);
            return this;
        }

        public CustomerJointAccountInformations build() {
            return customerJointAccount;
        }

    }

    /** Customer Individual General Info builder */
    public static class CustomerIndividualGeneralInfoBuilder {
        private CustomerIndividualGeneralInfoCreate generalInfoCreate =
                new CustomerIndividualGeneralInfoCreate();

        public CustomerIndividualGeneralInfoBuilder firstname(String value) {
            generalInfoCreate.setFirstname(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder middlename(String value) {
            generalInfoCreate.setMiddlename(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder thirdname(String value) {
            generalInfoCreate.setThirdname(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder familyStatusCode(String value) {
            generalInfoCreate.setFamilyStatusCode(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder holderLegalCapacity(String value) {
            generalInfoCreate.setHolderLegalCapacity(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder applicationDateOfLegalCapacity(
                XMLGregorianCalendar value) {
            generalInfoCreate.setApplicationDateOfLegalCapacity(value);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder realEstateSituationCode(
                String realEstateSituationCode) {
            generalInfoCreate.setRealEstateSituationCode(realEstateSituationCode);
            return this;
        }

        public CustomerIndividualGeneralInfoBuilder marriageSettlementCode(
                String marriageSettlementCode) {
            generalInfoCreate.setMarriageSettlementCode(marriageSettlementCode);
            return this;
        }

        public CustomerIndividualGeneralInfoCreate build() {
            return generalInfoCreate;
        }
    }

    public static class CustomerReportingAttributesCreateBuilder {
        private CustomerReportingAttributesCreate reportingAttributes =
                new CustomerReportingAttributesCreate();

        public CustomerReportingAttributesCreateBuilder freeAttributes() {
            CustomerFreeAttributesCreate attributesCreate = new CustomerFreeAttributesCreate();


            CreateCustomerFreeAttributeRequest attributeRequest = new CreateCustomerFreeAttributeRequest();

            AdditionalData additionalData = new AdditionalData();
            additionalData.setIdentifier("LIEN");
            AdditionalDataValue additionalDataValue = new AdditionalDataValue();
            additionalDataValue.setAlphanumeric("9");
            additionalData.setValue(additionalDataValue);
            attributeRequest.setAdditionalData(additionalData);

            CreateCustomerFreeAttributeRequest attributeRequest2 = new CreateCustomerFreeAttributeRequest();
            AdditionalData additionalData2 = new AdditionalData();
            additionalData2.setIdentifier("PPE");
            AdditionalDataValue additionalDataValue2 = new AdditionalDataValue();
            additionalDataValue2.setAlphanumeric("0");
            additionalData2.setValue(additionalDataValue2);
            attributeRequest2.setAdditionalData(additionalData2);

            CreateCustomerFreeAttributeRequest attributeRequest3 = new CreateCustomerFreeAttributeRequest();
            AdditionalData additionalData3 = new AdditionalData();
            additionalData3.setIdentifier("REVCLI");
            AdditionalDataValue additionalDataValue3 = new AdditionalDataValue();
            additionalDataValue3.setAmountOrRate(new BigDecimal("1000"));
            additionalData3.setValue(additionalDataValue3);
            attributeRequest3.setAdditionalData(additionalData3);


            CreateCustomerFreeAttributeRequest attributeRequest4 = new CreateCustomerFreeAttributeRequest();
            AdditionalData additionalData4 = new AdditionalData();
            additionalData4.setIdentifier("LBC");
            AdditionalDataValue additionalDataValue4 = new AdditionalDataValue();
            additionalDataValue4.setAlphanumeric("1");
            additionalData4.setValue(additionalDataValue4);
            attributeRequest4.setAdditionalData(additionalData4);


            attributesCreate.getFreeAttribute().add(attributeRequest);
            attributesCreate.getFreeAttribute().add(attributeRequest2);
            attributesCreate.getFreeAttribute().add(attributeRequest3);
            attributesCreate.getFreeAttribute().add(attributeRequest4);


            reportingAttributes.setFreeAttributes(attributesCreate);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder home(String home) {
            reportingAttributes.setDeclaredHome(home);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder economicAgentCode(String economicAgentCode) {
            reportingAttributes.setEconomicAgentCode(economicAgentCode);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder activityFieldCode(String activityFieldCode) {
            reportingAttributes.setActivityFieldCode(activityFieldCode);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder relationshipWithTheBank(String relationshipWithTheBank) {
            reportingAttributes.setRelationshipWithTheBank(relationshipWithTheBank);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder gradingAgreement(String gradingAgreement) {
            reportingAttributes.setGradingAgreement(gradingAgreement);
            return this;
        }

        public CustomerReportingAttributesCreateBuilder creditInfoCentre(
                String customerRelationshipRisk,
                String creditInfoCentreRegistrationNumber,
                String creditInfoCentreCodeToDeclare) {
            CustomerCreditInfoCentreCreate infoCentreCreate = new CustomerCreditInfoCentreCreate();
            infoCentreCreate.setCreditInfoCentreCodeToDeclare(creditInfoCentreCodeToDeclare);
            infoCentreCreate.setCustomerRelationshipRisk(customerRelationshipRisk);
            infoCentreCreate.setCreditInfoCentreRegistrationNumber(creditInfoCentreRegistrationNumber);
            reportingAttributes.setCreditInfoCentre(infoCentreCreate);
            return this;
        }

        public CustomerReportingAttributesCreate build() {
            return reportingAttributes;
        }
    }

}
