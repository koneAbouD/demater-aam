
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerAddressDetail complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerAddressDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://soprabanking.com/amplitude}customerAddressDetailIdentifier"/>
 *         &lt;element name="language" type="{http://soprabanking.com/amplitude}language" minOccurs="0"/>
 *         &lt;element name="addressFormat" type="{http://soprabanking.com/amplitude}addressFormat" minOccurs="0"/>
 *         &lt;element name="addressLine1" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="addressLine3" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="city" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="deliveryOffice" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="poBox" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="postalSector" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="postalSectorDesignation" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="countryCode" type="{http://soprabanking.com/amplitude}country" minOccurs="0"/>
 *         &lt;element name="counterCode" type="{http://soprabanking.com/amplitude}branch" minOccurs="0"/>
 *         &lt;element name="locker" type="{http://soprabanking.com/amplitude}charMax9" minOccurs="0"/>
 *         &lt;element name="service" type="{http://soprabanking.com/amplitude}service" minOccurs="0"/>
 *         &lt;element name="typeOfTransportCode" type="{http://soprabanking.com/amplitude}typeOfTransport" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *         &lt;element name="startingDateOfTemporaryAddress" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="endingDateOfTemporaryAddress" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="numberOfReturnMailsForWrongAddress" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dateOfFirstReturnMailForWrongAddress" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="county" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="region" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAddressDetail", propOrder = {
    "identifier",
    "language",
    "addressFormat",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "city",
    "postalCode",
    "deliveryOffice",
    "poBox",
    "postalSector",
    "postalSectorDesignation",
    "countryCode",
    "counterCode",
    "locker",
    "service",
    "typeOfTransportCode",
    "emailAddress",
    "startingDateOfTemporaryAddress",
    "endingDateOfTemporaryAddress",
    "numberOfReturnMailsForWrongAddress",
    "dateOfFirstReturnMailForWrongAddress",
    "county",
    "region"
})
public class CustomerAddressDetail {

    @XmlElement(required = true)
    protected CustomerAddressDetailIdentifier identifier;
    protected Language language;
    protected AddressFormat addressFormat;
    protected String addressLine1;
    protected String addressLine2;
    protected String addressLine3;
    protected String city;
    protected String postalCode;
    protected String deliveryOffice;
    protected String poBox;
    protected String postalSector;
    protected String postalSectorDesignation;
    protected Country countryCode;
    protected Branch counterCode;
    protected String locker;
    protected Service service;
    protected TypeOfTransport typeOfTransportCode;
    protected String emailAddress;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startingDateOfTemporaryAddress;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endingDateOfTemporaryAddress;
    protected Integer numberOfReturnMailsForWrongAddress;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfFirstReturnMailForWrongAddress;
    protected String county;
    protected String region;

    /**
     * Obtient la valeur de la propriété identifier.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAddressDetailIdentifier }
     *     
     */
    public CustomerAddressDetailIdentifier getIdentifier() {
        return identifier;
    }

    /**
     * Définit la valeur de la propriété identifier.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAddressDetailIdentifier }
     *     
     */
    public void setIdentifier(CustomerAddressDetailIdentifier value) {
        this.identifier = value;
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
     * Obtient la valeur de la propriété addressFormat.
     * 
     * @return
     *     possible object is
     *     {@link AddressFormat }
     *     
     */
    public AddressFormat getAddressFormat() {
        return addressFormat;
    }

    /**
     * Définit la valeur de la propriété addressFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressFormat }
     *     
     */
    public void setAddressFormat(AddressFormat value) {
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
     * Obtient la valeur de la propriété poBox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoBox() {
        return poBox;
    }

    /**
     * Définit la valeur de la propriété poBox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoBox(String value) {
        this.poBox = value;
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
     *     {@link Country }
     *     
     */
    public Country getCountryCode() {
        return countryCode;
    }

    /**
     * Définit la valeur de la propriété countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountryCode(Country value) {
        this.countryCode = value;
    }

    /**
     * Obtient la valeur de la propriété counterCode.
     * 
     * @return
     *     possible object is
     *     {@link Branch }
     *     
     */
    public Branch getCounterCode() {
        return counterCode;
    }

    /**
     * Définit la valeur de la propriété counterCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Branch }
     *     
     */
    public void setCounterCode(Branch value) {
        this.counterCode = value;
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
     * Obtient la valeur de la propriété service.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Définit la valeur de la propriété service.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
    }

    /**
     * Obtient la valeur de la propriété typeOfTransportCode.
     * 
     * @return
     *     possible object is
     *     {@link TypeOfTransport }
     *     
     */
    public TypeOfTransport getTypeOfTransportCode() {
        return typeOfTransportCode;
    }

    /**
     * Définit la valeur de la propriété typeOfTransportCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOfTransport }
     *     
     */
    public void setTypeOfTransportCode(TypeOfTransport value) {
        this.typeOfTransportCode = value;
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
     * Obtient la valeur de la propriété startingDateOfTemporaryAddress.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartingDateOfTemporaryAddress() {
        return startingDateOfTemporaryAddress;
    }

    /**
     * Définit la valeur de la propriété startingDateOfTemporaryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartingDateOfTemporaryAddress(XMLGregorianCalendar value) {
        this.startingDateOfTemporaryAddress = value;
    }

    /**
     * Obtient la valeur de la propriété endingDateOfTemporaryAddress.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndingDateOfTemporaryAddress() {
        return endingDateOfTemporaryAddress;
    }

    /**
     * Définit la valeur de la propriété endingDateOfTemporaryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndingDateOfTemporaryAddress(XMLGregorianCalendar value) {
        this.endingDateOfTemporaryAddress = value;
    }

    /**
     * Obtient la valeur de la propriété numberOfReturnMailsForWrongAddress.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfReturnMailsForWrongAddress() {
        return numberOfReturnMailsForWrongAddress;
    }

    /**
     * Définit la valeur de la propriété numberOfReturnMailsForWrongAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfReturnMailsForWrongAddress(Integer value) {
        this.numberOfReturnMailsForWrongAddress = value;
    }

    /**
     * Obtient la valeur de la propriété dateOfFirstReturnMailForWrongAddress.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfFirstReturnMailForWrongAddress() {
        return dateOfFirstReturnMailForWrongAddress;
    }

    /**
     * Définit la valeur de la propriété dateOfFirstReturnMailForWrongAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfFirstReturnMailForWrongAddress(XMLGregorianCalendar value) {
        this.dateOfFirstReturnMailForWrongAddress = value;
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

    /**
     * Obtient la valeur de la propriété region.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Définit la valeur de la propriété region.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

}
