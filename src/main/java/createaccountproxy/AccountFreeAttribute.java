
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountFreeAttribute complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountFreeAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}internalAccountKey" minOccurs="0"/>
 *         &lt;element name="additionalData" type="{http://soprabanking.com/amplitude}additionalData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountFreeAttribute", propOrder = {
    "accountIdentifier",
    "additionalData"
})
public class AccountFreeAttribute {

    protected InternalAccountKey accountIdentifier;
    @XmlElement(required = true)
    protected AdditionalData additionalData;

    /**
     * Obtient la valeur de la propriété accountIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link InternalAccountKey }
     *     
     */
    public InternalAccountKey getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Définit la valeur de la propriété accountIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalAccountKey }
     *     
     */
    public void setAccountIdentifier(InternalAccountKey value) {
        this.accountIdentifier = value;
    }

    /**
     * Obtient la valeur de la propriété additionalData.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalData }
     *     
     */
    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    /**
     * Définit la valeur de la propriété additionalData.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalData }
     *     
     */
    public void setAdditionalData(AdditionalData value) {
        this.additionalData = value;
    }

}
