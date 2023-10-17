
package createaccountproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyAccountContactsRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyAccountContactsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountIdentifier" type="{http://soprabanking.com/amplitude}internalAccountKey" minOccurs="0"/>
 *         &lt;element name="accountContact" type="{http://soprabanking.com/amplitude}accountContact" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyAccountContactsRequest", propOrder = {
    "accountIdentifier",
    "accountContact"
})
public class ModifyAccountContactsRequest {

    protected InternalAccountKey accountIdentifier;
    protected List<AccountContact> accountContact;

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
     * Gets the value of the accountContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountContact }
     * 
     * 
     */
    public List<AccountContact> getAccountContact() {
        if (accountContact == null) {
            accountContact = new ArrayList<AccountContact>();
        }
        return this.accountContact;
    }

}
