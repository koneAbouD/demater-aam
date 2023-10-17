
package createcustomerproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerShareholdersCreate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerShareholdersCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shareholder" type="{http://soprabanking.com/amplitude}createCustomerShareholderRequest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerShareholdersCreate", propOrder = {
    "shareholder"
})
public class CustomerShareholdersCreate {

    protected List<CreateCustomerShareholderRequest> shareholder;

    /**
     * Gets the value of the shareholder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shareholder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShareholder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreateCustomerShareholderRequest }
     * 
     * 
     */
    public List<CreateCustomerShareholderRequest> getShareholder() {
        if (shareholder == null) {
            shareholder = new ArrayList<CreateCustomerShareholderRequest>();
        }
        return this.shareholder;
    }

}
