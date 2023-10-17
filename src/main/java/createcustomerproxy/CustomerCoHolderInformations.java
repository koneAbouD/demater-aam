
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerCoHolderInformations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerCoHolderInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="customerOrThirdParty" type="{http://soprabanking.com/amplitude}customerOrThirdPartyCoHolder" minOccurs="0"/>
 *         &lt;element name="otherCoHolderType" type="{http://soprabanking.com/amplitude}otherCoHolderType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerCoHolderInformations", propOrder = {
    "customerOrThirdParty",
    "otherCoHolderType"
})
public class CustomerCoHolderInformations {

    protected CustomerOrThirdPartyCoHolder customerOrThirdParty;
    protected OtherCoHolderType otherCoHolderType;

    /**
     * Obtient la valeur de la propriété customerOrThirdParty.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrThirdPartyCoHolder }
     *     
     */
    public CustomerOrThirdPartyCoHolder getCustomerOrThirdParty() {
        return customerOrThirdParty;
    }

    /**
     * Définit la valeur de la propriété customerOrThirdParty.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrThirdPartyCoHolder }
     *     
     */
    public void setCustomerOrThirdParty(CustomerOrThirdPartyCoHolder value) {
        this.customerOrThirdParty = value;
    }

    /**
     * Obtient la valeur de la propriété otherCoHolderType.
     * 
     * @return
     *     possible object is
     *     {@link OtherCoHolderType }
     *     
     */
    public OtherCoHolderType getOtherCoHolderType() {
        return otherCoHolderType;
    }

    /**
     * Définit la valeur de la propriété otherCoHolderType.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherCoHolderType }
     *     
     */
    public void setOtherCoHolderType(OtherCoHolderType value) {
        this.otherCoHolderType = value;
    }

}
