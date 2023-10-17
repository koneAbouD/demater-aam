
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerBudgetRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerBudgetRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerBudget" type="{http://soprabanking.com/amplitude}modifyCustomerBudget" minOccurs="0"/>
 *         &lt;element name="customerIncomes" type="{http://soprabanking.com/amplitude}modifyCustomerIncomes" minOccurs="0"/>
 *         &lt;element name="customerCharges" type="{http://soprabanking.com/amplitude}modifyCustomerCharges" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerBudgetRequest", propOrder = {
    "customerBudget",
    "customerIncomes",
    "customerCharges"
})
public class ModifyCustomerBudgetRequest {

    protected ModifyCustomerBudget customerBudget;
    protected ModifyCustomerIncomes customerIncomes;
    protected ModifyCustomerCharges customerCharges;

    /**
     * Obtient la valeur de la propriété customerBudget.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerBudget }
     *     
     */
    public ModifyCustomerBudget getCustomerBudget() {
        return customerBudget;
    }

    /**
     * Définit la valeur de la propriété customerBudget.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerBudget }
     *     
     */
    public void setCustomerBudget(ModifyCustomerBudget value) {
        this.customerBudget = value;
    }

    /**
     * Obtient la valeur de la propriété customerIncomes.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerIncomes }
     *     
     */
    public ModifyCustomerIncomes getCustomerIncomes() {
        return customerIncomes;
    }

    /**
     * Définit la valeur de la propriété customerIncomes.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerIncomes }
     *     
     */
    public void setCustomerIncomes(ModifyCustomerIncomes value) {
        this.customerIncomes = value;
    }

    /**
     * Obtient la valeur de la propriété customerCharges.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerCharges }
     *     
     */
    public ModifyCustomerCharges getCustomerCharges() {
        return customerCharges;
    }

    /**
     * Définit la valeur de la propriété customerCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerCharges }
     *     
     */
    public void setCustomerCharges(ModifyCustomerCharges value) {
        this.customerCharges = value;
    }

}
