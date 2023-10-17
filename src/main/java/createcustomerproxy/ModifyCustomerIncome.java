
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerIncome complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerIncome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="incomeCode" type="{http://soprabanking.com/amplitude}incomeCode" minOccurs="0"/>
 *         &lt;element name="incomePeriodicityCode" type="{http://soprabanking.com/amplitude}periodicity" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://soprabanking.com/amplitude}currencyCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerIncome", propOrder = {
    "incomeCode",
    "incomePeriodicityCode",
    "amount",
    "currency"
})
public class ModifyCustomerIncome {

    protected String incomeCode;
    @XmlSchemaType(name = "string")
    protected Periodicity incomePeriodicityCode;
    protected BigDecimal amount;
    protected String currency;

    /**
     * Obtient la valeur de la propri�t� incomeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeCode() {
        return incomeCode;
    }

    /**
     * D�finit la valeur de la propri�t� incomeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeCode(String value) {
        this.incomeCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� incomePeriodicityCode.
     * 
     * @return
     *     possible object is
     *     {@link Periodicity }
     *     
     */
    public Periodicity getIncomePeriodicityCode() {
        return incomePeriodicityCode;
    }

    /**
     * D�finit la valeur de la propri�t� incomePeriodicityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicity }
     *     
     */
    public void setIncomePeriodicityCode(Periodicity value) {
        this.incomePeriodicityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * D�finit la valeur de la propri�t� amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtient la valeur de la propri�t� currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * D�finit la valeur de la propri�t� currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
