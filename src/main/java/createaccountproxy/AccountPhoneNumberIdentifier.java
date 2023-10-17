
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountPhoneNumberIdentifier complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountPhoneNumberIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}internalAccountKey" minOccurs="0"/>
 *         &lt;element name="phoneType" type="{http://soprabanking.com/amplitude}charMax3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountPhoneNumberIdentifier", propOrder = {
    "accountIdentifier",
    "phoneType"
})
public class AccountPhoneNumberIdentifier {

    protected InternalAccountKey accountIdentifier;
    @XmlElement(required = true)
    protected String phoneType;

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
     * Obtient la valeur de la propriété phoneType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Définit la valeur de la propriété phoneType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneType(String value) {
        this.phoneType = value;
    }

}
