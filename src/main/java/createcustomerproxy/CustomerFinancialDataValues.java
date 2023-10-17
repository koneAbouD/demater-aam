
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerFinancialDataValues complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFinancialDataValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="yearValue" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="yearMinus1Value" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="yearMinus2Value" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="yearMinus3Value" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFinancialDataValues", propOrder = {
    "yearValue",
    "yearMinus1Value",
    "yearMinus2Value",
    "yearMinus3Value"
})
public class CustomerFinancialDataValues {

    protected BigDecimal yearValue;
    protected BigDecimal yearMinus1Value;
    protected BigDecimal yearMinus2Value;
    protected BigDecimal yearMinus3Value;

    /**
     * Obtient la valeur de la propriété yearValue.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYearValue() {
        return yearValue;
    }

    /**
     * Définit la valeur de la propriété yearValue.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYearValue(BigDecimal value) {
        this.yearValue = value;
    }

    /**
     * Obtient la valeur de la propriété yearMinus1Value.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYearMinus1Value() {
        return yearMinus1Value;
    }

    /**
     * Définit la valeur de la propriété yearMinus1Value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYearMinus1Value(BigDecimal value) {
        this.yearMinus1Value = value;
    }

    /**
     * Obtient la valeur de la propriété yearMinus2Value.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYearMinus2Value() {
        return yearMinus2Value;
    }

    /**
     * Définit la valeur de la propriété yearMinus2Value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYearMinus2Value(BigDecimal value) {
        this.yearMinus2Value = value;
    }

    /**
     * Obtient la valeur de la propriété yearMinus3Value.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYearMinus3Value() {
        return yearMinus3Value;
    }

    /**
     * Définit la valeur de la propriété yearMinus3Value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYearMinus3Value(BigDecimal value) {
        this.yearMinus3Value = value;
    }

}
