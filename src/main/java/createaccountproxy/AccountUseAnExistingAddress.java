
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountUseAnExistingAddress complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountUseAnExistingAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="existingAddressToBeUsed" type="{http://soprabanking.com/amplitude}accountExistingAddressToBeUsed" minOccurs="0"/>
 *         &lt;element name="codingAddressType" type="{http://soprabanking.com/amplitude}charMax2" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountUseAnExistingAddress", propOrder = {
    "existingAddressToBeUsed",
    "codingAddressType"
})
public class AccountUseAnExistingAddress {

    @XmlSchemaType(name = "string")
    protected AccountExistingAddressToBeUsed existingAddressToBeUsed;
    protected String codingAddressType;

    /**
     * Obtient la valeur de la propriété existingAddressToBeUsed.
     * 
     * @return
     *     possible object is
     *     {@link AccountExistingAddressToBeUsed }
     *     
     */
    public AccountExistingAddressToBeUsed getExistingAddressToBeUsed() {
        return existingAddressToBeUsed;
    }

    /**
     * Définit la valeur de la propriété existingAddressToBeUsed.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountExistingAddressToBeUsed }
     *     
     */
    public void setExistingAddressToBeUsed(AccountExistingAddressToBeUsed value) {
        this.existingAddressToBeUsed = value;
    }

    /**
     * Obtient la valeur de la propriété codingAddressType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodingAddressType() {
        return codingAddressType;
    }

    /**
     * Définit la valeur de la propriété codingAddressType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodingAddressType(String value) {
        this.codingAddressType = value;
    }

}
