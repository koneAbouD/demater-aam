
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountAddress complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� languageCode.
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
     * D�finit la valeur de la propri�t� languageCode.
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
     * Obtient la valeur de la propri�t� addressFormat.
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
     * D�finit la valeur de la propri�t� addressFormat.
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
     * Obtient la valeur de la propri�t� addressLine1.
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
     * D�finit la valeur de la propri�t� addressLine1.
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
     * Obtient la valeur de la propri�t� addressLine2.
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
     * D�finit la valeur de la propri�t� addressLine2.
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
     * Obtient la valeur de la propri�t� addressLine3.
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
     * D�finit la valeur de la propri�t� addressLine3.
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
     * Obtient la valeur de la propri�t� city.
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
     * D�finit la valeur de la propri�t� city.
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
     * Obtient la valeur de la propri�t� postalCode.
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
     * D�finit la valeur de la propri�t� postalCode.
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
     * Obtient la valeur de la propri�t� deliveryOffice.
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
     * D�finit la valeur de la propri�t� deliveryOffice.
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
     * Obtient la valeur de la propri�t� postalBox.
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
     * D�finit la valeur de la propri�t� postalBox.
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
     * Obtient la valeur de la propri�t� postalSector.
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
     * D�finit la valeur de la propri�t� postalSector.
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
     * Obtient la valeur de la propri�t� postalSectorDesignation.
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
     * D�finit la valeur de la propri�t� postalSectorDesignation.
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
     * Obtient la valeur de la propri�t� countryCode.
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
     * D�finit la valeur de la propri�t� countryCode.
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
     * Obtient la valeur de la propri�t� branchCode.
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
     * D�finit la valeur de la propri�t� branchCode.
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
     * Obtient la valeur de la propri�t� locker.
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
     * D�finit la valeur de la propri�t� locker.
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
     * Obtient la valeur de la propri�t� serviceCode.
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
     * D�finit la valeur de la propri�t� serviceCode.
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
     * Obtient la valeur de la propri�t� transportTypeCode.
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
     * D�finit la valeur de la propri�t� transportTypeCode.
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
     * Obtient la valeur de la propri�t� emailAddress.
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
     * D�finit la valeur de la propri�t� emailAddress.
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
     * Obtient la valeur de la propri�t� geographicalDepartment.
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
     * D�finit la valeur de la propri�t� geographicalDepartment.
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
     * Obtient la valeur de la propri�t� county.
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
     * D�finit la valeur de la propri�t� county.
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
