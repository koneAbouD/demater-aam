
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountEmailAddressIdentifier complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountEmailAddressIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}internalAccountKey" minOccurs="0"/>
 *         &lt;element name="emailType" type="{http://soprabanking.com/amplitude}charMax3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountEmailAddressIdentifier", propOrder = {
    "accountIdentifier",
    "emailType"
})
public class AccountEmailAddressIdentifier {

    protected InternalAccountKey accountIdentifier;
    @XmlElement(required = true)
    protected String emailType;

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
     * Obtient la valeur de la propriété emailType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * Définit la valeur de la propriété emailType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailType(String value) {
        this.emailType = value;
    }

}
