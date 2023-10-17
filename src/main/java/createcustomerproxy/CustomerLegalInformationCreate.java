
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerLegalInformationCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerLegalInformationCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tradeRegisterNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="deliveryDateOfTradeRegister" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="tradeRegisterDeliveryPlace" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="validityDateOfTradeRegister" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="chamberOfCommerceCode" type="{http://soprabanking.com/amplitude}chamberOfCommerceCode" minOccurs="0"/>
 *         &lt;element name="licenseNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="validityDateOfLicense" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerLegalInformationCreate", propOrder = {
    "tradeRegisterNumber",
    "deliveryDateOfTradeRegister",
    "tradeRegisterDeliveryPlace",
    "validityDateOfTradeRegister",
    "chamberOfCommerceCode",
    "licenseNumber",
    "validityDateOfLicense"
})
public class CustomerLegalInformationCreate {

    protected String tradeRegisterNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDateOfTradeRegister;
    protected String tradeRegisterDeliveryPlace;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDateOfTradeRegister;
    protected String chamberOfCommerceCode;
    protected String licenseNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDateOfLicense;

    /**
     * Obtient la valeur de la propri�t� tradeRegisterNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeRegisterNumber() {
        return tradeRegisterNumber;
    }

    /**
     * D�finit la valeur de la propri�t� tradeRegisterNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeRegisterNumber(String value) {
        this.tradeRegisterNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� deliveryDateOfTradeRegister.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDateOfTradeRegister() {
        return deliveryDateOfTradeRegister;
    }

    /**
     * D�finit la valeur de la propri�t� deliveryDateOfTradeRegister.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDateOfTradeRegister(XMLGregorianCalendar value) {
        this.deliveryDateOfTradeRegister = value;
    }

    /**
     * Obtient la valeur de la propri�t� tradeRegisterDeliveryPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeRegisterDeliveryPlace() {
        return tradeRegisterDeliveryPlace;
    }

    /**
     * D�finit la valeur de la propri�t� tradeRegisterDeliveryPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeRegisterDeliveryPlace(String value) {
        this.tradeRegisterDeliveryPlace = value;
    }

    /**
     * Obtient la valeur de la propri�t� validityDateOfTradeRegister.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDateOfTradeRegister() {
        return validityDateOfTradeRegister;
    }

    /**
     * D�finit la valeur de la propri�t� validityDateOfTradeRegister.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDateOfTradeRegister(XMLGregorianCalendar value) {
        this.validityDateOfTradeRegister = value;
    }

    /**
     * Obtient la valeur de la propri�t� chamberOfCommerceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChamberOfCommerceCode() {
        return chamberOfCommerceCode;
    }

    /**
     * D�finit la valeur de la propri�t� chamberOfCommerceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChamberOfCommerceCode(String value) {
        this.chamberOfCommerceCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� licenseNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * D�finit la valeur de la propri�t� licenseNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseNumber(String value) {
        this.licenseNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� validityDateOfLicense.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDateOfLicense() {
        return validityDateOfLicense;
    }

    /**
     * D�finit la valeur de la propri�t� validityDateOfLicense.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDateOfLicense(XMLGregorianCalendar value) {
        this.validityDateOfLicense = value;
    }

}
