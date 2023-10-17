
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createAccountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}restrictedAccount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountResponse", propOrder = {
    "accountIdentifier"
})
public class CreateAccountResponse {

    @XmlElement(required = true)
    protected RestrictedAccount accountIdentifier;

    /**
     * Obtient la valeur de la propriété accountIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedAccount }
     *     
     */
    public RestrictedAccount getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Définit la valeur de la propriété accountIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedAccount }
     *     
     */
    public void setAccountIdentifier(RestrictedAccount value) {
        this.accountIdentifier = value;
    }

}
