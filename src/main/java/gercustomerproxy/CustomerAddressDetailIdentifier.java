
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerAddressDetailIdentifier complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerAddressDetailIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}charMax15"/>
 *         &lt;element name="addressType" type="{http://soprabanking.com/amplitude}addressType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAddressDetailIdentifier", propOrder = {
    "customerCode",
    "addressType"
})
public class CustomerAddressDetailIdentifier {

    @XmlElement(required = true)
    protected String customerCode;
    @XmlElement(required = true)
    protected AddressType addressType;

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
     * Obtient la valeur de la propri�t� addressType.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddressType() {
        return addressType;
    }

    /**
     * D�finit la valeur de la propri�t� addressType.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddressType(AddressType value) {
        this.addressType = value;
    }

}
