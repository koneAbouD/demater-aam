
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountChequeBookAddress complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountChequeBookAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="useAnExistingAddress" type="{http://soprabanking.com/amplitude}accountUseAnExistingAddress" minOccurs="0"/>
 *         &lt;element name="otherAddress" type="{http://soprabanking.com/amplitude}createAccountAddressRequest" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountChequeBookAddress", propOrder = {
    "useAnExistingAddress",
    "otherAddress"
})
public class AccountChequeBookAddress {

    protected AccountUseAnExistingAddress useAnExistingAddress;
    protected CreateAccountAddressRequest otherAddress;

    /**
     * Obtient la valeur de la propriété useAnExistingAddress.
     * 
     * @return
     *     possible object is
     *     {@link AccountUseAnExistingAddress }
     *     
     */
    public AccountUseAnExistingAddress getUseAnExistingAddress() {
        return useAnExistingAddress;
    }

    /**
     * Définit la valeur de la propriété useAnExistingAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountUseAnExistingAddress }
     *     
     */
    public void setUseAnExistingAddress(AccountUseAnExistingAddress value) {
        this.useAnExistingAddress = value;
    }

    /**
     * Obtient la valeur de la propriété otherAddress.
     * 
     * @return
     *     possible object is
     *     {@link CreateAccountAddressRequest }
     *     
     */
    public CreateAccountAddressRequest getOtherAddress() {
        return otherAddress;
    }

    /**
     * Définit la valeur de la propriété otherAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAccountAddressRequest }
     *     
     */
    public void setOtherAddress(CreateAccountAddressRequest value) {
        this.otherAddress = value;
    }

}
