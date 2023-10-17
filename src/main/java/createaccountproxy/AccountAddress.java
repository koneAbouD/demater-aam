
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountAddress complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="languageCode" type="{http://soprabanking.com/amplitude}languageCode" minOccurs="0"/>
 *         &lt;element name="addressFormat" type="{http://soprabanking.com/amplitude}accountAddressFormat"/>
 *         &lt;element name="addressLine1" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="addressLine3" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="city" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="deliveryOffice" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="postalBox" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="postalSector" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="postalSectorDesignation" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="countryCode" type="{http://soprabanking.com/amplitude}countryCode" minOccurs="0"/>
 *         &lt;element name="branchCode" type="{http://soprabanking.com/amplitude}branchCode" minOccurs="0"/>
 *         &lt;element name="locker" type="{http://soprabanking.com/amplitude}charMax9" minOccurs="0"/>
 *         &lt;element name="serviceCode" type="{http://soprabanking.com/amplitude}charMax4" minOccurs="0"/>
 *         &lt;element name="transportTypeCode" type="{http://soprabanking.com/amplitude}charMax3" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *         &lt;element name="geographicalDepartment" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="county" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountAddress", propOrder = {
    "languageCode",
    "addressFormat",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "city",
    "postalCode",
    "deliveryOffice",
    "postalBox",
    "postalSector",
    "postalSectorDesignation",
    "countryCode",
    "branchCode",
    "locker",
    "serviceCode",
    "transportTypeCode",
    "emailAddress",
    "geographicalDepartment",
    "county"
})
public class AccountAddress {

    protected String languageCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AccountAddressFormat addressFormat;
    protected String addressLine1;
    protected String addressLine2;
    protected String addressLine3;
    protected String city;
    protected String postalCode;
    protected String deliveryOffice;
    protected String postalBox;
    protected String postalSector;
    protected String postalSectorDesignation;
    protected String countryCode;
    protected String branchCode;
    protected String locker;
    protected String serviceCode;
    protected String transportTypeCode;
    protected String emailAddress;
    protected String geographicalDepartment;
    protected String county;

    /**
     * Obtient la valeur de la propriété languageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Définit la valeur de la propriété languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

    /**
     * Obtient la valeur de la propriété addressFormat.
     * 
     * @return
     *     possible object is
     *     {@link AccountAddressFormat }
     *     
     */
    public AccountAddressFormat getAddressFormat() {
        return addressFormat;
    }

    /**
     * Définit la valeur de la propriété addressFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAddressFormat }
     *     
     */
    public void setAddressFormat(AccountAddressFormat value) {
        this.addressFormat = value;
    }

    /**
     * Obtient la valeur de la propriété addressLine1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Définit la valeur de la propriété addressLine1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Obtient la valeur de la propriété addressLine2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Définit la valeur de la propriété addressLine2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Obtient la valeur de la propriété addressLine3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Définit la valeur de la propriété addressLine3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine3(String value) {
        this.addressLine3 = value;
    }

    /**
     * Obtient la valeur de la propriété city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Définit la valeur de la propriété city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Obtient la valeur de la propriété postalCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Définit la valeur de la propriété postalCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Obtient la valeur de la propriété deliveryOffice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryOffice() {
        return deliveryOffice;
    }

    /**
     * Définit la valeur de la propriété deliveryOffice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryOffice(String value) {
        this.deliveryOffice = value;
    }

    /**
     * Obtient la valeur de la propriété postalBox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalBox() {
        return postalBox;
    }

    /**
     * Définit la valeur de la propriété postalBox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalBox(String value) {
        this.postalBox = value;
    }

    /**
     * Obtient la valeur de la propriété postalSector.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalSector() {
        return postalSector;
    }

    /**
     * Définit la valeur de la propriété postalSector.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalSector(String value) {
        this.postalSector = value;
    }

    /**
     * Obtient la valeur de la propriété postalSectorDesignation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalSectorDesignation() {
        return postalSectorDesignation;
    }

    /**
     * Définit la valeur de la propriété postalSectorDesignation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalSectorDesignation(String value) {
        this.postalSectorDesignation = value;
    }

    /**
     * Obtient la valeur de la propriété countryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Définit la valeur de la propriété countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Obtient la valeur de la propriété branchCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Définit la valeur de la propriété branchCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * Obtient la valeur de la propriété locker.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocker() {
        return locker;
    }

    /**
     * Définit la valeur de la propriété locker.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocker(String value) {
        this.locker = value;
    }

    /**
     * Obtient la valeur de la propriété serviceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Définit la valeur de la propriété serviceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Obtient la valeur de la propriété transportTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportTypeCode() {
        return transportTypeCode;
    }

    /**
     * Définit la valeur de la propriété transportTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportTypeCode(String value) {
        this.transportTypeCode = value;
    }

    /**
     * Obtient la valeur de la propriété emailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Définit la valeur de la propriété emailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Obtient la valeur de la propriété geographicalDepartment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeographicalDepartment() {
        return geographicalDepartment;
    }

    /**
     * Définit la valeur de la propriété geographicalDepartment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeographicalDepartment(String value) {
        this.geographicalDepartment = value;
    }

    /**
     * Obtient la valeur de la propriété county.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Définit la valeur de la propriété county.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

}
