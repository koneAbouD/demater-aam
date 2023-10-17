
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCustomerDetailRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomerDetailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerIdentifier" type="{http://soprabanking.com/amplitude}customerIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerDetailRequest", propOrder = {
    "customerIdentifier"
})
public class GetCustomerDetailRequest {

    @XmlElement(required = true)
    protected CustomerIdentifier customerIdentifier;

    /**
     * Obtient la valeur de la propriété customerIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIdentifier }
     *     
     */
    public CustomerIdentifier getCustomerIdentifier() {
        return customerIdentifier;
    }

    /**
     * Définit la valeur de la propriété customerIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIdentifier }
     *     
     */
    public void setCustomerIdentifier(CustomerIdentifier value) {
        this.customerIdentifier = value;
    }

}
