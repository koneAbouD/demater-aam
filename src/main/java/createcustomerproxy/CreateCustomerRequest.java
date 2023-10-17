
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createCustomerRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createCustomerRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="customerType" type="{http://soprabanking.com/amplitude}customerType"/>
 *         &lt;element name="language" type="{http://soprabanking.com/amplitude}languageCode" minOccurs="0"/>
 *         &lt;element name="titleCode" type="{http://soprabanking.com/amplitude}charMax2"/>
 *         &lt;element name="lastName" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *         &lt;element name="nameToReturn" type="{http://soprabanking.com/amplitude}charMax67" minOccurs="0"/>
 *         &lt;element name="freeFieldCode1" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="freeFieldCode2" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="freeFieldCode3" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalIdentifier" type="{http://soprabanking.com/amplitude}charMax25" minOccurs="0"/>
 *         &lt;element name="situation" type="{http://soprabanking.com/amplitude}customerSituationCreate" minOccurs="0"/>
 *         &lt;element name="specificInformation" type="{http://soprabanking.com/amplitude}customerSpecInfoCreate" minOccurs="0"/>
 *         &lt;element name="generalAttributes" type="{http://soprabanking.com/amplitude}customerGeneralAttributesCreate" minOccurs="0"/>
 *         &lt;element name="reportingAttributes" type="{http://soprabanking.com/amplitude}customerReportingAttributesCreate" minOccurs="0"/>
 *         &lt;element name="marketingAttributes" type="{http://soprabanking.com/amplitude}customerMarketingAttributesCreate" minOccurs="0"/>
 *         &lt;element name="fatcaAttributes" type="{http://soprabanking.com/amplitude}customerFatcaAttributesCreate" minOccurs="0"/>
 *         &lt;element name="paymentMethods" type="{http://soprabanking.com/amplitude}customerPaymentMethods" minOccurs="0"/>
 *         &lt;element name="adressesList" type="{http://soprabanking.com/amplitude}customerAddressesCreate" minOccurs="0"/>
 *         &lt;element name="phoneNumbersList" type="{http://soprabanking.com/amplitude}customerPhoneNumbersCreate" minOccurs="0"/>
 *         &lt;element name="emailAdressesList" type="{http://soprabanking.com/amplitude}customerEmailAddressesCreate" minOccurs="0"/>
 *         &lt;element name="contactsList" type="{http://soprabanking.com/amplitude}modifyCustomerContactsRequest" minOccurs="0"/>
 *         &lt;element name="customerProfile" type="{http://soprabanking.com/amplitude}createCustomerProfile" minOccurs="0"/>
 *         &lt;element name="customerAsset" type="{http://soprabanking.com/amplitude}modifyCustomerAssetRequest" minOccurs="0"/>
 *         &lt;element name="idPapersList" type="{http://soprabanking.com/amplitude}customerIdPapersCreate" minOccurs="0"/>
 *         &lt;element name="documentsList" type="{http://soprabanking.com/amplitude}modifyCustomerDocumentsRequest" minOccurs="0"/>
 *         &lt;element name="internationalOperationsList" type="{http://soprabanking.com/amplitude}modifyCustomerInternationalOperationsRequest" minOccurs="0"/>
 *         &lt;element name="defaultCustomer" type="{http://soprabanking.com/amplitude}customerDefaultCustomer" minOccurs="0"/>
 *         &lt;element name="kpp" type="{http://soprabanking.com/amplitude}customerKpp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerRequest", propOrder = {
    "customerCode",
    "customerType",
    "language",
    "titleCode",
    "lastName",
    "nameToReturn",
    "freeFieldCode1",
    "freeFieldCode2",
    "freeFieldCode3",
    "memo",
    "externalIdentifier",
    "situation",
    "specificInformation",
    "generalAttributes",
    "reportingAttributes",
    "marketingAttributes",
    "fatcaAttributes",
    "paymentMethods",
    "adressesList",
    "phoneNumbersList",
    "emailAdressesList",
    "contactsList",
    "customerProfile",
    "customerAsset",
    "idPapersList",
    "documentsList",
    "internationalOperationsList",
    "defaultCustomer",
    "kpp"
})
public class CreateCustomerRequest {

    protected String customerCode;
    @XmlElement(required = true)
    protected String customerType;
    protected String language;
    @XmlElement(required = true)
    protected String titleCode;
    protected String lastName;
    protected String nameToReturn;
    protected String freeFieldCode1;
    protected String freeFieldCode2;
    protected String freeFieldCode3;
    protected String memo;
    protected String externalIdentifier;
    protected CustomerSituationCreate situation;
    protected CustomerSpecInfoCreate specificInformation;
    protected CustomerGeneralAttributesCreate generalAttributes;
    protected CustomerReportingAttributesCreate reportingAttributes;
    protected CustomerMarketingAttributesCreate marketingAttributes;
    protected CustomerFatcaAttributesCreate fatcaAttributes;
    protected CustomerPaymentMethods paymentMethods;
    protected CustomerAddressesCreate adressesList;
    protected CustomerPhoneNumbersCreate phoneNumbersList;
    protected CustomerEmailAddressesCreate emailAdressesList;
    protected ModifyCustomerContactsRequest contactsList;
    protected CreateCustomerProfile customerProfile;
    protected ModifyCustomerAssetRequest customerAsset;
    protected CustomerIdPapersCreate idPapersList;
    protected ModifyCustomerDocumentsRequest documentsList;
    protected ModifyCustomerInternationalOperationsRequest internationalOperationsList;
    protected CustomerDefaultCustomer defaultCustomer;
    protected CustomerKpp kpp;

    /**
     * Obtient la valeur de la propri�t� customerCode.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * D�finit la valeur de la propri�t� customerCode.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� customerType.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * D�finit la valeur de la propri�t� customerType.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * Obtient la valeur de la propri�t� language.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLanguage() {
        return language;
    }

    /**
     * D�finit la valeur de la propri�t� language.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Obtient la valeur de la propri�t� titleCode.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitleCode() {
        return titleCode;
    }

    /**
     * D�finit la valeur de la propri�t� titleCode.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitleCode(String value) {
        this.titleCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� lastName.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * D�finit la valeur de la propri�t� lastName.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Obtient la valeur de la propri�t� nameToReturn.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNameToReturn() {
        return nameToReturn;
    }

    /**
     * D�finit la valeur de la propri�t� nameToReturn.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNameToReturn(String value) {
        this.nameToReturn = value;
    }

    /**
     * Obtient la valeur de la propri�t� freeFieldCode1.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFreeFieldCode1() {
        return freeFieldCode1;
    }

    /**
     * D�finit la valeur de la propri�t� freeFieldCode1.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFreeFieldCode1(String value) {
        this.freeFieldCode1 = value;
    }

    /**
     * Obtient la valeur de la propri�t� freeFieldCode2.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFreeFieldCode2() {
        return freeFieldCode2;
    }

    /**
     * D�finit la valeur de la propri�t� freeFieldCode2.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFreeFieldCode2(String value) {
        this.freeFieldCode2 = value;
    }

    /**
     * Obtient la valeur de la propri�t� freeFieldCode3.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFreeFieldCode3() {
        return freeFieldCode3;
    }

    /**
     * D�finit la valeur de la propri�t� freeFieldCode3.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFreeFieldCode3(String value) {
        this.freeFieldCode3 = value;
    }

    /**
     * Obtient la valeur de la propri�t� memo.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMemo() {
        return memo;
    }

    /**
     * D�finit la valeur de la propri�t� memo.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMemo(String value) {
        this.memo = value;
    }

    /**
     * Obtient la valeur de la propri�t� externalIdentifier.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    /**
     * D�finit la valeur de la propri�t� externalIdentifier.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExternalIdentifier(String value) {
        this.externalIdentifier = value;
    }

    /**
     * Obtient la valeur de la propri�t� situation.
     *
     * @return
     *     possible object is
     *     {@link CustomerSituationCreate }
     *
     */
    public CustomerSituationCreate getSituation() {
        return situation;
    }

    /**
     * D�finit la valeur de la propri�t� situation.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerSituationCreate }
     *
     */
    public void setSituation(CustomerSituationCreate value) {
        this.situation = value;
    }

    /**
     * Obtient la valeur de la propri�t� specificInformation.
     *
     * @return
     *     possible object is
     *     {@link CustomerSpecInfoCreate }
     *
     */
    public CustomerSpecInfoCreate getSpecificInformation() {
        return specificInformation;
    }

    /**
     * D�finit la valeur de la propri�t� specificInformation.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerSpecInfoCreate }
     *
     */
    public void setSpecificInformation(CustomerSpecInfoCreate value) {
        this.specificInformation = value;
    }

    /**
     * Obtient la valeur de la propri�t� generalAttributes.
     *
     * @return
     *     possible object is
     *     {@link CustomerGeneralAttributesCreate }
     *
     */
    public CustomerGeneralAttributesCreate getGeneralAttributes() {
        return generalAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� generalAttributes.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerGeneralAttributesCreate }
     *
     */
    public void setGeneralAttributes(CustomerGeneralAttributesCreate value) {
        this.generalAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� reportingAttributes.
     *
     * @return
     *     possible object is
     *     {@link CustomerReportingAttributesCreate }
     *
     */
    public CustomerReportingAttributesCreate getReportingAttributes() {
        return reportingAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� reportingAttributes.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerReportingAttributesCreate }
     *
     */
    public void setReportingAttributes(CustomerReportingAttributesCreate value) {
        this.reportingAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� marketingAttributes.
     *
     * @return
     *     possible object is
     *     {@link CustomerMarketingAttributesCreate }
     *
     */
    public CustomerMarketingAttributesCreate getMarketingAttributes() {
        return marketingAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� marketingAttributes.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerMarketingAttributesCreate }
     *
     */
    public void setMarketingAttributes(CustomerMarketingAttributesCreate value) {
        this.marketingAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� fatcaAttributes.
     *
     * @return
     *     possible object is
     *     {@link CustomerFatcaAttributesCreate }
     *
     */
    public CustomerFatcaAttributesCreate getFatcaAttributes() {
        return fatcaAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� fatcaAttributes.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerFatcaAttributesCreate }
     *
     */
    public void setFatcaAttributes(CustomerFatcaAttributesCreate value) {
        this.fatcaAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� paymentMethods.
     *
     * @return
     *     possible object is
     *     {@link CustomerPaymentMethods }
     *
     */
    public CustomerPaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * D�finit la valeur de la propri�t� paymentMethods.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentMethods }
     *
     */
    public void setPaymentMethods(CustomerPaymentMethods value) {
        this.paymentMethods = value;
    }

    /**
     * Obtient la valeur de la propri�t� adressesList.
     *
     * @return
     *     possible object is
     *     {@link CustomerAddressesCreate }
     *
     */
    public CustomerAddressesCreate getAdressesList() {
        return adressesList;
    }

    /**
     * D�finit la valeur de la propri�t� adressesList.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerAddressesCreate }
     *
     */
    public void setAdressesList(CustomerAddressesCreate value) {
        this.adressesList = value;
    }

    /**
     * Obtient la valeur de la propri�t� phoneNumbersList.
     *
     * @return
     *     possible object is
     *     {@link CustomerPhoneNumbersCreate }
     *
     */
    public CustomerPhoneNumbersCreate getPhoneNumbersList() {
        return phoneNumbersList;
    }

    /**
     * D�finit la valeur de la propri�t� phoneNumbersList.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerPhoneNumbersCreate }
     *
     */
    public void setPhoneNumbersList(CustomerPhoneNumbersCreate value) {
        this.phoneNumbersList = value;
    }

    /**
     * Obtient la valeur de la propri�t� emailAdressesList.
     *
     * @return
     *     possible object is
     *     {@link CustomerEmailAddressesCreate }
     *
     */
    public CustomerEmailAddressesCreate getEmailAdressesList() {
        return emailAdressesList;
    }

    /**
     * D�finit la valeur de la propri�t� emailAdressesList.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerEmailAddressesCreate }
     *
     */
    public void setEmailAdressesList(CustomerEmailAddressesCreate value) {
        this.emailAdressesList = value;
    }

    /**
     * Obtient la valeur de la propri�t� contactsList.
     *
     * @return
     *     possible object is
     *     {@link ModifyCustomerContactsRequest }
     *
     */
    public ModifyCustomerContactsRequest getContactsList() {
        return contactsList;
    }

    /**
     * D�finit la valeur de la propri�t� contactsList.
     *
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerContactsRequest }
     *
     */
    public void setContactsList(ModifyCustomerContactsRequest value) {
        this.contactsList = value;
    }

    /**
     * Obtient la valeur de la propri�t� customerProfile.
     *
     * @return
     *     possible object is
     *     {@link CreateCustomerProfile }
     *
     */
    public CreateCustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    /**
     * D�finit la valeur de la propri�t� customerProfile.
     *
     * @param value
     *     allowed object is
     *     {@link CreateCustomerProfile }
     *
     */
    public void setCustomerProfile(CreateCustomerProfile value) {
        this.customerProfile = value;
    }

    /**
     * Obtient la valeur de la propri�t� customerAsset.
     *
     * @return
     *     possible object is
     *     {@link ModifyCustomerAssetRequest }
     *
     */
    public ModifyCustomerAssetRequest getCustomerAsset() {
        return customerAsset;
    }

    /**
     * D�finit la valeur de la propri�t� customerAsset.
     *
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerAssetRequest }
     *
     */
    public void setCustomerAsset(ModifyCustomerAssetRequest value) {
        this.customerAsset = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPapersList.
     *
     * @return
     *     possible object is
     *     {@link CustomerIdPapersCreate }
     *
     */
    public CustomerIdPapersCreate getIdPapersList() {
        return idPapersList;
    }

    /**
     * D�finit la valeur de la propri�t� idPapersList.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerIdPapersCreate }
     *
     */
    public void setIdPapersList(CustomerIdPapersCreate value) {
        this.idPapersList = value;
    }

    /**
     * Obtient la valeur de la propri�t� documentsList.
     *
     * @return
     *     possible object is
     *     {@link ModifyCustomerDocumentsRequest }
     *
     */
    public ModifyCustomerDocumentsRequest getDocumentsList() {
        return documentsList;
    }

    /**
     * D�finit la valeur de la propri�t� documentsList.
     *
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerDocumentsRequest }
     *
     */
    public void setDocumentsList(ModifyCustomerDocumentsRequest value) {
        this.documentsList = value;
    }

    /**
     * Obtient la valeur de la propri�t� internationalOperationsList.
     *
     * @return
     *     possible object is
     *     {@link ModifyCustomerInternationalOperationsRequest }
     *
     */
    public ModifyCustomerInternationalOperationsRequest getInternationalOperationsList() {
        return internationalOperationsList;
    }

    /**
     * D�finit la valeur de la propri�t� internationalOperationsList.
     *
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerInternationalOperationsRequest }
     *
     */
    public void setInternationalOperationsList(ModifyCustomerInternationalOperationsRequest value) {
        this.internationalOperationsList = value;
    }

    /**
     * Obtient la valeur de la propri�t� defaultCustomer.
     *
     * @return
     *     possible object is
     *     {@link CustomerDefaultCustomer }
     *
     */
    public CustomerDefaultCustomer getDefaultCustomer() {
        return defaultCustomer;
    }

    /**
     * D�finit la valeur de la propri�t� defaultCustomer.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerDefaultCustomer }
     *
     */
    public void setDefaultCustomer(CustomerDefaultCustomer value) {
        this.defaultCustomer = value;
    }

    /**
     * Obtient la valeur de la propri�t� kpp.
     *
     * @return
     *     possible object is
     *     {@link CustomerKpp }
     *
     */
    public CustomerKpp getKpp() {
        return kpp;
    }

    /**
     * D�finit la valeur de la propri�t� kpp.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerKpp }
     *
     */
    public void setKpp(CustomerKpp value) {
        this.kpp = value;
    }

}
