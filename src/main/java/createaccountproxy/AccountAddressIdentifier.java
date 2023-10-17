
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountAddressIdentifier complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountAddressIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}internalAccountKey" minOccurs="0"/>
 *         &lt;element name="addressType" type="{http://soprabanking.com/amplitude}accountAddressType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountAddressIdentifier", propOrder = {
    "accountIdentifier",
    "addressType"
})
public class AccountAddressIdentifier {

    protected InternalAccountKey accountIdentifier;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AccountAddressType addressType;

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
     * Obtient la valeur de la propriété addressType.
     * 
     * @return
     *     possible object is
     *     {@link AccountAddressType }
     *     
     */
    public AccountAddressType getAddressType() {
        return addressType;
    }

    /**
     * Définit la valeur de la propriété addressType.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAddressType }
     *     
     */
    public void setAddressType(AccountAddressType value) {
        this.addressType = value;
    }

}
