
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerMarketingAttributesCreate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerMarketingAttributesCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="freeAttributes" type="{http://soprabanking.com/amplitude}customerFreeAttributesCreate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerMarketingAttributesCreate", propOrder = {
    "freeAttributes"
})
public class CustomerMarketingAttributesCreate {

    protected CustomerFreeAttributesCreate freeAttributes;

    /**
     * Obtient la valeur de la propriété freeAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public CustomerFreeAttributesCreate getFreeAttributes() {
        return freeAttributes;
    }

    /**
     * Définit la valeur de la propriété freeAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public void setFreeAttributes(CustomerFreeAttributesCreate value) {
        this.freeAttributes = value;
    }

}
