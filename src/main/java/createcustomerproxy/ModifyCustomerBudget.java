
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerBudget complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerBudget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="budgetReferenceYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="averageTaxRate" type="{http://soprabanking.com/amplitude}decimal15_7" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerBudget", propOrder = {
    "customerCode",
    "budgetReferenceYear",
    "averageTaxRate"
})
public class ModifyCustomerBudget {

    protected String customerCode;
    protected Integer budgetReferenceYear;
    protected BigDecimal averageTaxRate;

    /**
     * Obtient la valeur de la propriété customerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Définit la valeur de la propriété customerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Obtient la valeur de la propriété budgetReferenceYear.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBudgetReferenceYear() {
        return budgetReferenceYear;
    }

    /**
     * Définit la valeur de la propriété budgetReferenceYear.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBudgetReferenceYear(Integer value) {
        this.budgetReferenceYear = value;
    }

    /**
     * Obtient la valeur de la propriété averageTaxRate.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAverageTaxRate() {
        return averageTaxRate;
    }

    /**
     * Définit la valeur de la propriété averageTaxRate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAverageTaxRate(BigDecimal value) {
        this.averageTaxRate = value;
    }

}
