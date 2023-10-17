
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountAddressRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createAccountAddressRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountAddressIdentifier" type="{http://soprabanking.com/amplitude}accountAddressIdentifier"/>
 *         &lt;element name="accountAddress" type="{http://soprabanking.com/amplitude}accountAddress"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountAddressRequest", propOrder = {
    "accountAddressIdentifier",
    "accountAddress"
})
public class CreateAccountAddressRequest {

    @XmlElement(required = true)
    protected AccountAddressIdentifier accountAddressIdentifier;
    @XmlElement(required = true)
    protected AccountAddress accountAddress;

    /**
     * Obtient la valeur de la propriété accountAddressIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link AccountAddressIdentifier }
     *     
     */
    public AccountAddressIdentifier getAccountAddressIdentifier() {
        return accountAddressIdentifier;
    }

    /**
     * Définit la valeur de la propriété accountAddressIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAddressIdentifier }
     *     
     */
    public void setAccountAddressIdentifier(AccountAddressIdentifier value) {
        this.accountAddressIdentifier = value;
    }

    /**
     * Obtient la valeur de la propriété accountAddress.
     * 
     * @return
     *     possible object is
     *     {@link AccountAddress }
     *     
     */
    public AccountAddress getAccountAddress() {
        return accountAddress;
    }

    /**
     * Définit la valeur de la propriété accountAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAddress }
     *     
     */
    public void setAccountAddress(AccountAddress value) {
        this.accountAddress = value;
    }

}
