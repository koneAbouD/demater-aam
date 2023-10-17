
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createCustomerPhoneNumberRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createCustomerPhoneNumberRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://soprabanking.com/amplitude}phoneNumberCreateIdentifier"/>
 *         &lt;element name="phoneNumber" type="{http://soprabanking.com/amplitude}charMax20"/>
 *         &lt;element name="format" type="{http://soprabanking.com/amplitude}char3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerPhoneNumberRequest", propOrder = {
    "identifier",
    "phoneNumber",
    "format"
})
public class CreateCustomerPhoneNumberRequest {

    @XmlElement(required = true)
    protected PhoneNumberCreateIdentifier identifier;
    @XmlElement(required = true)
    protected String phoneNumber;
    protected String format;

    /**
     * Obtient la valeur de la propri�t� identifier.
     * 
     * @return
     *     possible object is
     *     {@link PhoneNumberCreateIdentifier }
     *     
     */
    public PhoneNumberCreateIdentifier getIdentifier() {
        return identifier;
    }

    /**
     * D�finit la valeur de la propri�t� identifier.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneNumberCreateIdentifier }
     *     
     */
    public void setIdentifier(PhoneNumberCreateIdentifier value) {
        this.identifier = value;
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
     * Obtient la valeur de la propri�t� format.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * D�finit la valeur de la propri�t� format.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

}
