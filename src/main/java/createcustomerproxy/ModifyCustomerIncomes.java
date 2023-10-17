
package createcustomerproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerIncomes complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerIncomes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerIncome" type="{http://soprabanking.com/amplitude}modifyCustomerIncome" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerIncomes", propOrder = {
    "customerIncome"
})
public class ModifyCustomerIncomes {

    protected List<ModifyCustomerIncome> customerIncome;

    /**
     * Gets the value of the customerIncome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerIncome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerIncome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModifyCustomerIncome }
     * 
     * 
     */
    public List<ModifyCustomerIncome> getCustomerIncome() {
        if (customerIncome == null) {
            customerIncome = new ArrayList<ModifyCustomerIncome>();
        }
        return this.customerIncome;
    }

}
