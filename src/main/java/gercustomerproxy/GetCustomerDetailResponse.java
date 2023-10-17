
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCustomerDetailResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomerDetailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *         &lt;element name="customerType" type="{http://soprabanking.com/amplitude}customerType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://soprabanking.com/amplitude}language" minOccurs="0"/>
 *         &lt;element name="titleCode" type="{http://soprabanking.com/amplitude}titleCode" minOccurs="0"/>
 *         &lt;element name="lastname" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *         &lt;element name="nameToReturn" type="{http://soprabanking.com/amplitude}charMax67" minOccurs="0"/>
 *         &lt;element name="abbreviation" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="freeFieldCode1" type="{http://soprabanking.com/amplitude}customerFreeField1" minOccurs="0"/>
 *         &lt;element name="freeFieldCode2" type="{http://soprabanking.com/amplitude}customerFreeField2" minOccurs="0"/>
 *         &lt;element name="freeFieldCode3" type="{http://soprabanking.com/amplitude}customerFreeField3" minOccurs="0"/>
 *         &lt;element name="externalIdentifier" type="{http://soprabanking.com/amplitude}charMax25" minOccurs="0"/>
 *         &lt;element name="situation" type="{http://soprabanking.com/amplitude}customerSituation" minOccurs="0"/>
 *         &lt;element name="fatca" type="{http://soprabanking.com/amplitude}customerFatca" minOccurs="0"/>
 *         &lt;element name="specificInformation" type="{http://soprabanking.com/amplitude}customerSpecInfo" minOccurs="0"/>
 *         &lt;element name="generalAttributes" type="{http://soprabanking.com/amplitude}customerGeneralAttributes" minOccurs="0"/>
 *         &lt;element name="reportingAttributes" type="{http://soprabanking.com/amplitude}customerReportingAttributes" minOccurs="0"/>
 *         &lt;element name="paymentMethods" type="{http://soprabanking.com/amplitude}customerPaymentMethods" minOccurs="0"/>
 *         &lt;element name="additionnalInformation" type="{http://soprabanking.com/amplitude}customerAdditionalInformation" minOccurs="0"/>
 *         &lt;element name="addressesDetail" type="{http://soprabanking.com/amplitude}getCustomerAddressDetailResponse" minOccurs="0"/>
 *         &lt;element name="phoneNumbers" type="{http://soprabanking.com/amplitude}getCustomerPhoneNumberListResponse" minOccurs="0"/>
 *         &lt;element name="emailAdresses" type="{http://soprabanking.com/amplitude}getCustomerEmailAddressListResponse" minOccurs="0"/>
 *         &lt;element name="freeAttributesDetail" type="{http://soprabanking.com/amplitude}customerFreeAttributesDetail" minOccurs="0"/>
 *         &lt;element name="activeProfile" type="{http://soprabanking.com/amplitude}getCustomerActiveProfileResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerDetailResponse", propOrder = {
    "customerCode",
    "customerType",
    "language",
    "titleCode",
    "lastname",
    "nameToReturn",
    "abbreviation",
    "freeFieldCode1",
    "freeFieldCode2",
    "freeFieldCode3",
    "externalIdentifier",
    "situation",
    "fatca",
    "specificInformation",
    "generalAttributes",
    "reportingAttributes",
    "paymentMethods",
    "additionnalInformation",
    "addressesDetail",
    "phoneNumbers",
    "emailAdresses",
    "freeAttributesDetail",
    "activeProfile"
})
public class GetCustomerDetailResponse {

    protected String customerCode;
    protected String customerType;
    protected Language language;
    protected TitleCode titleCode;
    protected String lastname;
    protected String nameToReturn;
    protected String abbreviation;
    protected CustomerFreeField1 freeFieldCode1;
    protected CustomerFreeField2 freeFieldCode2;
    protected CustomerFreeField3 freeFieldCode3;
    protected String externalIdentifier;
    protected CustomerSituation situation;
    protected CustomerFatca fatca;
    protected CustomerSpecInfo specificInformation;
    protected CustomerGeneralAttributes generalAttributes;
    protected CustomerReportingAttributes reportingAttributes;
    protected CustomerPaymentMethods paymentMethods;
    protected CustomerAdditionalInformation additionnalInformation;
    protected GetCustomerAddressDetailResponse addressesDetail;
    protected GetCustomerPhoneNumberListResponse phoneNumbers;
    protected GetCustomerEmailAddressListResponse emailAdresses;
    protected CustomerFreeAttributesDetail freeAttributesDetail;
    protected GetCustomerActiveProfileResponse activeProfile;

    /**
     * Obtient la valeur de la propriété customerCode.
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
     * Définit la valeur de la propriété customerCode.
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
     * Obtient la valeur de la propriété customerType.
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
     * Définit la valeur de la propriété customerType.
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
     * Obtient la valeur de la propriété language.
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Définit la valeur de la propriété language.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setLanguage(Language value) {
        this.language = value;
    }

    /**
     * Obtient la valeur de la propriété titleCode.
     * 
     * @return
     *     possible object is
     *     {@link TitleCode }
     *     
     */
    public TitleCode getTitleCode() {
        return titleCode;
    }

    /**
     * Définit la valeur de la propriété titleCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleCode }
     *     
     */
    public void setTitleCode(TitleCode value) {
        this.titleCode = value;
    }

    /**
     * Obtient la valeur de la propriété lastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Définit la valeur de la propriété lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Obtient la valeur de la propriété nameToReturn.
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
     * Définit la valeur de la propriété nameToReturn.
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
     * Obtient la valeur de la propriété abbreviation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Définit la valeur de la propriété abbreviation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbreviation(String value) {
        this.abbreviation = value;
    }

    /**
     * Obtient la valeur de la propriété freeFieldCode1.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeField1 }
     *     
     */
    public CustomerFreeField1 getFreeFieldCode1() {
        return freeFieldCode1;
    }

    /**
     * Définit la valeur de la propriété freeFieldCode1.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeField1 }
     *     
     */
    public void setFreeFieldCode1(CustomerFreeField1 value) {
        this.freeFieldCode1 = value;
    }

    /**
     * Obtient la valeur de la propriété freeFieldCode2.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeField2 }
     *     
     */
    public CustomerFreeField2 getFreeFieldCode2() {
        return freeFieldCode2;
    }

    /**
     * Définit la valeur de la propriété freeFieldCode2.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeField2 }
     *     
     */
    public void setFreeFieldCode2(CustomerFreeField2 value) {
        this.freeFieldCode2 = value;
    }

    /**
     * Obtient la valeur de la propriété freeFieldCode3.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeField3 }
     *     
     */
    public CustomerFreeField3 getFreeFieldCode3() {
        return freeFieldCode3;
    }

    /**
     * Définit la valeur de la propriété freeFieldCode3.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeField3 }
     *     
     */
    public void setFreeFieldCode3(CustomerFreeField3 value) {
        this.freeFieldCode3 = value;
    }

    /**
     * Obtient la valeur de la propriété externalIdentifier.
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
     * Définit la valeur de la propriété externalIdentifier.
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
     * Obtient la valeur de la propriété situation.
     * 
     * @return
     *     possible object is
     *     {@link CustomerSituation }
     *     
     */
    public CustomerSituation getSituation() {
        return situation;
    }

    /**
     * Définit la valeur de la propriété situation.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSituation }
     *     
     */
    public void setSituation(CustomerSituation value) {
        this.situation = value;
    }

    /**
     * Obtient la valeur de la propriété fatca.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFatca }
     *     
     */
    public CustomerFatca getFatca() {
        return fatca;
    }

    /**
     * Définit la valeur de la propriété fatca.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFatca }
     *     
     */
    public void setFatca(CustomerFatca value) {
        this.fatca = value;
    }

    /**
     * Obtient la valeur de la propriété specificInformation.
     * 
     * @return
     *     possible object is
     *     {@link CustomerSpecInfo }
     *     
     */
    public CustomerSpecInfo getSpecificInformation() {
        return specificInformation;
    }

    /**
     * Définit la valeur de la propriété specificInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSpecInfo }
     *     
     */
    public void setSpecificInformation(CustomerSpecInfo value) {
        this.specificInformation = value;
    }

    /**
     * Obtient la valeur de la propriété generalAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerGeneralAttributes }
     *     
     */
    public CustomerGeneralAttributes getGeneralAttributes() {
        return generalAttributes;
    }

    /**
     * Définit la valeur de la propriété generalAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerGeneralAttributes }
     *     
     */
    public void setGeneralAttributes(CustomerGeneralAttributes value) {
        this.generalAttributes = value;
    }

    /**
     * Obtient la valeur de la propriété reportingAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerReportingAttributes }
     *     
     */
    public CustomerReportingAttributes getReportingAttributes() {
        return reportingAttributes;
    }

    /**
     * Définit la valeur de la propriété reportingAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerReportingAttributes }
     *     
     */
    public void setReportingAttributes(CustomerReportingAttributes value) {
        this.reportingAttributes = value;
    }

    /**
     * Obtient la valeur de la propriété paymentMethods.
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
     * Définit la valeur de la propriété paymentMethods.
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
     * Obtient la valeur de la propriété additionnalInformation.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAdditionalInformation }
     *     
     */
    public CustomerAdditionalInformation getAdditionnalInformation() {
        return additionnalInformation;
    }

    /**
     * Définit la valeur de la propriété additionnalInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAdditionalInformation }
     *     
     */
    public void setAdditionnalInformation(CustomerAdditionalInformation value) {
        this.additionnalInformation = value;
    }

    /**
     * Obtient la valeur de la propriété addressesDetail.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerAddressDetailResponse }
     *     
     */
    public GetCustomerAddressDetailResponse getAddressesDetail() {
        return addressesDetail;
    }

    /**
     * Définit la valeur de la propriété addressesDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerAddressDetailResponse }
     *     
     */
    public void setAddressesDetail(GetCustomerAddressDetailResponse value) {
        this.addressesDetail = value;
    }

    /**
     * Obtient la valeur de la propriété phoneNumbers.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerPhoneNumberListResponse }
     *     
     */
    public GetCustomerPhoneNumberListResponse getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Définit la valeur de la propriété phoneNumbers.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerPhoneNumberListResponse }
     *     
     */
    public void setPhoneNumbers(GetCustomerPhoneNumberListResponse value) {
        this.phoneNumbers = value;
    }

    /**
     * Obtient la valeur de la propriété emailAdresses.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerEmailAddressListResponse }
     *     
     */
    public GetCustomerEmailAddressListResponse getEmailAdresses() {
        return emailAdresses;
    }

    /**
     * Définit la valeur de la propriété emailAdresses.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerEmailAddressListResponse }
     *     
     */
    public void setEmailAdresses(GetCustomerEmailAddressListResponse value) {
        this.emailAdresses = value;
    }

    /**
     * Obtient la valeur de la propriété freeAttributesDetail.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributesDetail }
     *     
     */
    public CustomerFreeAttributesDetail getFreeAttributesDetail() {
        return freeAttributesDetail;
    }

    /**
     * Définit la valeur de la propriété freeAttributesDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributesDetail }
     *     
     */
    public void setFreeAttributesDetail(CustomerFreeAttributesDetail value) {
        this.freeAttributesDetail = value;
    }

    /**
     * Obtient la valeur de la propriété activeProfile.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerActiveProfileResponse }
     *     
     */
    public GetCustomerActiveProfileResponse getActiveProfile() {
        return activeProfile;
    }

    /**
     * Définit la valeur de la propriété activeProfile.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerActiveProfileResponse }
     *     
     */
    public void setActiveProfile(GetCustomerActiveProfileResponse value) {
        this.activeProfile = value;
    }

}
