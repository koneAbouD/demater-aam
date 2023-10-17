
package createaccountproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountPhoneNumbers complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountPhoneNumbers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountPhoneNumber" type="{http://soprabanking.com/amplitude}accountPhoneNumber" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountPhoneNumbers", propOrder = {
    "accountPhoneNumber"
})
public class AccountPhoneNumbers {

    protected List<AccountPhoneNumber> accountPhoneNumber;

    /**
     * Gets the value of the accountPhoneNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountPhoneNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountPhoneNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountPhoneNumber }
     * 
     * 
     */
    public List<AccountPhoneNumber> getAccountPhoneNumber() {
        if (accountPhoneNumber == null) {
            accountPhoneNumber = new ArrayList<AccountPhoneNumber>();
        }
        return this.accountPhoneNumber;
    }

}
