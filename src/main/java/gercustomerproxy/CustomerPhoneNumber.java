
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerPhoneNumber complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerPhoneNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{http://soprabanking.com/amplitude}restrictedCustomer" minOccurs="0"/>
 *         &lt;element name="phoneType" type="{http://soprabanking.com/amplitude}phoneType" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://soprabanking.com/amplitude}charMax20"/>
 *         &lt;element name="formatOfTelephoneNumber" type="{http://soprabanking.com/amplitude}formatOfTelephoneNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerPhoneNumber", propOrder = {
    "customer",
    "phoneType",
    "phoneNumber",
    "formatOfTelephoneNumber"
})
public class CustomerPhoneNumber {

    protected RestrictedCustomer customer;
    protected PhoneType phoneType;
    @XmlElement(required = true)
    protected String phoneNumber;
    protected FormatOfTelephoneNumber formatOfTelephoneNumber;

    /**
     * Obtient la valeur de la propri�t� customer.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedCustomer }
     *     
     */
    public RestrictedCustomer getCustomer() {
        return customer;
    }

    /**
     * D�finit la valeur de la propri�t� customer.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedCustomer }
     *     
     */
    public void setCustomer(RestrictedCustomer value) {
        this.customer = value;
    }

    /**
     * Obtient la valeur de la propri�t� phoneType.
     * 
     * @return
     *     possible object is
     *     {@link PhoneType }
     *     
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * D�finit la valeur de la propri�t� phoneType.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneType }
     *     
     */
    public void setPhoneType(PhoneType value) {
        this.phoneType = value;
    }

    /**
     * Obtient la valeur de la propri�t� phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * D�finit la valeur de la propri�t� phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� formatOfTelephoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link FormatOfTelephoneNumber }
     *     
     */
    public FormatOfTelephoneNumber getFormatOfTelephoneNumber() {
        return formatOfTelephoneNumber;
    }

    /**
     * D�finit la valeur de la propri�t� formatOfTelephoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link FormatOfTelephoneNumber }
     *     
     */
    public void setFormatOfTelephoneNumber(FormatOfTelephoneNumber value) {
        this.formatOfTelephoneNumber = value;
    }

}
