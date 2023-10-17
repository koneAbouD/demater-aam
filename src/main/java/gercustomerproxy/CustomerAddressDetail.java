
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� identifier.
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
     * D�finit la valeur de la propri�t� identifier.
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
     * Obtient la valeur de la propri�t� language.
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
     * D�finit la valeur de la propri�t� language.
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
     * Obtient la valeur de la propri�t� addressFormat.
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
     * D�finit la valeur de la propri�t� addressFormat.
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
     * Obtient la valeur de la propri�t� poBox.
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
     * D�finit la valeur de la propri�t� poBox.
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
     *     {@link Country }
     *     
     */
    public Country getCountryCode() {
        return countryCode;
    }

    /**
     * D�finit la valeur de la propri�t� countryCode.
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
     * Obtient la valeur de la propri�t� counterCode.
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
     * D�finit la valeur de la propri�t� counterCode.
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
     * Obtient la valeur de la propri�t� service.
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
     * D�finit la valeur de la propri�t� service.
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
     * Obtient la valeur de la propri�t� typeOfTransportCode.
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
     * D�finit la valeur de la propri�t� typeOfTransportCode.
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
     * Obtient la valeur de la propri�t� startingDateOfTemporaryAddress.
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
     * D�finit la valeur de la propri�t� startingDateOfTemporaryAddress.
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
     * Obtient la valeur de la propri�t� endingDateOfTemporaryAddress.
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
     * D�finit la valeur de la propri�t� endingDateOfTemporaryAddress.
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
     * Obtient la valeur de la propri�t� numberOfReturnMailsForWrongAddress.
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
     * D�finit la valeur de la propri�t� numberOfReturnMailsForWrongAddress.
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
     * Obtient la valeur de la propri�t� dateOfFirstReturnMailForWrongAddress.
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
     * D�finit la valeur de la propri�t� dateOfFirstReturnMailForWrongAddress.
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

    /**
     * Obtient la valeur de la propri�t� region.
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
     * D�finit la valeur de la propri�t� region.
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
