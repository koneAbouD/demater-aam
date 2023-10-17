
package createaccountproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountFreeAttributes complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountFreeAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountFreeAttribute" type="{http://soprabanking.com/amplitude}accountFreeAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountFreeAttributes", propOrder = {
    "accountFreeAttribute"
})
public class AccountFreeAttributes {

    protected List<AccountFreeAttribute> accountFreeAttribute;

    /**
     * Gets the value of the accountFreeAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountFreeAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountFreeAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountFreeAttribute }
     * 
     * 
     */
    public List<AccountFreeAttribute> getAccountFreeAttribute() {
        if (accountFreeAttribute == null) {
            accountFreeAttribute = new ArrayList<AccountFreeAttribute>();
        }
        return this.accountFreeAttribute;
    }

}
